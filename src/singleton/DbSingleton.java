package singleton;

// TODO
// Read https://study.com/academy/lesson/java-modifiers-volatile-synchronized.html

// Lazy Loaded
// Threadsafe

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    // make threadsafe with volatile
    // ensures that it remains a singleton with any changes made inside the JVM
    private static volatile DbSingleton instance = null;
    private static volatile Connection conn = null;

//    private DbSingleton() {
//        // protects from a reflection class
//        if(instance != null) {
//            throw new RuntimeException("Use getInstance() method to create");
//        }
//    }

    private DbSingleton() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            synchronized (DbSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;
    }

    public static DbSingleton getInstance() {
        // Lazy loading
        if (instance == null) {
            // rather than synchronize on the whole method, we check to see if the instance is
            // null and then synchronize
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

}
