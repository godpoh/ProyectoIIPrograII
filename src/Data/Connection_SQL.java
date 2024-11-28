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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
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

    // Metodo para verificar que las credenciales que ingresa el usuario son correctas
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

    // Verificar que al ingresar las credenciales, el usuario se encuentre activo
    public static int Verify_User_Status(int Id) throws SQLException {
        int Obtained_Status = 0;
        String qry = "Select Status from Users Where Id = " + Id;

        Statement sql = Connection_SQL.getConnection().createStatement();

        ResultSet rs = sql.executeQuery(qry);

        if (rs.next()) {
            Obtained_Status = rs.getInt("Status");
        }
        return Obtained_Status;
    }

    // Obtiene el rol del usuario, para los diferentes permiso del programa
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

    // Obtiene la placa del vehiculo
    public static void get_Vehicle_Name(JComboBox JCB) throws SQLException {
        String License_Plate = "";
        String qry = "Select License_Plate From Vehicle";

        Statement sql = Connection_SQL.getConnection().createStatement();

        ResultSet rs = sql.executeQuery(qry);
        JCB.removeAllItems();
        JCB.addItem("Seleccione una matricula:");
        while (rs.next()) {
            License_Plate = rs.getString("License_Plate");
            JCB.addItem(License_Plate);
        };

    }

    // Obtiene el id del vehiculo por la placa
    public static int get_Vehicle_Id_By_Name(String License_Plate) throws SQLException {
        int Id = 0;
        String qry = "Select Id From Vehicle Where License_Plate = '" + License_Plate + "'";

        Statement sql = Connection_SQL.getConnection().createStatement();

        ResultSet rs = sql.executeQuery(qry);

        if (rs.next()) {
            Id = rs.getInt("Id");
        }
        return Id;
    }

    // Consultas TABLA DE ESTADO
    // Devuelve en una tabla el estado e informacion del usuario
    public static ResultSet get_User_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Cedula, Name as Nombre,\n"
                + "Role as Rol, Status as Estado from Users where Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Devuelve en una tabla el estado del vehiculo y su informacion
    public static ResultSet get_Vehicle_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Vehiculo, License_Plate as Placa, "
                + "Brand as Marca, Model as Modelo, Year as Año, "
                + "Color as Color, Type as Tipo, Seat_Count as Asientos, "
                + "Load_Capacity as Capacidad_Carga, Status as Estado "
                + "From Vehicle Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Devuelve en una tabla el estado de la gasolina y su informacion
    public static ResultSet get_Fuel_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Fuel_ID as Id_Combustible, Name as Nombre, "
                + "Type as Tipo, Price_Per_Liter as Precio_Por_Litro, "
                + "Status as Estado "
                + "From Fuel Where Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Devuelve en una tabla el estado de las piezas de vehiculos e informacion
    public static ResultSet get_Equipment_Parts_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Part_ID as Id_Parte, Part_Name as Nombre, "
                + "Part_Category as Categoria, Manu_Facturer as Fabricante, "
                + "Compatibility as Compatibilidad, Warranty_Period as Periodo_Garantia, "
                + "Unit_Cost as Costo_Unitario, Status as Estado "
                + "From Equipment_Parts Where Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Devuelve en una tabla el estado de los tipos de mantenimientos e informacion
    public static ResultSet get_Maintenance_Types_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Maintenance_Id as Id_Mantenimiento, "
                + "Type as Tipo_Mantenimiento, "
                + "Description as Descripcion, "
                + "Frequency as Frecuencia, "
                + "Material_Cost_Estimate as Costo_Estimado, "
                + "Status as Estado "
                + "From Maintenance_Types Where Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Employees
    public static ResultSet get_Employee_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Empleado, Name as Nombre, Type as Tipo, Status as Estado "
                + "From Employees Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Fuel_Tank
    public static ResultSet get_Fuel_Tank_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Tanque, Description as Descripcion, Capacity as Capacidad, "
                + "Status as Estado, Fuel_Id as Id_Combustible "
                + "From Fuel_Tank Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Dispenser
    public static ResultSet get_Dispenser_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Dispenser, Description as Descripcion, Status as Estado, "
                + "Fuel_Tank_Id as Id_Tanque, Current_Fuel_Amount as Cantidad_Combustible_Actual "
                + "From Dispenser Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Header
    public static ResultSet get_Header_and_Details_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select H.Id as Id_Boleta, H.Vehicle_License_Plate as Placa_Vehiculo, "
                + "H.Date as Fecha, H.Mechanic_Name as Nombre_Mecanico, H.Driver_Name as Nombre_Conductor, "
                + "H.Mileage as Kilometraje, D.Detail_Id as Id_Detalle, D.Part_Id as Id_Parte, "
                + "D.Maintenance_Id as Id_Mantenimiento, H.Status as Estado_Header, D.Status as Estado_Detail "
                + "From Header H "
                + "Join Details D ON H.Id = D.Header_Id "
                + "Where H.Status = " + Status + " AND D.Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Maintenance_Assigments
    public static ResultSet get_Maintenance_Assigments_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Asignacion, License_Plate as Placa_Vehiculo, "
                + "Maintenance_Type_Id as Id_Tipo_Mantenimiento, Part_Id as Id_Parte, "
                + "Frecuency_Days as Dias_Frecuencia, Mileage as Kilometraje, "
                + "Status as Estado "
                + "From Maintenance_Assigments "
                + "Where Status = " + Status;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Fuel_Entry_Exit
    public static ResultSet get_Fuel_Entry_Exit_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Entrada_Salida, Vehicle_License_Plate as Placa_Vehiculo, "
                + "Dispenser_Id as Id_Dispenser, Fuel_Amount as Cantidad_Combustible, "
                + "Buy_Id as Id_Compra, Mileage as Kilometraje, Date as Fecha, "
                + "Transaction_Type as Tipo_Transaccion, Status as Estado "
                + "From Fuel_Entry_Exit Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

// Para la tabla Binnacle
    public static ResultSet get_Binnacle_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id_Binnacle as Id_Binnacle, Operation as Operacion, "
                + "User_Binnacle as Usuario_Binnacle, Place as Lugar, "
                + "Date_Binnacle as Fecha_Binnacle "
                + "From Binnacle";
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

    public static ResultSet get_Employees_Information(int Status) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id as Id_Empleado, Name as Nombre, "
                + "Type as Tipo, Status as Estado "
                + "From Employees "
                + "Where Status = " + Status;
        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

    public static int get_Fuel_Id_By_Name(String Fuel_Name) throws SQLException {

        int Id = 0;
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Fuel_Id from Fuel Where Name = '" + Fuel_Name + "'";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            Id = rs.getInt("Fuel_Id");
        }
        return Id;
    }

    public static void get_Fuel_Name_In_JCB(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Name From Fuel";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Name");
            Jcb.addItem(Name);
        }
    }

    public static void get_Tank_Id_In_JCB(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id From Fuel_Tank";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Id");
            Jcb.addItem(Name);
        }
    }

    public static void get_Dispenser_Id(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id From Dispenser";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Id");
            Jcb.addItem(Name);
        }
    }

    public static double get_Fuel_Amount_On_Dispenser(int Dispenser_Id) throws SQLException {
        double Liters = 0;

        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Current_Fuel_Amount From Dispenser Where Id = " + Dispenser_Id;

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            Liters = rs.getFloat("Current_Fuel_Amount");
        }
        return Liters;
    }

    public static int get_Maintenance_Type_Id_By_Name(String Name) throws SQLException {
        int Id = 0;

        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Maintenance_Id From Maintenance_Types Where Type = '" + Name + "'";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            Id = rs.getInt("Maintenance_Id");
        }
        return Id;
    }

    public static int get_Part_Id_By_Name(String Name) throws SQLException {
        int Id = 0;

        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Part_Id From Equipment_Parts Where Part_Name = '" + Name + "'";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            Id = rs.getInt("Part_Id");
        }
        return Id;
    }

    public static void get_Drivers(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Name From Employees Where Type = '" + "Chofer" + "'";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Name");
            Jcb.addItem(Name);
        }
    }

    public static void get_Mechanics(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Name From Employees Where Type = '" + "Mecanico" + "'";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Name");
            Jcb.addItem(Name);
        }

    }

    public static void get_Parts_Name(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Part_Name From Equipment_Parts";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Part_Name");
            Jcb.addItem(Name);
        }

    }

    public static void get_Maintenance_Type(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Type From Maintenance_Types";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Type");
            Jcb.addItem(Name);
        }

    }

    public static void get_Ticket_Id(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id From Header";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Id");
            Jcb.addItem(Name);
        }

    }

    public static Date get_Header_Date() throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Date From Header";

        Date Obtained_Date = null;

        ResultSet rs = sql.executeQuery(qry);

        if (rs.next()) {
            Obtained_Date = rs.getDate("Date");
        }

        return Obtained_Date;
    }

    public static ResultSet get_Vehicle_Movements(Date Start_Date, Date End_Date, String License_Plate) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        // Convertir las fechas Java a String en formato SQL (yyyy-MM-dd)
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        String Start_Date_Str = SDF.format(Start_Date);
        String End_Date_Str = SDF.format(End_Date);

        // Consulta SQL con las fechas proporcionadas
        String qry = "SELECT H.Id, H.Vehicle_License_Plate as Placa_Vehicular, H.Date as Fecha_Mantenimiento, "
                + "H.Mechanic_Name as Mecanico_Cargo, H.Driver_Name as Chofer, H.Mileage as Kilometraje, "
                + "D.Detail_Id as Id_Detalle, EP.Part_Name as Nombre_Pieza, MT.Type as Tipo_Mantenimiento "
                + "FROM Header H "
                + "JOIN Details D ON D.Header_Id = H.Id "
                + "JOIN Equipment_Parts EP ON EP.Part_Id = D.Part_Id "
                + "JOIN Maintenance_Types MT ON MT.Maintenance_Id = D.Maintenance_Id "
                + "WHERE H.Vehicle_License_Plate = '" + License_Plate + "' "
                + "AND H.Date BETWEEN '" + Start_Date_Str + "' AND '" + End_Date_Str + "' "
                + "ORDER BY H.Date DESC";
        ResultSet rs = sql.executeQuery(qry);
        return rs;
    }

    public static ResultSet get_Fuel_Performance(Date Start_Date, Date End_Date, String License_Plate) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        // Convertir las fechas Java a String en formato SQL (yyyy-MM-dd)
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        String Start_Date_Str = SDF.format(Start_Date);
        String End_Date_Str = SDF.format(End_Date);

        // Consulta SQL con los filtros por vehículo y fechas
        String qry = "SELECT FEE.Vehicle_License_Plate AS Placa_Vehicular, "
                + "SUM(FEE.Fuel_Amount) AS Combustible_Consumido, "
                + "MAX(FEE.Mileage) - MIN(FEE.Mileage) AS Kilometraje_Recorrido, "
                + "CASE WHEN SUM(FEE.Fuel_Amount) > 0 THEN "
                + "(MAX(FEE.Mileage) - MIN(FEE.Mileage)) / SUM(FEE.Fuel_Amount) ELSE 0 END AS Rendimiento "
                + "FROM Fuel_Entry_Exit FEE "
                + "WHERE FEE.Vehicle_License_Plate = '" + License_Plate + "' "
                + "AND FEE.Date BETWEEN '" + Start_Date_Str + "' AND '" + End_Date_Str + "' "
                + "AND FEE.Status = 1 "
                + "GROUP BY FEE.Vehicle_License_Plate";

        // Ejecutar la consulta y devolver los resultados
        ResultSet rs = sql.executeQuery(qry);
        return rs;
    }

    public static ResultSet Load_Binnacle_Info(Date Start_Date, Date End_Date, int User_Id) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        String Start_Date_Str = SDF.format(Start_Date);
        String End_Date_Str = SDF.format(End_Date);

        String qry = "Select Id_Binnacle as Id_Bitacora, Operation as Proceso_Realizado, User_Binnacle as Usuario_Asignado,"
                + " Place as Seccion, Date_Binnacle as Fecha_Realizado From Binnacle Where Date Between"
                + " '" + Start_Date_Str + "' And '" + End_Date_Str + "' And User_Binnacle = " + User_Id;

        ResultSet rs = sql.executeQuery(qry);

        return rs;
    }

    public static void get_User_Id(JComboBox Jcb) throws SQLException {
        Statement sql = Connection_SQL.getConnection().createStatement();

        String qry = "Select Id From Users";

        ResultSet rs = sql.executeQuery(qry);

        while (rs.next()) {
            String Name = rs.getString("Id");
            Jcb.addItem(Name);
        }
    }

}
