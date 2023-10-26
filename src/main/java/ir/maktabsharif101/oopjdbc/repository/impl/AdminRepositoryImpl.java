package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.domain.Admin;
import ir.maktabsharif101.oopjdbc.repository.AdminRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl extends BaseUserRepositoryImpl<Admin>
        implements AdminRepository {

    protected AdminRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Admin.TABLE_NAME;
    }

    @Override
    protected Admin getNewUserInstance() {
        return new Admin();
    }

    @Override
    protected Admin mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Admin admin = super.mapResultSetToEntity(resultSet);
        admin.setSuperAdmin(
                resultSet.getBoolean(8)
        );
        return admin;
    }
}
