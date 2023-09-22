package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println(
                "role with id 1: " + ApplicationContext.getInstance().getRoleRepository().findById(1L)
        );

        System.out.println(
                "user with id 1: " + ApplicationContext.getInstance().getUserRepository().findById(1L)
        );

        System.out.println(
                "permission with id 1: " + ApplicationContext.getInstance().getPermissionRepository().findById(1L)
        );

        System.out.println(
                "user with id 2: " + ApplicationContext.getInstance().getUserRepository().findById(2L)
        );
    }
}
