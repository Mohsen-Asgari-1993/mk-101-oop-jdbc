package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Role;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class RoleRepositoryImpl extends BaseEntityRepositoryImpl
        implements RoleRepository {

    public RoleRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Role.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getLong(1));
        role.setName(resultSet.getString(2));
//        TODO fill permissions
        return role;
    }
}
