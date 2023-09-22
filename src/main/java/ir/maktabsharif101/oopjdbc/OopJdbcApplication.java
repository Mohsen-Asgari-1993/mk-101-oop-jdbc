package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println(
                "permissions: " + Arrays.toString(ApplicationContext.getInstance().getPermissionRepository().findAll())
        );

        System.out.println(
                "roles: " + Arrays.toString(ApplicationContext.getInstance().getRoleRepository().findAll())
        );

        System.out.println(
                "users: " + Arrays.toString(ApplicationContext.getInstance().getUserRepository().findAll())
        );

    }
}
