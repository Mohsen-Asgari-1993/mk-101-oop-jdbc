package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.service.UserService;

import java.sql.SQLException;

@SuppressWarnings("unused")
public class UserServiceImpl
        extends BaseEntityServiceImpl
        implements UserService {

    private final RoleService roleService;

    public UserServiceImpl(UserRepository baseRepository, RoleService roleService) {
        super(baseRepository);
        this.roleService = roleService;
    }

    @Override
    public BaseEntity save(BaseEntity entity) throws SQLException {
//        TODO use role service
        return super.save(entity);
    }

    @Override
    public User findByUsername(String username) {
        return ((UserRepository) baseRepository).findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return ((UserRepository) baseRepository).existsByUsername(username);
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return ((UserRepository) baseRepository).existsByMobileNumber(mobileNumber);
    }
}
