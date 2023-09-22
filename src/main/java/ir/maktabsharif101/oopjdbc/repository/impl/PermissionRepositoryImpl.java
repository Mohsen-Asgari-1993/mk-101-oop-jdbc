package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class PermissionRepositoryImpl
        extends BaseEntityRepositoryImpl
        implements PermissionRepository {

    public PermissionRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Permission.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
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
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new Permission[(int) count()];
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return Permission.NAME;
    }

    @Override
    protected String getInsertValuesForFirstApproach(BaseEntity entity) {
//        return "'user-create'";
        return "'".concat(((Permission) entity).getName()).concat("'");
    }

    @Override
    public Permission findByName(String name) {
        return null;
    }
}
