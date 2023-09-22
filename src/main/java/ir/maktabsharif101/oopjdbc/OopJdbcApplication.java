package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        System.out.println(
                ApplicationContext.getInstance().getUserRepository().count()
        );
        User user = new User();
        user.setFirstName("mohsen");
        user.setLastName("asgari");
        user.setUsername("mat");
        user.setPassword("123456789");
        System.out.println(
                ApplicationContext.getInstance().getUserRepository().save(
                        user
                )
        );
        System.out.println(
                ApplicationContext.getInstance().getUserRepository().count()
        );

    }
}
