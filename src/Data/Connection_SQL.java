/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Connection_SQL {

    public static Connection getConnection() {
        String Connection_String = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=Mechanical_Workshop;"
                + "user=sa;"
                + "password=popo;"
                + "encrypt=true;trustServerCertificate=true;";

        try {
            Connection con = DriverManager.getConnection(Connection_String);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.toString());
            return null;
        }
    }

    public static boolean Verify_User(int Id, String password) throws SQLException {
        boolean isValidUser = false;

        String qry = "SELECT * FROM Users WHERE Id = '" + Id + "' AND Password = '" + password + "'";

        Statement sql = Connection_SQL.getConnection().createStatement();
        ResultSet rs = sql.executeQuery(qry);

        // Si el ResultSet devuelve un valor, el usuario es valido
        if (rs.next()) {
            isValidUser = true;
        }

        return isValidUser;
    }

    public static String get_Role(int Id, String password) throws SQLException {
        String Role = "";

        String qry = "SELECT Role FROM Users WHERE Id = '" + Id + "' AND Password = '" + password + "'";

        Statement sql = Connection_SQL.getConnection().createStatement();
        ResultSet rs = sql.executeQuery(qry);

        if (rs.next()) {
            Role = rs.getString("Role");
        }

        return Role;
    }
}
