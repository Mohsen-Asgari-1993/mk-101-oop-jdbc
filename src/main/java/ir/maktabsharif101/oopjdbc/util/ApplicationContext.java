package ir.maktabsharif101.oopjdbc.util;

import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;
import ir.maktabsharif101.oopjdbc.repository.impl.PermissionRepositoryImpl;
import ir.maktabsharif101.oopjdbc.repository.impl.RoleRepositoryImpl;
import ir.maktabsharif101.oopjdbc.repository.impl.UserRepositoryImpl;
import ir.maktabsharif101.oopjdbc.service.PermissionService;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.service.UserService;
import ir.maktabsharif101.oopjdbc.service.impl.PermissionServiceImpl;
import ir.maktabsharif101.oopjdbc.service.impl.RoleServiceImpl;
import ir.maktabsharif101.oopjdbc.service.impl.UserServiceImpl;

@SuppressWarnings("unused")
public class ApplicationContext {

    private static RoleRepository roleRepository;

    private static RoleService roleService;

    private static PermissionRepository permissionRepository;

    private static PermissionService permissionService;

    private static UserRepository userRepository;

    private static UserService userService;

    private ApplicationContext() {
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null) {
            roleRepository = new RoleRepositoryImpl();
        }
        return roleRepository;
    }

    public static RoleService getRoleService() {
        if (roleService == null) {
            roleService = new RoleServiceImpl(
                    getRoleRepository()
            );
        }
        return roleService;
    }

    public static PermissionRepository getPermissionRepository() {
        if (permissionRepository == null) {
            permissionRepository = new PermissionRepositoryImpl();
        }
        return permissionRepository;
    }

    public static PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = new PermissionServiceImpl(
                    getPermissionRepository()
            );
        }
        return permissionService;
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository(),
                    getRoleService()
            );
        }
        return userService;
    }
}
