package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;

import java.sql.Connection;

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
    public Permission findByName(String name) {
        return null;
    }
}
