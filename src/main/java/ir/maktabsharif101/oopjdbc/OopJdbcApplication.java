package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println(
                ApplicationContext.getInstance().getCityService().count()
        );

    }
}
