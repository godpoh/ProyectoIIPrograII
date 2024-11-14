/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentation;

import Data.Connection_SQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class Status extends javax.swing.JPanel {

    public Status(String Role) {
        initComponents();
        Show_Admin_Tab(Role);
        Action_Listeners_Method();
    }

    private void Show_Admin_Tab(String Role) {
        if ("Admin".equalsIgnoreCase(Role)) {
            Pnl_Admin.setVisible(true);
        } else {
            int Admin_Tab_Index = jTabbedPane1.indexOfComponent(Pnl_Admin);
            if (Admin_Tab_Index != -1) {
                jTabbedPane1.removeTabAt(Admin_Tab_Index);
            }
        }
    }

    private void Action_Listeners_Method() {

        Jcb_Admin.addActionListener(evt -> Show_Admin_Tab_Information());
        Cb_Admin.addItemListener(evt -> Show_Admin_Tab_Information());

        Jcb_Dispensador.addActionListener(evt -> Show_Dispenser_Tab_Information());
        Cb_Dispensador.addItemListener(evt -> Show_Dispenser_Tab_Information());

        Jcb_Mecanica.addActionListener(evt -> Show_Mechanic_Tab_Information());
        Cb_Estado_Mecanica.addItemListener(evt -> Show_Mechanic_Tab_Information());

    }

    private void Show_Admin_Tab_Information() {

        String Selected_Item = (String) Jcb_Admin.getSelectedItem();
        if (Selected_Item.equals("Usuarios")) {
            try {
                if (Cb_Admin.isSelected()) {
                    ResultSet rs = Connection_SQL.get_User_Information(1);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = Connection_SQL.get_User_Information(0);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            try {
                if (Cb_Admin.isSelected()) {
                    ResultSet rs = Connection_SQL.get_Vehicle_Information(1);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = Connection_SQL.get_Vehicle_Information(0);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

    private void Show_Dispenser_Tab_Information() {
        String Selected_Item = (String) Jcb_Dispensador.getSelectedItem();
        if (Selected_Item.equals("Combustibles")) {
            try {
                if (Cb_Dispensador.isSelected()) {
                    ResultSet rs = Connection_SQL.get_Fuel_Information(1);
                    Tbl_Dispensador.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = Connection_SQL.get_Fuel_Information(0);
                    Tbl_Dispensador.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else if (Selected_Item.equals("Tanques de Combustibles")) {

        } else if (Selected_Item.equals("Ingreso de Combustibles")) {

        } else if (Selected_Item.equals("Dispensadores")) {

        } else if (Selected_Item.equals("Dispensado de Combustible")) {

        }

    }

    private void Show_Mechanic_Tab_Information() {
        String Selected_Item = (String) Jcb_Mecanica.getSelectedItem();
        if (Selected_Item.equals("Partes de Equipos")) {
            try {
                if (Cb_Estado_Mecanica.isSelected()) {
                    ResultSet rs = Connection_SQL.get_Equipment_Parts_Information(1);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = Connection_SQL.get_Equipment_Parts_Information(0);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tipos de Mantenimientos")) {
            try {
                if (Cb_Estado_Mecanica.isSelected()) {
                    ResultSet rs = Connection_SQL.get_Maintenance_Types_Information(1);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    ResultSet rs = Connection_SQL.get_Maintenance_Types_Information(0);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Asignacion de Mantenimientos")) {

        } else if (Selected_Item.equals("Boletas de Mantenimiento")) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Dispensador = new javax.swing.JTable();
        lblIniciarSesion1 = new javax.swing.JLabel();
        Jcb_Dispensador = new javax.swing.JComboBox<>();
        Cb_Dispensador = new javax.swing.JCheckBox();
        Btn_Registro_Combustible6 = new javax.swing.JButton();
        Btn_Registro_Combustible7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        Jcb_Mecanica = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Mecanica = new javax.swing.JTable();
        Cb_Estado_Mecanica = new javax.swing.JCheckBox();
        Btn_Registro_Combustible4 = new javax.swing.JButton();
        Btn_Registro_Combustible5 = new javax.swing.JButton();
        Pnl_Admin = new javax.swing.JPanel();
        Cb_Admin = new javax.swing.JCheckBox();
        Jcb_Admin = new javax.swing.JComboBox<>();
        lblIniciarSesion3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Admin = new javax.swing.JTable();
        Btn_Registro_Combustible8 = new javax.swing.JButton();
        Btn_Registro_Combustible9 = new javax.swing.JButton();

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(Tbl_Dispensador);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 800, -1));

        lblIniciarSesion1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion1.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion1.setText("Estado Sector Dispensador");
        jPanel6.add(lblIniciarSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 250, 40));

        Jcb_Dispensador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jcb_Dispensador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Combustibles", "Tanques de Combustibles", "Ingreso de Combustibles", "Dispensadores", "Dispensado de Combustible" }));
        jPanel6.add(Jcb_Dispensador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 220, -1));

        Cb_Dispensador.setText("Estado Activo");
        jPanel6.add(Cb_Dispensador, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        Btn_Registro_Combustible6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible6.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible6.setText("Desactivar Estado");
        Btn_Registro_Combustible6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible6ActionPerformed(evt);
            }
        });
        jPanel6.add(Btn_Registro_Combustible6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, -1, -1));

        Btn_Registro_Combustible7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible7.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible7.setText("Activar Estado");
        Btn_Registro_Combustible7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible7ActionPerformed(evt);
            }
        });
        jPanel6.add(Btn_Registro_Combustible7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 760));

        jTabbedPane1.addTab("Sector Dispensador", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion.setText("Estado Sector Mecanica");
        jPanel2.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 220, 40));

        Jcb_Mecanica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jcb_Mecanica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Partes de Equipos", "Tipos de Mantenimientos", "Asignacion de Mantenimientos", "Boletas de Mantenimiento" }));
        jPanel2.add(Jcb_Mecanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 220, -1));

        jScrollPane1.setViewportView(Tbl_Mecanica);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 800, -1));

        Cb_Estado_Mecanica.setText("Estado Activo");
        jPanel2.add(Cb_Estado_Mecanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        Btn_Registro_Combustible4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible4.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible4.setText("Activar Estado");
        Btn_Registro_Combustible4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible4ActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Registro_Combustible4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        Btn_Registro_Combustible5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible5.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible5.setText("Desactivar Estado");
        Btn_Registro_Combustible5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible5ActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Registro_Combustible5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, -1, -1));

        jTabbedPane1.addTab("Sector Mecanica", jPanel2);

        Pnl_Admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cb_Admin.setText("Estado Activo");
        Pnl_Admin.add(Cb_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        Jcb_Admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Jcb_Admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Usuarios", "Vehiculos" }));
        Pnl_Admin.add(Jcb_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 220, -1));

        lblIniciarSesion3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIniciarSesion3.setForeground(new java.awt.Color(0, 0, 0));
        lblIniciarSesion3.setText("Estado Sector Administrativo");
        Pnl_Admin.add(lblIniciarSesion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 270, 40));

        jScrollPane4.setViewportView(Tbl_Admin);

        Pnl_Admin.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 800, -1));

        Btn_Registro_Combustible8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible8.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible8.setText("Desactivar Estado");
        Btn_Registro_Combustible8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible8ActionPerformed(evt);
            }
        });
        Pnl_Admin.add(Btn_Registro_Combustible8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, -1, -1));

        Btn_Registro_Combustible9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Registro_Combustible9.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Registro_Combustible9.setText("Activar Estado");
        Btn_Registro_Combustible9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Registro_Combustible9ActionPerformed(evt);
            }
        });
        Pnl_Admin.add(Btn_Registro_Combustible9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        jTabbedPane1.addTab("Admin ", Pnl_Admin);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Registro_Combustible4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible4ActionPerformed

    private void Btn_Registro_Combustible5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible5ActionPerformed

    private void Btn_Registro_Combustible6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible6ActionPerformed

    private void Btn_Registro_Combustible7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible7ActionPerformed

    private void Btn_Registro_Combustible8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible8ActionPerformed

    private void Btn_Registro_Combustible9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Registro_Combustible9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Registro_Combustible9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Registro_Combustible4;
    private javax.swing.JButton Btn_Registro_Combustible5;
    private javax.swing.JButton Btn_Registro_Combustible6;
    private javax.swing.JButton Btn_Registro_Combustible7;
    private javax.swing.JButton Btn_Registro_Combustible8;
    private javax.swing.JButton Btn_Registro_Combustible9;
    private javax.swing.JCheckBox Cb_Admin;
    private javax.swing.JCheckBox Cb_Dispensador;
    private javax.swing.JCheckBox Cb_Estado_Mecanica;
    private javax.swing.JComboBox<String> Jcb_Admin;
    private javax.swing.JComboBox<String> Jcb_Dispensador;
    private javax.swing.JComboBox<String> Jcb_Mecanica;
    private javax.swing.JPanel Pnl_Admin;
    private javax.swing.JTable Tbl_Admin;
    private javax.swing.JTable Tbl_Dispensador;
    private javax.swing.JTable Tbl_Mecanica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblIniciarSesion1;
    private javax.swing.JLabel lblIniciarSesion3;
    // End of variables declaration//GEN-END:variables
}
