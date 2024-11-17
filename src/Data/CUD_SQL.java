/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    // Metodo para encriptar la contrasena del usuario
    public static String EncryptMD5(String S) {
        try {
            MessageDigest Md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = Md.digest(S.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String HashSet = number.toString(16);

            while (HashSet.length() < 32) {
                HashSet = "0" + HashSet;
            }

            return HashSet;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para insertar los Usuarios
    public static int Insert_User(User_Creator User) throws SQLException {
        int Affected_Rows;

        String qry = "Insert Into Users (Id, Name, Password, Role, Status) "
                + "Values ('" + User.getId() + "', '"
                + User.getName() + "', '"
                + User.getPassword() + "', '"
                + User.getRole() + "', "
                + User.getStatus() + ")";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return Affected_Rows;

    }

    // Metodo para actualizar el Usuario
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

    // Metodo para actualizar el estado del usuario
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

    // Metodo para insertar vehiculos
    public static int Insert_Vehicle(Vehicle_Obj Vehicle) throws SQLException {
        int Affected_Rows;

        String qry = "Insert Into Vehicle (License_Plate, Brand, Model, Year, Color, Type, Seat_Count, Load_Capacity, Status) "
                + "Values ('" + Vehicle.getLicensePlate() + "', '"
                + Vehicle.getBrand() + "', '"
                + Vehicle.getModel() + "', "
                + Vehicle.getYear() + ", '"
                + Vehicle.getColor() + "', '"
                + Vehicle.getType() + "', "
                + Vehicle.getSeatCount() + ", "
                + Vehicle.getLoad_Capacity() + ", "
                + Vehicle.getStatus() + ")";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return Affected_Rows;

    }

    // Metodo para actualizar vehiculos
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
                + " WHERE License_Plate = '" + Vehicle.getLicensePlate() + "'";

        Statement sql = (Statement) Connection_SQL.getConnection().createStatement();

        Affected_Rows = sql.executeUpdate(qry);

        if (Affected_Rows > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar", "Aviso importante", JOptionPane.WARNING_MESSAGE);
        }

        return Affected_Rows;
    }

    // Metodo para actualizar el estado de vehiculo
    public static int Update_Vehicle_Status(String Licensed_Plate, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;
        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el vehículo como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el vehículo como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Vehicle Set Status = " + Status + " Where License_Plate = '" + Licensed_Plate + "'";
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El vehículo ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }
        return Rows_Affected;
    }

    // Metodo para insertar la gasolina
    public static int Insert_Fuel(Fuel_Obj Fuel) throws SQLException {
        String qry = "INSERT INTO Fuel (Fuel_ID, Name, Type, Price_Per_Liter, Status) "
                + "VALUES (" + Fuel.getFuel_Id() + ", '"
                + Fuel.getName() + "', '"
                + Fuel.getType() + "', "
                + Fuel.getPrice_Per_Liter() + ", "
                + Fuel.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();

        int Affected_Rows = sql.executeUpdate(qry);
        JOptionPane.showMessageDialog(null, "Datos guardados satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return Affected_Rows;
    }

    // Metodo para actualizar gasolina
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

    // Metodo para actualizar el estado de la gasolina
    public static int Update_Fuel_Status(int Fuel_ID, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;
        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el combustible como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el combustible como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Fuel Set Status = " + Status + " Where Fuel_ID = " + Fuel_ID;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El combustible ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }
        return Rows_Affected;
    }

    // Metodo para insertar las partes de un vehiculo 
    public static int Insert_Part(Part_Obj part) throws SQLException {
        String qry = "Insert Into Equipment_Parts (Part_ID, Part_Name, Part_Category, Manu_Facturer, Compatibility, Warranty_Period, Unit_Cost, Status) "
                + "Values (" + part.getPart_Id() + ", '"
                + part.getPart_Name() + "', '"
                + part.getPart_Category() + "', '"
                + part.getManu_Facturer() + "', '"
                + part.getCompatibility() + "', "
                + part.getWarrantly_Period() + ", "
                + part.getUnit_Cost() + ", "
                + part.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Pieza guardada satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);

        return affectedRows;
    }

    // Metodo para actualizar las partes de un vehiculo
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

    // Metodo para actualizar el estado de las partes de un vehiculo
    public static int Update_Part_Status(int Part_ID, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;
        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar la parte de equipo como inactiva?";
        } else {
            Message = "¿Está seguro de que desea marcar la parte de equipo como activa?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Equipment_Parts Set Status = " + Status + " Where Part_ID = " + Part_ID;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactiva";
            } else {
                Status_Message = "activa";
            }

            JOptionPane.showMessageDialog(null, "La parte de equipo ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }
        return Rows_Affected;
    }

    // Metodo para insertar los tipos de mantenimiento de un vehiculo
    public static int Insert_Maintenance_Type(Maintenance_Type_Obj maintenance) throws SQLException {
        String qry = "Insert Into Maintenance_Types (Maintenance_Id, Type, Description, Frequency, Material_Cost_Estimate, Vehicle_Id, Status) "
                + "Values (" + maintenance.getMaintenance_Id() + ", '"
                + maintenance.getType() + "', '"
                + maintenance.getDescription() + "', '"
                + maintenance.getFrequency() + "', "
                + maintenance.getMaterial_Cost_Estimate() + ", "
                + maintenance.getVehicle_Id() + ", "
                + maintenance.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Mantenimiento guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    // Metodo para actualizar los tipos de mantenimiento de un vehiculo
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
    // Metodo para actualizar el estado de los tipos de mantenimiento de un vehiculo

    public static int Update_Maintenance_Type_Status(int Maintenance_Id, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;
        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el tipo de mantenimiento como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el tipo de mantenimiento como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Maintenance_Types Set Status = " + Status + " Where Maintenance_Id = " + Maintenance_Id;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El tipo de mantenimiento ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }
        return Rows_Affected;
    }

}
