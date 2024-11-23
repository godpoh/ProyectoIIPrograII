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
import java.text.SimpleDateFormat;

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

    // Metodo para insertar un tanque de combustible
    public static int Insert_Fuel_Tank(Fuel_Tank_Obj Fuel_Tank) throws SQLException {
        String qry = "Insert Into Fuel_Tank (Id, Description, Capacity, Fuel_Id, Status) "
                + "Values (" + Fuel_Tank.getId() + ", '"
                + Fuel_Tank.getDescription() + "', "
                + Fuel_Tank.getCapacity() + ", "
                + Fuel_Tank.getFuel_Id() + ", "
                + Fuel_Tank.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Tanque de combustible guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Metodo para actualizar un tanque de combustible
    public static int Update_Fuel_Tank(Fuel_Tank_Obj Fuel_Tank) throws SQLException {
        int Affected_Rows = 0;

        int confirm = JOptionPane.showConfirmDialog(null, "Desea actualizar los datos actuales?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Fuel_Tank Set "
                    + "Description = '" + Fuel_Tank.getDescription() + "', "
                    + "Capacity = " + Fuel_Tank.getCapacity() + ", "
                    + "Fuel_Id = " + Fuel_Tank.getFuel_Id() + ", "
                    + "Status = " + Fuel_Tank.getStatus() + " "
                    + "Where Id = " + Fuel_Tank.getId();
            Statement sql = Connection_SQL.getConnection().createStatement();
            Affected_Rows = sql.executeUpdate(qry);

            JOptionPane.showMessageDialog(null, "Tanque de combustible actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        }

        return Affected_Rows;
    }

// Metodo para actualizar el estado de un tanque de combustible
    public static int Update_Fuel_Tank_Status(int Id, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;

        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el tanque como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el tanque como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Fuel_Tank Set Status = " + Status + " Where Id = " + Id;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El tanque de combustible ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }

        return Rows_Affected;
    }

    // Metodo para insertar un dispensador
    public static int Insert_Dispenser(Dispenser_Obj Dispenser) throws SQLException {
        String qry = "Insert Into Dispenser (Id, Description, Fuel_Tank_Id, Status) "
                + "Values (" + Dispenser.getId() + ", '"
                + Dispenser.getDescription() + "', "
                + Dispenser.getFuel_Tank_Id() + ", "
                + Dispenser.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Dispensador guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Metodo para actualizar un dispensador
    public static int Update_Dispenser(Dispenser_Obj Dispenser) throws SQLException {
        int Affected_Rows = 0;

        int confirm = JOptionPane.showConfirmDialog(null, "Desea actualizar los datos actuales?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Dispenser Set "
                    + "Description = '" + Dispenser.getDescription() + "', "
                    + "Fuel_Tank_Id = " + Dispenser.getFuel_Tank_Id() + ", "
                    + "Status = " + Dispenser.getStatus() + " "
                    + "Where Id = " + Dispenser.getId();
            Statement sql = Connection_SQL.getConnection().createStatement();
            Affected_Rows = sql.executeUpdate(qry);

            JOptionPane.showMessageDialog(null, "Dispensador actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        }

        return Affected_Rows;
    }

// Metodo para actualizar el estado de un dispensador
    public static int Update_Dispenser_Status(int Id, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;

        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el dispensador como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el dispensador como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Dispenser Set Status = " + Status + " Where Id = " + Id;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El dispensador ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }

        return Rows_Affected;
    }

    // Método para insertar un registro en la tabla Fuel_Entry_Exit
    public static int Insert_Fuel_Entry_Exit(Fuel_Entry_Exit_Obj Fuel_Entry_Exit) throws SQLException {

        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        String Formatted_Date = SDF.format(Fuel_Entry_Exit.getDate());

        String qry = "Insert Into Fuel_Entry_Exit (Id, Vehicle_License_Plate, Dispenser_Id, Fuel_Amount, Mileage, Date, Transaction_Type, Status) "
                + "Values (" + Fuel_Entry_Exit.getId() + ", '"
                + Fuel_Entry_Exit.getVehicle_License_Plate() + "', "
                + Fuel_Entry_Exit.getDispenser_Id() + ", "
                + Fuel_Entry_Exit.getFuel_Amount() + ", "
                + Fuel_Entry_Exit.getMileage() + ", '"
                + Formatted_Date + "', '"
                + Fuel_Entry_Exit.getTransaction_Type() + "', "
                + Fuel_Entry_Exit.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de entrada/salida de combustible guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Método para actualizar un registro en la tabla Fuel_Entry_Exit
    public static int Update_Fuel_Entry_Exit(Fuel_Entry_Exit_Obj Fuel_Entry_Exit) throws SQLException {
        int Affected_Rows = 0;

        int confirm = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos actuales?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Fuel_Entry_Exit Set "
                    + "Vehicle_License_Plate = '" + Fuel_Entry_Exit.getVehicle_License_Plate() + "', "
                    + "Dispenser_Id = " + Fuel_Entry_Exit.getDispenser_Id() + ", "
                    + "Fuel_Amount = " + Fuel_Entry_Exit.getFuel_Amount() + ", "
                    + "Mileage = " + Fuel_Entry_Exit.getMileage() + ", "
                    + "Date = '" + Fuel_Entry_Exit.getDate() + "', "
                    + "Transaction_Type = '" + Fuel_Entry_Exit.getTransaction_Type() + "', "
                    + "Status = " + Fuel_Entry_Exit.getStatus() + " "
                    + "Where Id = " + Fuel_Entry_Exit.getId();

            Statement sql = Connection_SQL.getConnection().createStatement();
            Affected_Rows = sql.executeUpdate(qry);

            JOptionPane.showMessageDialog(null, "Registro de entrada/salida de combustible actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        }

        return Affected_Rows;
    }

// Método para actualizar el estado de un registro en la tabla Fuel_Entry_Exit
    public static int Update_Fuel_Entry_Exit_Status(int Id, int Status) throws SQLException {
        int Rows_Affected = 0;
        String Message;

        if (Status == 0) {
            Message = "¿Está seguro de que desea marcar el registro como inactivo?";
        } else {
            Message = "¿Está seguro de que desea marcar el registro como activo?";
        }

        int confirm = JOptionPane.showConfirmDialog(null, Message, "Confirmar actualización", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String qry = "Update Fuel_Entry_Exit Set Status = " + Status + " Where Id = " + Id;
            Statement sql = Connection_SQL.getConnection().createStatement();
            Rows_Affected = sql.executeUpdate(qry);

            String Status_Message;
            if (Status == 0) {
                Status_Message = "inactivo";
            } else {
                Status_Message = "activo";
            }

            JOptionPane.showMessageDialog(null, "El registro de entrada/salida de combustible ahora está " + Status_Message + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Actualización cancelada.");
        }

        return Rows_Affected;
    }

    public static boolean Update_Fuel_Amount_On_Tank(int Dispenser_Id, double Liters_Dispensed) throws SQLException {

        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = " Update Dispenser Set Current_Fuel_Amount = Current_Fuel_Amount - " + Liters_Dispensed + "Where Id = " + Dispenser_Id + " And Current_Fuel_Amount >=  0";

        int Rows_Affected = sql.executeUpdate(qry);

        return Rows_Affected > 0;

    }

    public static boolean Add_Fuel_Amount_On_Tank(int Dispenser_Id, double Liters_Dispensed) throws SQLException {

        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Update D "
                + "Set Current_Fuel_Amount = D.Current_Fuel_Amount + " + Liters_Dispensed + " "
                + "From Dispenser D "
                + "Inner Join Fuel_Tank FT On D.Fuel_Tank_Id = FT.Id "
                + "Where D.Id = " + Dispenser_Id + " "
                + "And D.Current_Fuel_Amount + " + Liters_Dispensed + " <= FT.Capacity";

        int Rows_Affected = sql.executeUpdate(qry);

        return Rows_Affected > 0;

    }

    public static int Insert_Employee(Employee_Obj Employee) throws SQLException {

        String qry = "Insert Into Employees (Id, Name, Type, Status) "
                + "Values (" + Employee.getId() + ", '"
                + Employee.getName() + "', '"
                + Employee.getRole() + "', "
                + Employee.getStatus() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Empleado registrado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    public static int Update_Employee(Employee_Obj employee) throws SQLException {

        String qry = "Update Employees "
                + "Set Name = '" + employee.getName() + "', "
                + "Type = '" + employee.getRole() + "', "
                + "Status = " + employee.getStatus() + " "
                + "Where Id = " + employee.getId();

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Empleado actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un empleado con el ID especificado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return affectedRows;
    }

    // Insertar un registro en la tabla Header
    public static int Insert_Header(Header_Obj Header) throws SQLException {
        String qry = "Insert Into Header (Id, Vehicle_License_Plate, Date, Mechanic_Name, Driver, Mileage) "
                + "Values (" + Header.getId() + ", '"
                + Header.getLicense_Plate() + "', '"
                + Header.getDate() + "', '"
                + Header.getMechanic_Name() + "', '"
                + Header.getDriver_Name() + "', "
                + Header.getMileage() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de encabezado guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Actualizar un registro en la tabla Header
    public static int Update_Header(Header_Obj Header) throws SQLException {
        String qry = "Update Header Set "
                + "Vehicle_License_Plate = '" + Header.getLicense_Plate() + "', "
                + "Date = '" + Header.getDate() + "', "
                + "Mechanic_Name = '" + Header.getMechanic_Name() + "', "
                + "Driver = '" + Header.getDriver_Name() + "', "
                + "Mileage = " + Header.getMileage() + " "
                + "Where Id = " + Header.getId();

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de encabezado actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    // Actualizar el estado en la tabla Header
    public static int Update_Header_Status(int id, int status) throws SQLException {
        String qry = "Update Header Set Status = " + status + " Where Id = " + id;

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Estado del encabezado actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    // Insertar un registro en la tabla Details
    public static int Insert_Details(Details_Obj Details) throws SQLException {
        String qry = "Insert Into Details (Detail_Id, Header_Id, Part_Id, Maintenance_Id) "
                + "Values (" + Details.getDetail_Id() + ", "
                + Details.getHeader_Id() + ", "
                + Details.getPart_Id() + ", "
                + Details.getMaintenance_Id() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de detalle guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Actualizar un registro en la tabla Details
    public static int Update_Details(Details_Obj Details) throws SQLException {
        String qry = "Update Details Set "
                + "Header_Id = " + Details.getHeader_Id() + ", "
                + "Part_Id = " + Details.getPart_Id() + ", "
                + "Maintenance_Id = " + Details.getMaintenance_Id() + " "
                + "Where Detail_Id = " + Details.getDetail_Id();

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de detalle actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }
// Actualizar el estado en la tabla Details

    public static int Update_Details_Status(int detailId, int status) throws SQLException {
        String qry = "Update Details Set Status = " + status + " Where Detail_Id = " + detailId;

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Estado del detalle actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

    // Insertar un registro en la tabla Maintenance_Assigments
    public static int Insert_Maintenance_Assigments(Maintenance_Assigments_Obj Assignment) throws SQLException {
        String qry = "Insert Into Maintenance_Assigments (License_Plate, Maintenance_Type_Id, Part_Id, Date_Days, Mileage) "
                + "Values ('" + Assignment.getLicense_Plate() + "', "
                + Assignment.getMaintenance_Type_Id() + ", "
                + Assignment.getPart_Id() + ", '"
                + Assignment.getDate_Days() + "', "
                + Assignment.getMileage() + ")";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de asignación de mantenimiento guardado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

// Actualizar un registro en la tabla Maintenance_Assigments
    public static int Update_Maintenance_Assigments(Maintenance_Assigments_Obj Assignment) throws SQLException {
        String qry = "Update Maintenance_Assigments Set "
                + "Maintenance_Type_Id = " + Assignment.getMaintenance_Type_Id() + ", "
                + "Part_Id = " + Assignment.getPart_Id() + ", "
                + "Date_Days = '" + Assignment.getDate_Days() + "', "
                + "Mileage = " + Assignment.getMileage() + " "
                + "Where License_Plate = '" + Assignment.getLicense_Plate() + "'";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Registro de asignación de mantenimiento actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }
// Actualizar el estado en la tabla Maintenance_Assigments

    public static int Update_Maintenance_Assigments_Status(String licensePlate, int status) throws SQLException {
        String qry = "Update Maintenance_Assigments Set Status = " + status + " Where License_Plate = '" + licensePlate + "'";

        Statement sql = Connection_SQL.getConnection().createStatement();
        int affectedRows = sql.executeUpdate(qry);

        JOptionPane.showMessageDialog(null, "Estado de la asignación de mantenimiento actualizado satisfactoriamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
        return affectedRows;
    }

}
