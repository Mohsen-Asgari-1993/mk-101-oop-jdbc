package ir.maktabsharif101.oopjdbc.base.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseEntityRepositoryImpl
        implements BaseEntityRepository {

    protected final Connection connection;

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";

    protected BaseEntityRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseEntity[] findAll() {
        return new BaseEntity[0];
    }

    @Override
    public BaseEntity findById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_BY_ID_QUERY_TEMPLATE,
                        getEntityTableName()
                )
        );
        preparedStatement.setLong(1, id);
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
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("deleted by id : " + id);
    }

    protected abstract String getEntityTableName();

    protected abstract BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException;

}
