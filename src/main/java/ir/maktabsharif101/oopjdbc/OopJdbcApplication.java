package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.service.PermissionService;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.service.UserService;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

public class OopJdbcApplication {

    public static void main(String[] args) {

        RoleService roleService = ApplicationContext.getRoleService();

        UserService userService = ApplicationContext.getUserService();

        PermissionService permissionService = ApplicationContext.getPermissionService();

//        impl logic

    }
}
