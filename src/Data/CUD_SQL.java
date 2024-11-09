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
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class CUD_SQL {

    public static int Insert_User(User_Creator User) throws SQLException {
        int Affected_Rows;

        String qry = "Insert Into User (Id, Name, Password, Role) "
                + "VALUES ('" + User.getId() + "', '"
                + User.getName() + "', '"
                + User.getPassword() + "', '"
                + User.getRole() + "')";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);

        return Affected_Rows;

    }

    public static int Insert_Vehicle(Vehicle_Obj Vehicle) throws SQLException {
        int Affected_Rows;

        String qry = "INSERT INTO Vehicles (LicensePlate, Brand, Model, Year, Color, Type, SeatCount, LoadCapacity) "
                + "VALUES ('" + Vehicle.getLicensePlate() + "', '"
                + Vehicle.getBrand() + "', '"
                + Vehicle.getModel() + "', "
                + Vehicle.getYear() + ", '"
                + Vehicle.getColor() + "', '"
                + Vehicle.getType() + "', "
                + Vehicle.getSeatCount() + ", "
                + Vehicle.getLoad_Capacity() + ")";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);

        return Affected_Rows;

    }

}
