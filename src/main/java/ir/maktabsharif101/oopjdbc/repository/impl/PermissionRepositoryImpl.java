package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;

@SuppressWarnings("unused")
public class PermissionRepositoryImpl
        extends BaseEntityRepositoryImpl
        implements PermissionRepository {

    @Override
    public Permission findByName(String name) {
        return null;
    }
}
