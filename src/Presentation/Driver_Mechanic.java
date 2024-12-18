/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentation;

import Data.Binnacle_Obj;
import Data.CUD_SQL;
import static Data.CUD_SQL.Insert_Binnacle_Record;
import Data.Employee_Obj;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Driver_Mechanic extends javax.swing.JPanel {

    /**
     * Creates new form Driver_Mechanic
     */
    int Actual_User = Log_In.User_Id;

    public Driver_Mechanic() {
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
        Txt_Cedula = new javax.swing.JTextField();
        Btn_Registrar = new javax.swing.JButton();
        lblContrasena2 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        Btn_Actualizar = new javax.swing.JButton();
        Txt_Nombre = new javax.swing.JTextField();
        Jcb_Rol = new javax.swing.JComboBox<>();
        lblImagen = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion.setText("Registro de Empleados");
        Pnl_Principal.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 230, 40));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario.setText("Cedula");
        Pnl_Principal.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        Txt_Cedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Cedula.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal.add(Txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 350, 40));

        Btn_Registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registrar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registrar.setText("Registrar");
        Btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegistrarActionPerformed(evt);
            }
        });
        Pnl_Principal.add(Btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        lblContrasena2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContrasena2.setForeground(new java.awt.Color(0, 0, 0));
        lblContrasena2.setText("Rol (Chofer/Mecanico)");
        Pnl_Principal.add(lblContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 220, -1));

        lblUsuario2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario2.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario2.setText("Nombre");
        Pnl_Principal.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        Btn_Actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Actualizar.setText("Actualizar");
        Btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActualizarActionPerformed(evt);
            }
        });
        Pnl_Principal.add(Btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 120, -1));

        Txt_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Txt_Nombre.setForeground(new java.awt.Color(153, 153, 153));
        Pnl_Principal.add(Txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 350, 40));

        Jcb_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Chofer", "Mecanico" }));
        Pnl_Principal.add(Jcb_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 350, 40));

        jPanel3.add(Pnl_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 760));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 760));

        lblImagen.setBackground(new java.awt.Color(242, 242, 242));
        lblImagen.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 740));

        jTabbedPane1.addTab("Empleado", jPanel1);

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
// Boton que actualiza la informacion obtenida de los empleados
    private void Btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActualizarActionPerformed

        try {
            int Id = Integer.parseInt(Txt_Cedula.getText());
            String Name = Txt_Nombre.getText();
            String Role = (String) Jcb_Rol.getSelectedItem();

            Employee_Obj Obj = new Employee_Obj(Id, Name, Role, 1);

            int Rows_Affected = CUD_SQL.Update_Employee(Obj);

            if (Rows_Affected != 0) {
                Date Current_Date = new Date();
                Binnacle_Obj Binnacle = new Binnacle_Obj("Actualizacion de Empleado", Actual_User, "Seccion Empleado", Current_Date);
                Insert_Binnacle_Record(Binnacle);
                Txt_Cedula.setText("");
                Txt_Nombre.setText("");
                Jcb_Rol.setSelectedItem("Seleccione una opcion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Driver_Mechanic.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Btn_ActualizarActionPerformed
    // Boton que registra la informacion obtenida de los empleados
    private void Btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RegistrarActionPerformed

        try {
            int Id = Integer.parseInt(Txt_Cedula.getText());
            String Name = Txt_Nombre.getText();
            String Role = (String) Jcb_Rol.getSelectedItem();

            Employee_Obj Obj = new Employee_Obj(Id, Name, Role, 1);

            int Rows_Affected = CUD_SQL.Insert_Employee(Obj);

            if (Rows_Affected != 0) {
                Date Current_Date = new Date();
                Binnacle_Obj Binnacle = new Binnacle_Obj("Registro de Empleado", Actual_User, "Seccion Empleado", Current_Date);
                Insert_Binnacle_Record(Binnacle);
                Txt_Cedula.setText("");
                Txt_Nombre.setText("");
                Jcb_Rol.setSelectedItem("Seleccione una opcion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Driver_Mechanic.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Btn_RegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Registrar;
    private javax.swing.JComboBox<String> Jcb_Rol;
    private javax.swing.JPanel Pnl_Principal;
    private javax.swing.JTextField Txt_Cedula;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblContrasena2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario2;
    // End of variables declaration//GEN-END:variables
}
