package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.service.UserService;

@SuppressWarnings("unused")
public class UserServiceImpl
        extends BaseUserServiceImpl<User, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository baseRepository, RoleService roleService) {
        super(baseRepository, roleService);
    }
}
