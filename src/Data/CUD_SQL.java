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

        String qry = "Insert Into Users (Id, Name, Password, Role) "
                + "VALUES ('" + User.getId() + "', '"
                + User.getName() + "', '"
                + User.getPassword() + "', '"
                + User.getRole() + "')";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return Affected_Rows;

    }

    public static int Update_User(User_Creator User) throws SQLException {
        int Affected_Rows;

        String qry = "Update Users SET "
                + "Name = '" + User.getName() + "', "
                + "Password = '" + User.getPassword() + "', "
                + "Role = '" + User.getRole() + "' "
                + "WHERE Id = " + User.getId();

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return Affected_Rows;

    }

    public static int Insert_Vehicle(Vehicle_Obj Vehicle) throws SQLException {
        int Affected_Rows;

        String qry = "Insert Into Vehicle (LicensePlate, Brand, Model, Year, Color, Type, SeatCount, LoadCapacity) "
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
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return Affected_Rows;

    }

    public static int Update_Vehicle(Vehicle_Obj Vehicle) throws SQLException {
        int Affected_Rows;

        // Crear la consulta de actualización
        String qry = "UPDATE Vehicle SET "
                + "Brand = '" + Vehicle.getBrand() + "', "
                + "Model = '" + Vehicle.getModel() + "', "
                + "Year = " + Vehicle.getYear() + ", "
                + "Color = '" + Vehicle.getColor() + "', "
                + "Type = '" + Vehicle.getType() + "', "
                + "SeatCount = " + Vehicle.getSeatCount() + ", "
                + "LoadCapacity = " + Vehicle.getLoad_Capacity()
                + " WHERE LicensePlate = " + Vehicle.getLicensePlate();

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);

        if (Affected_Rows > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar", "Aviso importante", JOptionPane.WARNING_MESSAGE);
        }

        return Affected_Rows;
    }

}