package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println(
                "exists by id user with id  = 1 : " +
                        ApplicationContext.getInstance().getUserRepository().existsById(1L)
        );

        System.out.println(
                "exists by id user with id  = 8 : " +
                        ApplicationContext.getInstance().getUserRepository().existsById(8L)
        );

    }
}
