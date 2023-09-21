package ir.maktabsharif101.oopjdbc.util;

public class ApplicationProperties {

    public static final String DATABASE_NAME = "mk_101_jdbc";
    public static final String DATABASE_URL =
            "jdbc:postgresql://localhost:5432/postgres?currentSchema=" + DATABASE_NAME;
    public static final String DATABASE_USER = "postgres";
    public static final String DATABASE_PASSWORD = "12345678";
}
