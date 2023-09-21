package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;

import java.sql.Connection;

@SuppressWarnings("unused")
public class RoleRepositoryImpl extends BaseEntityRepositoryImpl
        implements RoleRepository {
    public RoleRepositoryImpl(Connection connection) {
        super(connection);
    }
}
