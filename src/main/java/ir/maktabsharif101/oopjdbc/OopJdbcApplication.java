package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        User beforeUpdate = (User) ApplicationContext.getInstance().getUserService().findById(3L);
        System.out.println(
                "before update: " + beforeUpdate
        );
        beforeUpdate.setFirstName(
                beforeUpdate.getFirstName() + beforeUpdate.getFirstName().length()
        );
        beforeUpdate.setPassword(
                "9876543210"
        );
        ApplicationContext.getInstance().getUserService().update(beforeUpdate);

        User afterUpdate = (User) ApplicationContext.getInstance().getUserService().findById(3L);
        System.out.println(
                "after update: " + afterUpdate
        );

    }
}
