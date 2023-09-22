package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println(
                "count users before delete user with id = 10: " +
                        ApplicationContext.getInstance().getUserService().count()
        );

        ApplicationContext.getInstance().getUserService().deleteById(10L);

        System.out.println(
                "count users after delete user with id = 10: " +
                        ApplicationContext.getInstance().getUserService().count()
        );


        System.out.println(
                "count users before delete user with id = 2: " +
                        ApplicationContext.getInstance().getUserService().count()
        );

        ApplicationContext.getInstance().getUserService().deleteById(2L);

        System.out.println(
                "count users after delete user with id = 2: " +
                        ApplicationContext.getInstance().getUserService().count()
        );

    }
}
