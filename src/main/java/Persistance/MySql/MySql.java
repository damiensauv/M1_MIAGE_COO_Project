package Persistance.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {

    private static Connection connection;

    private MySql() {
        try {
            initConnexion();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // connection a la base MySql
    private void initConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://webtp.fil.univ-lille1.fr/sauvalle", "sauvalle", "*****");
    }

    public static Connection getInstance() {
        if (connection == null) {
            new MySql();
        }
        return connection;
    }
}
