package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println(
                "count roles: " + ApplicationContext.getInstance().getRoleRepository().count()
        );

        System.out.println(
                "count users: " + ApplicationContext.getInstance().getUserRepository().count()
        );
    }
}
