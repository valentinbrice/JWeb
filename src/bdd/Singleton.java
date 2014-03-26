package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import org.postgresql.Driver;

public class Singleton {

    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/JBDDWEB";
    public static final String USERNAME = "vbrice";
    public static final String PASSWORD = "23nesjose@";

    public static Connection CONNECTION;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");
            CONNECTION = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
