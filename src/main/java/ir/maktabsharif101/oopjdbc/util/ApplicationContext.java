package ir.maktabsharif101.oopjdbc.util;

import ir.maktabsharif101.oopjdbc.repository.*;
import ir.maktabsharif101.oopjdbc.repository.impl.*;
import ir.maktabsharif101.oopjdbc.service.*;
import ir.maktabsharif101.oopjdbc.service.impl.*;

@SuppressWarnings("unused")
public class ApplicationContext {

    private static final ApplicationContext applicationContext = new ApplicationContext();

    private PermissionRepository permissionRepository;

    private PermissionService permissionService;

    private RoleRepository roleRepository;

    private RoleService roleService;

    private UserRepository userRepository;

    private UserService userService;

    private CityRepository cityRepository;

    private CityService cityService;

    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private CommentRepository commentRepository;

    private CommentService commentService;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        return applicationContext;
    }

    public PermissionRepository getPermissionRepository() {
        if (permissionRepository == null) {
            permissionRepository = new PermissionRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return permissionRepository;
    }

    public PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = new PermissionServiceImpl(
                    getPermissionRepository()
            );
        }
        return permissionService;
    }

    public RoleRepository getRoleRepository() {
        if (roleRepository == null) {
            roleRepository = new RoleRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return roleRepository;
    }

    public RoleService getRoleService() {
        if (roleService == null) {
            roleService = new RoleServiceImpl(
                    getRoleRepository()
            );
        }
        return roleService;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return userRepository;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository(),
                    getRoleService()
            );
        }
        return userService;
    }

    public CityRepository getCityRepository() {
        if (cityRepository == null) {
            cityRepository = new CityRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return cityRepository;
    }

    public CityService getCityService() {
        if (cityService == null) {
            cityService = new CityServiceImpl(
                    getCityRepository()
            );
        }
        return cityService;
    }

    public CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return customerRepository;
    }

    public CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(
                    getCustomerRepository(),
                    getRoleService()
            );
        }
        return customerService;
    }

    public CommentRepository getCommentRepository() {
        if (commentRepository == null) {
            commentRepository = new CommentRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return commentRepository;
    }

    public CommentService getCommentService() {
        if (commentService == null) {
            commentService = new CommentServiceImpl(
                    getCommentRepository()
            );
        }
        return commentService;
    }
}
