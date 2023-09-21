package ir.maktabsharif101.oopjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    ApplicationProperties.DATABASE_URL,
                    ApplicationProperties.DATABASE_USER,
                    ApplicationProperties.DATABASE_PASSWORD
            );
        } catch (Exception e) {
            System.out.println("wrong database connection");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
