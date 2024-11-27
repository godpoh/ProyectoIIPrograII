/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentation;

import Data.Binnacle_Obj;
import Data.CUD_SQL;
import static Data.CUD_SQL.Insert_Binnacle_Record;
import static Data.CUD_SQL.Insert_User;
import static Data.CUD_SQL.Insert_Vehicle;
import static Data.CUD_SQL.Update_User;
import static Data.CUD_SQL.Update_Vehicle;
import Data.Connection_SQL;
import Data.User_Creator;
import Data.Vehicle_Obj;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Admin_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Admin_Panel
     */
    int Actual_User = Log_In.User_Id;

    public Admin_Panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Pnl_Principal = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        Txt_Usuario = new javax.swing.JTextField();
        Btn_Registrar = new javax.swing.JButton();
        Txt_Contrasena = new javax.swing.JPasswordField();
        lblContrasena2 = new javax.swing.JLabel();
        lblContrasena1 = new javax.swing.JLabel();
        Jcb_Rol = new javax.swing.JComboBox<>();
        lblUsuario2 = new javax.swing.JLabel();
        Txt_Nombre = new javax.swing.JTextField();
        Btn_Actualizar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Pnl_Principal1 = new javax.swing.JPanel();
        lblIniciarSesion1 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        Txt_Placa = new javax.swing.JTextField();
        Btn_Registrar_Vehiculo = new javax.swing.JButton();
        lblUsuario3 = new javax.swing.JLabel();
        Txt_Marca = new javax.swing.JTextField();
        Btn_Actualizar_Vehiculo = new javax.swing.JButton();
        Txt_Ano = new javax.swing.JTextField();
        Txt_Modelo = new javax.swing.JTextField();
        lblUsuario4 = new javax.swing.JLabel();
        lblUsuario5 = new javax.swing.JLabel();
        lblUsuario6 = new javax.swing.JLabel();
        Txt_Color = new javax.swing.JTextField();
        lblUsuario7 = new javax.swing.JLabel();
        lblUsuario8 = new javax.swing.JLabel();
        Txt_Asientos = new javax.swing.JTextField();
        Txt_Capacidad = new javax.swing.JTextField();
        lblUsuario9 = new javax.swing.JLabel();
        Jcb_Tipo = new javax.swing.JComboBox<>();
        lblImagen1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion.setText("Registro de Usuario");
        Pnl_Principal.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 180, 40));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario.setText("USUARIO(Cédula)");
        Pnl_Principal.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        Txt_Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Usuario.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal.add(Txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        Btn_Registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registrar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registrar.setText("Registrar");
        Btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegistrarActionPerformed(evt);
            }
        });
        Pnl_Principal.add(Btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, -1, -1));

        Txt_Contrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Contrasena.setForeground(new java.awt.Color(153, 153, 153));
        Txt_Contrasena.setText("********");
        Pnl_Principal.add(Txt_Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 350, 40));

        lblContrasena2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContrasena2.setForeground(new java.awt.Color(0, 0, 0));
        lblContrasena2.setText("Rol");
        Pnl_Principal.add(lblContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 40, -1));

        lblContrasena1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContrasena1.setForeground(new java.awt.Color(0, 0, 0));
        lblContrasena1.setText("CONTRASEÑA");
        Pnl_Principal.add(lblContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        Jcb_Rol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Jcb_Rol.setForeground(new java.awt.Color(153, 153, 153));
        Jcb_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un rol", "Admin", "Chofer", "Mecanico" }));
        Pnl_Principal.add(Jcb_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 350, 40));

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario2.setText("Nombre");
        Pnl_Principal.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        Txt_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Nombre.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal.add(Txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 350, 40));

        Btn_Actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });
        Pnl_Principal.add(Btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 120, -1));

        lblImagen.setBackground(new java.awt.Color(242, 242, 242));
        lblImagen.setForeground(new java.awt.Color(204, 204, 204));
        Pnl_Principal.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 820, 760));

        jPanel3.add(Pnl_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 760));

        jTabbedPane1.addTab("Creación de Usuario", jPanel1);

        Pnl_Principal1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion1.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion1.setText("Registro de Vehiculo");
        Pnl_Principal1.add(lblIniciarSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 190, 30));

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario1.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario1.setText("Número de placa");
        Pnl_Principal1.add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Txt_Placa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Placa.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 350, 40));

        Btn_Registrar_Vehiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registrar_Vehiculo.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registrar_Vehiculo.setText("Registrar");
        Btn_Registrar_Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registrar_VehiculoActionPerformed(evt);
            }
        });
        Pnl_Principal1.add(Btn_Registrar_Vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 100, -1));

        lblUsuario3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario3.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario3.setText("Marca");
        Pnl_Principal1.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        Txt_Marca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Marca.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 350, 40));

        Btn_Actualizar_Vehiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Actualizar_Vehiculo.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Actualizar_Vehiculo.setText("Actualizar");
        Btn_Actualizar_Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Actualizar_VehiculoActionPerformed(evt);
            }
        });
        Pnl_Principal1.add(Btn_Actualizar_Vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 120, -1));

        Txt_Ano.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Ano.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Ano, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 350, 40));

        Txt_Modelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Modelo.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 350, 40));

        lblUsuario4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario4.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario4.setText("Año");
        Pnl_Principal1.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        lblUsuario5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario5.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario5.setText("Modelo");
        Pnl_Principal1.add(lblUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        lblUsuario6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario6.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario6.setText("Color");
        Pnl_Principal1.add(lblUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        Txt_Color.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Color.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 350, 40));

        lblUsuario7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario7.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario7.setText("Tipo");
        Pnl_Principal1.add(lblUsuario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        lblUsuario8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario8.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario8.setText("Cantidad de Asientos");
        Pnl_Principal1.add(lblUsuario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        Txt_Asientos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Asientos.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Asientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 350, 40));

        Txt_Capacidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Capacidad.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal1.add(Txt_Capacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 350, 40));

        lblUsuario9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario9.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario9.setText("Capacidad de carga");
        Pnl_Principal1.add(lblUsuario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, -1));

        Jcb_Tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Jcb_Tipo.setForeground(new java.awt.Color(153, 153, 153));
        Jcb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo:", "Automóvil", "Camión", "Furgoneta", "Autobús", "Motocicleta", "Bicicleta", "Camioneta", "SUV", "Deportivo", "Minivan", "Tractor", "Coche eléctrico", "Vehículo de carga", "Vehículo todoterreno", "Vehículo de lujo", "Vehículo de trabajo", "Vehículo de emergencias", "Vehículo público", "Vehículo híbrido", "Vehículo comercial" }));
        Pnl_Principal1.add(Jcb_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 350, 40));

        lblImagen1.setBackground(new java.awt.Color(242, 242, 242));
        lblImagen1.setForeground(new java.awt.Color(204, 204, 204));
        Pnl_Principal1.add(lblImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 820, 760));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Pnl_Principal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Pnl_Principal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Creación de Vehículo", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Boton que ingresa los datos del usuario 
    private void Btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RegistrarActionPerformed
        int User_Id = Integer.parseInt(Txt_Usuario.getText());
        String Name = Txt_Nombre.getText();
        String Role = (String) Jcb_Rol.getSelectedItem();
        String Password = String.valueOf(Txt_Contrasena.getText());
        String Encrypted_Password = CUD_SQL.EncryptMD5(Password);

        User_Creator User = new User_Creator(User_Id, Name, Encrypted_Password, Role, 1);
        int Rows_Affected;
        try {
            Rows_Affected = Insert_User(User);
            if (Rows_Affected != 0) {

                Date Current_Date = new Date();
                Binnacle_Obj Binnacle = new Binnacle_Obj("Registro de Usuario", Actual_User, "Seccion de Administracion", Current_Date);
                Insert_Binnacle_Record(Binnacle);

                Txt_Usuario.setText("");
                Txt_Nombre.setText("");
                Jcb_Rol.setSelectedItem("Seleccione un rol");
                Txt_Contrasena.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_RegistrarActionPerformed

    // Boton que actualiza los datos del usuario mediante la cedula o id
    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed
        int User_Id = Integer.parseInt(Txt_Usuario.getText());
        String Name = Txt_Nombre.getText();
        String Role = (String) Jcb_Rol.getSelectedItem();
        String Password = String.valueOf(Txt_Contrasena.getText());
        String Encrypted_Password = CUD_SQL.EncryptMD5(Password);

        User_Creator User = new User_Creator(User_Id, Name, Encrypted_Password, Role, 1);
        int Rows_Affected;
        try {
            Rows_Affected = Update_User(User);
            if (Rows_Affected != 0) {
                Date Current_Date = new Date();
                Binnacle_Obj Binnacle = new Binnacle_Obj("Actualizacion de Usuario", Actual_User, "Seccion de Administracion", Current_Date);
                Insert_Binnacle_Record(Binnacle);

                Txt_Usuario.setText("");
                Txt_Nombre.setText("");
                Jcb_Rol.setSelectedItem("Seleccione un rol");
                Txt_Contrasena.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Btn_ActualizarActionPerformed
    // Boton que ingresa los datos de un nuevo vehiculo
    private void Btn_Registrar_VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registrar_VehiculoActionPerformed
        String License_Plate = Txt_Placa.getText();
        String Brand = Txt_Marca.getText();
        String Model = Txt_Modelo.getText();
        int Year = Integer.valueOf(Txt_Ano.getText());
        String Color = Txt_Color.getText();
        String Type = (String) Jcb_Tipo.getSelectedItem();
        int Seating = Integer.valueOf(Txt_Asientos.getText());
        float Capacity = Float.parseFloat(Txt_Capacidad.getText());

        Vehicle_Obj Vehicle = new Vehicle_Obj(License_Plate, Brand, Model, Year, Color, Type, Seating, Capacity, 1);

        try {
            Insert_Vehicle(Vehicle);
            Date Current_Date = new Date();
            Binnacle_Obj Binnacle = new Binnacle_Obj("Registro de Vehiculo", Actual_User, "Seccion de Administracion", Current_Date);
            Insert_Binnacle_Record(Binnacle);

            Txt_Placa.setText("");
            Txt_Marca.setText("");
            Txt_Modelo.setText("");
            Txt_Ano.setText("");
            Txt_Color.setText("");
            Jcb_Tipo.setSelectedItem("Seleccione un tipo:");
            Txt_Asientos.setText("");
            Txt_Capacidad.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Btn_Registrar_VehiculoActionPerformed

    // Boton que actualiza los datos del vehiculo mediante la Placa
    private void Btn_Actualizar_VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Actualizar_VehiculoActionPerformed
        String License_Plate = Txt_Placa.getText();
        String Brand = Txt_Marca.getText();
        String Model = Txt_Modelo.getText();
        int Year = Integer.valueOf(Txt_Ano.getText());
        String Color = Txt_Color.getText();
        String Type = (String) Jcb_Tipo.getSelectedItem();
        int Seating = Integer.valueOf(Txt_Asientos.getText());
        float Capacity = Float.parseFloat(Txt_Capacidad.getText());

        Vehicle_Obj Vehicle = new Vehicle_Obj(License_Plate, Brand, Model, Year, Color, Type, Seating, Capacity, 1);

        try {
            Update_Vehicle(Vehicle);
                            Date Current_Date = new Date();
                Binnacle_Obj Binnacle = new Binnacle_Obj("Actualizacion de Vehiculo", Actual_User, "Seccion de Administracion", Current_Date);
                Insert_Binnacle_Record(Binnacle);
                
            Txt_Placa.setText("");
            Txt_Marca.setText("");
            Txt_Modelo.setText("");
            Txt_Ano.setText("");
            Txt_Color.setText("");
            Jcb_Tipo.setSelectedItem("Seleccione un tipo:");
            Txt_Asientos.setText("");
            Txt_Capacidad.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_Actualizar_VehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Actualizar_Vehiculo;
    private javax.swing.JButton Btn_Registrar;
    private javax.swing.JButton Btn_Registrar_Vehiculo;
    private javax.swing.JComboBox<String> Jcb_Rol;
    private javax.swing.JComboBox<String> Jcb_Tipo;
    private javax.swing.JPanel Pnl_Principal;
    private javax.swing.JPanel Pnl_Principal1;
    private javax.swing.JTextField Txt_Ano;
    private javax.swing.JTextField Txt_Asientos;
    private javax.swing.JTextField Txt_Capacidad;
    private javax.swing.JTextField Txt_Color;
    private javax.swing.JPasswordField Txt_Contrasena;
    private javax.swing.JTextField Txt_Marca;
    private javax.swing.JTextField Txt_Modelo;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JTextField Txt_Placa;
    private javax.swing.JTextField Txt_Usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblContrasena1;
    private javax.swing.JLabel lblContrasena2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblIniciarSesion1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblUsuario3;
    private javax.swing.JLabel lblUsuario4;
    private javax.swing.JLabel lblUsuario5;
    private javax.swing.JLabel lblUsuario6;
    private javax.swing.JLabel lblUsuario7;
    private javax.swing.JLabel lblUsuario8;
    private javax.swing.JLabel lblUsuario9;
    // End of variables declaration//GEN-END:variables
}
