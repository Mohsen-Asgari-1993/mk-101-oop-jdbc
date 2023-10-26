package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class PermissionRepositoryImpl
        extends BaseEntityRepositoryImpl<Permission, Long>
        implements PermissionRepository {

    public PermissionRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Permission.TABLE_NAME;
    }

    @Override
    protected Permission mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        /*Permission permission = new Permission();
        permission.setId(resultSet.getLong(1));
        permission.setName(resultSet.getString(2));
        return permission;*/
        return new Permission(
                resultSet.getLong(1),
                resultSet.getString(2)
        );
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return Permission.NAME;
    }

    @Override
    protected String getInsertValuesForFirstApproach(Permission entity) {
//        return "'user-create'";
        return "'".concat(entity.getName()).concat("'");
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Permission.NAME
        };
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      Permission entity) throws SQLException {
//        inset into permission_tbl(name) values(?)
        preparedStatement.setString(
                1,
                ((Permission) entity).getName()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                        Permission entity) throws SQLException {
        preparedStatement.setString(
                1,
                ((Permission) entity).getName()
        );
        preparedStatement.setLong(
                2,
                entity.getId()
        );
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(
                parameterIndex, id
        );
    }

    @Override
    protected void setGenerateKey(Permission entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }

    @Override
    public Permission findByName(String name) {
        return null;
    }
}
