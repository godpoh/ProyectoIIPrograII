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

    public static int Update_User_Status(int User_Id, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;
        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar al usuario como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar al usuario como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message,
                "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Users Set Status = " + Status + " Where Id = " + User_Id;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El usuario ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }
        return Rows_Affected;
    }

    public static int Insert_Vehicle(Vehicle_Obj Vehicle) throws SQLException {
        int Affected_Rows;

        String qry = "Insert Into Vehicle (License_Plate, Brand, Model, Year, Color, Type, Seat_Count, Load_Capacity) "
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
                + "Seat_Count = " + Vehicle.getSeatCount() + ", "
                + "Load_Capacity = " + Vehicle.getLoad_Capacity()
                + " WHERE License_Plate = " + Vehicle.getLicensePlate();

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);

        if (Affected_Rows > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar", "Aviso importante", JOptionPane.WARNING_MESSAGE);
        }

        return Affected_Rows;
    }

    public static int Insert_Fuel(Fuel_Obj Fuel) throws SQLException {
        String qry = "INSERT INTO Fuel (Fuel_ID, Name, Type, Price_Per_Liter) "
                + "VALUES (" + Fuel.getFuel_Id() + ", '"
                + Fuel.getName() + "', '"
                + Fuel.getType() + "', "
                + Fuel.getPrice_Per_Liter() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();

        int Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return Affected_Rows;
    }

    public static int Update_Fuel(Fuel_Obj Fuel) throws SQLException {
        String qry = "UPDATE Fuel SET "
                + "Name = '" + Fuel.getName() + "', "
                + "Type = '" + Fuel.getType() + "', "
                + "Price_Per_Liter = " + Fuel.getPrice_Per_Liter()
                + " WHERE Fuel_ID = " + Fuel.getFuel_Id();

        Statement sql = Connection_SQL.getConnection().createStatement();

        int Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return Affected_Rows;
    }

    public static int Insert_Part(Part_Obj part) throws SQLException {
        String qry = "Insert Into Equipment_Parts (Part_ID, Part_Name, Part_Category, Manu_Facturer, Compatibility, Warranty_Period, Unit_Cost) "
                + "Values (" + part.getPart_Id() + ", '"
                + part.getPart_Name() + "', '"
                + part.getPart_Category() + "', '"
                + part.getManu_Facturer() + "', '"
                + part.getCompatibility() + "', "
                + part.getWarrantly_Period() + ", "
                + part.getUnit_Cost() + ")";
        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Pieza guardada satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return affectedRows;
    }

    public static int Update_Part(Part_Obj part) throws SQLException {
        String qry = "Update Equipment_Parts Set "
                + "Part_Name = '" + part.getPart_Name() + "', "
                + "Part_Category = '" + part.getPart_Category() + "', "
                + "Manu_Facturer = '" + part.getManu_Facturer() + "', "
                + "Compatibility = '" + part.getCompatibility() + "', "
                + "Warranty_Period = " + part.getWarrantly_Period() + ", "
                + "Unit_Cost = " + part.getUnit_Cost() + " "
                + "Where Part_ID = " + part.getPart_Id();

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Pieza actualizada satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return affectedRows;
    }

    public static int Insert_Maintenance_Type(Maintenance_Type_Obj maintenance) throws SQLException {
        String qry = "Insert Into Maintenance_Types (Maintenance_Id, Type, Description, Frequency, Material_Cost_Estimate, Vehicle_Id) "
                + "Values (" + maintenance.getMaintenance_Id() + ", '"
                + maintenance.getType() + "', '"
                + maintenance.getDescription() + "', '"
                + maintenance.getFrequency() + "', "
                + maintenance.getMaterial_Cost_Estimate() + ", "
                + maintenance.getVehicle_Id() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Mantenimiento guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    public static int Update_Maintenance_Type(Maintenance_Type_Obj maintenance) throws SQLException {
        String qry = "Update Maintenance_Types Set "
                + "Type = '" + maintenance.getType() + "', "
                + "Description = '" + maintenance.getDescription() + "', "
                + "Frequency = '" + maintenance.getFrequency() + "', "
                + "Material_Cost_Estimate = " + maintenance.getMaterial_Cost_Estimate() + ", "
                + "Vehicle_Id = " + maintenance.getVehicle_Id() + " "
                + "WHERE Maintenance_Id = " + maintenance.getMaintenance_Id();

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Mantenimiento actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

}
