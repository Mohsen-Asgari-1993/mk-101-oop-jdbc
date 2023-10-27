package ir.maktabsharif101.oopjdbc.base.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseEntityRepository<T, ID> {

    protected final Connection connection;

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String INSERT_QUERY_TEMPLATE = "insert into %s(%s) values(%s)";
    public static final String UPDATE_QUERY_TEMPLATE = "update %s set %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";
    public static final String FIND_ALL_BY_ID_IN_QUERY_TEMPLATE = "select * from %s where id in (%s)";

    protected BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<T> findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_ALL_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> entities = new ArrayList<>();
        while (resultSet.next()) {
            entities.add(
                    mapResultSetToEntity(resultSet)
            );
        }
        return entities;
    }

    @Override
    public T findById(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setObject(1, id);
//        fillIdParamInPreparedStatement(preparedStatement, 1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select count(*) from " + getEntityTableName()
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }

    @Override
    public T save(T entity) throws SQLException {
//        return saveFirstApproach(entity);
        return saveSecondApproach(entity);
    }

    @Override
    public T update(T entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateUpdateQuery()
        );
        fillPreparedStatementParamsForUpdate(preparedStatement, entity);
        preparedStatement.executeUpdate();
        return entity;
    }

    @Override
    public boolean existsById(ID id) throws SQLException {
//        return existsByIdWithCount(id);
        return existsByIdWithIdSelection(id);
    }

    @Override
    public void deleteById(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setObject(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<T> findAllByIdIn(Collection<ID> ids) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateFindAllByIdInQuery(ids.size())
        );
        int index = 1;
        for (ID id : ids) {
            preparedStatement.setObject(index++, id);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> entityList = new ArrayList<>();
        while (resultSet.next()) {
            entityList.add(
                    mapResultSetToEntity(resultSet)
            );
        }
        return entityList;
    }

    protected String generateFindAllByIdInQuery(int size) {
        return String.format(
                FIND_ALL_BY_ID_IN_QUERY_TEMPLATE,
                getEntityTableName(),
                generateQuestionMarkForInsertQuery(size)
        );
    }

    protected boolean existsByIdWithCount(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select count(*) from " + getEntityTableName() + " where id = ?"
        );
        preparedStatement.setObject(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1) > 0;
    }

    protected boolean existsByIdWithIdSelection(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select id from " + getEntityTableName() + " where id = ?"
        );
        preparedStatement.setObject(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    protected T saveFirstApproach(T entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        INSERT_QUERY_TEMPLATE,
                        getEntityTableName(),
                        getInsertColumnsForFirstApproach(),
                        getInsertValuesForFirstApproach(entity)
                ),
                Statement.RETURN_GENERATED_KEYS
        );

        return setGenerateKeyAndReturnEntity(entity, preparedStatement);
    }

    protected T saveSecondApproach(T entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                generateSaveSecondApproachQuery(),
                Statement.RETURN_GENERATED_KEYS
        );
        fillPreparedStatementParamsForSave(preparedStatement, entity);

        return setGenerateKeyAndReturnEntity(entity, preparedStatement);
    }

    protected T setGenerateKeyAndReturnEntity(T entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.executeUpdate();
        ResultSet generatedKeysResultSet = preparedStatement.getGeneratedKeys();
        generatedKeysResultSet.next();
        setGenerateKey(entity, generatedKeysResultSet);
        return entity;
    }

    protected String generateSaveSecondApproachQuery() {
        String[] insertColumns = getInsertColumnsForSecondApproach();

        return String.format(
                INSERT_QUERY_TEMPLATE,
                getEntityTableName(),
                String.join(",", insertColumns),
                generateQuestionMarkForInsertQuery(insertColumns.length)
        );
//        insert into user_tbl(first_name, last_name) values(?, ?)
    }

    private String generateQuestionMarkForInsertQuery(int length) {
        String questionMarks = "";
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                questionMarks = questionMarks.concat("?");
            } else {
                questionMarks = questionMarks.concat("?, ");
            }
//            questionMarks = questionMarks.concat("?,");
        }
        return questionMarks;
//        ?,?,?,?,
//        return questionMarks.substring(0, questionMarks.length() - 1);
    }

    protected String generateUpdateQuery() {
        String[] updateColumns = getInsertColumnsForSecondApproach();

        String setClause = "";
        for (String updateColumn : updateColumns) {
            setClause = setClause.concat(updateColumn).concat(" = ?,");
        }
//        first_name = ?, last_name = ?,
        setClause = setClause.substring(0, setClause.length() - 1);
//        first_name = ?, last_name = ?
        return String.format(
                UPDATE_QUERY_TEMPLATE,
                getEntityTableName(),
                setClause
        );
    }

    protected abstract String[] getInsertColumnsForSecondApproach();

    protected abstract String getEntityTableName();

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract String getInsertColumnsForFirstApproach();

    protected abstract String getInsertValuesForFirstApproach(T entity);

    protected abstract void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                               T entity) throws SQLException;

    protected abstract void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                                 T entity) throws SQLException;

    protected abstract void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, ID id) throws SQLException;

    protected abstract void setGenerateKey(T entity, ResultSet generatedKeysResultSet) throws SQLException;

}
