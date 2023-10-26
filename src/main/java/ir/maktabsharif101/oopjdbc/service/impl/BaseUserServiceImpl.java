package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.BaseUserRepository;
import ir.maktabsharif101.oopjdbc.service.BaseUserService;
import ir.maktabsharif101.oopjdbc.service.RoleService;

import java.sql.SQLException;

public class BaseUserServiceImpl<T extends User, R extends BaseUserRepository<T>>
        extends BaseEntityServiceImpl<T, Long, R>
        implements BaseUserService<T> {

    protected final RoleService roleService;

    public BaseUserServiceImpl(R baseRepository, RoleService roleService) {
        super(baseRepository);
        this.roleService = roleService;
    }

    @Override
    public T findByUsername(String username) throws SQLException {
        return baseRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return baseRepository.existsByUsername(username);
    }
}
