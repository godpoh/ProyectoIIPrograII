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
                + "Vehicle_Id as Id_Vehiculo, "
                + "Status as Estado "
                + "From Maintenance_Types Where Status = " + Status;

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
    
//    public static double get_Tank_Capacity() {
//        
//    }

}
