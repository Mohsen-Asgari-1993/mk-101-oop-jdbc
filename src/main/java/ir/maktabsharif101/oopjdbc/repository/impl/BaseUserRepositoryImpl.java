package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.BaseUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseUserRepositoryImpl<T extends User> extends BaseEntityRepositoryImpl<T, Long>
        implements BaseUserRepository<T> {

    public static final String FIND_BY_USERNAME_QUERY_TEMPLATE = "select * from %s where username = ?";

    protected BaseUserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                User.FIRST_NAME,
                User.LAST_NAME,
                User.USERNAME,
                User.PASSWORD
        };
    }

    @Override
    protected T mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        T t = getNewUserInstance();
        t.setId(
                resultSet.getLong(1)
        );
        t.setFirstName(
                resultSet.getString(2)
        );
        t.setLastName(
                resultSet.getString(3)
        );
        t.setUsername(
                resultSet.getString(4)
        );
        t.setPassword(
                resultSet.getString(5)
        );
        return t;
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return User.FIRST_NAME.concat(", ").concat(User.LAST_NAME).concat(", ").concat(User.USERNAME)
                .concat(", ").concat(User.PASSWORD);
    }

    @Override
    protected String getInsertValuesForFirstApproach(T user) {
        return "'".concat(user.getFirstName()).concat("', ").
                concat("'").concat(user.getLastName()).concat("', ").
                concat("'").concat(user.getUsername()).concat("', ").
                concat("'").concat(user.getPassword()).concat("'");
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, T user) throws SQLException {
        preparedStatement.setString(
                1,
                user.getFirstName()
        );
        preparedStatement.setString(
                2,
                user.getLastName()
        );
        preparedStatement.setString(
                3,
                user.getUsername()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, T user) throws SQLException {
        preparedStatement.setString(
                1,
                user.getFirstName()
        );
        preparedStatement.setString(
                2,
                user.getLastName()
        );
        preparedStatement.setString(
                3,
                user.getUsername()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );
        preparedStatement.setLong(
                5,
                user.getId()
        );
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(
                parameterIndex, id
        );
    }

    @Override
    protected void setGenerateKey(T entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }

    @Override
    public T findByUsername(String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_BY_USERNAME_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public List<T> findAllByMobileNumber(String mobileNumber) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return false;
    }

    protected abstract T getNewUserInstance();

}
