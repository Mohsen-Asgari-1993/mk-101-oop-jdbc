package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.service.PermissionService;
import ir.maktabsharif101.oopjdbc.service.RoleService;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

public class OopJdbcApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = ApplicationContext.getInstance();

        PermissionService permissionService = applicationContext.getPermissionService();

        RoleService roleService = applicationContext.getRoleService();

//        impl logic

    }
}
