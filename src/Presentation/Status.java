/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentation;

import Data.CUD_SQL;
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
        Hide_Buttons();
    }

    private void Hide_Buttons() {
        Btn_Activar_Estado_Admin.setVisible(false);
        Btn_Desactivar_Estado_Admin.setVisible(false);

        Btn_Activar_Estado_Dispensador.setVisible(false);
        Btn_Desactivar_Estado_Dispensador.setVisible(false);

        Btn_Desactivar_Estado_Mecanica.setVisible(false);
        Btn_Activar_Estado_Mecanica.setVisible(false);
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
                    Btn_Activar_Estado_Admin.setVisible(false);
                    Btn_Desactivar_Estado_Admin.setVisible(true);
                    ResultSet rs = Connection_SQL.get_User_Information(1);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    Btn_Activar_Estado_Admin.setVisible(true);
                    Btn_Desactivar_Estado_Admin.setVisible(false);
                    ResultSet rs = Connection_SQL.get_User_Information(0);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                }

            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            try {
                if (Cb_Admin.isSelected()) {
                    Btn_Activar_Estado_Admin.setVisible(false);
                    Btn_Desactivar_Estado_Admin.setVisible(true);
                    ResultSet rs = Connection_SQL.get_Vehicle_Information(1);
                    Tbl_Admin.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    Btn_Activar_Estado_Admin.setVisible(true);
                    Btn_Desactivar_Estado_Admin.setVisible(false);
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
                    Btn_Activar_Estado_Dispensador.setVisible(false);
                    Btn_Desactivar_Estado_Dispensador.setVisible(true);
                    ResultSet rs = Connection_SQL.get_Fuel_Information(1);
                    Tbl_Dispensador.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    Btn_Activar_Estado_Dispensador.setVisible(true);
                    Btn_Desactivar_Estado_Dispensador.setVisible(false);
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
                    Btn_Desactivar_Estado_Mecanica.setVisible(true);
                    Btn_Activar_Estado_Mecanica.setVisible(false);
                    ResultSet rs = Connection_SQL.get_Equipment_Parts_Information(1);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    Btn_Desactivar_Estado_Mecanica.setVisible(false);
                    Btn_Activar_Estado_Mecanica.setVisible(true);
                    ResultSet rs = Connection_SQL.get_Equipment_Parts_Information(0);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tipos de Mantenimientos")) {
            try {
                if (Cb_Estado_Mecanica.isSelected()) {
                    Btn_Desactivar_Estado_Mecanica.setVisible(true);
                    Btn_Activar_Estado_Mecanica.setVisible(false);
                    ResultSet rs = Connection_SQL.get_Maintenance_Types_Information(1);
                    Tbl_Mecanica.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    Btn_Desactivar_Estado_Mecanica.setVisible(false);
                    Btn_Activar_Estado_Mecanica.setVisible(true);
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
        Btn_Desactivar_Estado_Dispensador = new javax.swing.JButton();
        Btn_Activar_Estado_Dispensador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        Jcb_Mecanica = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Mecanica = new javax.swing.JTable();
        Cb_Estado_Mecanica = new javax.swing.JCheckBox();
        Btn_Activar_Estado_Mecanica = new javax.swing.JButton();
        Btn_Desactivar_Estado_Mecanica = new javax.swing.JButton();
        Pnl_Admin = new javax.swing.JPanel();
        Cb_Admin = new javax.swing.JCheckBox();
        Jcb_Admin = new javax.swing.JComboBox<>();
        lblIniciarSesion3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Admin = new javax.swing.JTable();
        Btn_Desactivar_Estado_Admin = new javax.swing.JButton();
        Btn_Activar_Estado_Admin = new javax.swing.JButton();

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

        Btn_Desactivar_Estado_Dispensador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Desactivar_Estado_Dispensador.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Desactivar_Estado_Dispensador.setText("Desactivar Estado");
        Btn_Desactivar_Estado_Dispensador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Desactivar_Estado_DispensadorActionPerformed(evt);
            }
        });
        jPanel6.add(Btn_Desactivar_Estado_Dispensador, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        Btn_Activar_Estado_Dispensador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Activar_Estado_Dispensador.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Activar_Estado_Dispensador.setText("Activar Estado");
        Btn_Activar_Estado_Dispensador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Activar_Estado_DispensadorActionPerformed(evt);
            }
        });
        jPanel6.add(Btn_Activar_Estado_Dispensador, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

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

        Btn_Activar_Estado_Mecanica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Activar_Estado_Mecanica.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Activar_Estado_Mecanica.setText("Activar Estado");
        Btn_Activar_Estado_Mecanica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Activar_Estado_MecanicaActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Activar_Estado_Mecanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        Btn_Desactivar_Estado_Mecanica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Desactivar_Estado_Mecanica.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Desactivar_Estado_Mecanica.setText("Desactivar Estado");
        Btn_Desactivar_Estado_Mecanica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Desactivar_Estado_MecanicaActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Desactivar_Estado_Mecanica, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

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

        Btn_Desactivar_Estado_Admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Desactivar_Estado_Admin.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Desactivar_Estado_Admin.setText("Desactivar Estado");
        Btn_Desactivar_Estado_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Desactivar_Estado_AdminActionPerformed(evt);
            }
        });
        Pnl_Admin.add(Btn_Desactivar_Estado_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        Btn_Activar_Estado_Admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_Activar_Estado_Admin.setForeground(new java.awt.Color(0, 0, 0));
        Btn_Activar_Estado_Admin.setText("Activar Estado");
        Btn_Activar_Estado_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Activar_Estado_AdminAdminActionPerformed(evt);
            }
        });
        Pnl_Admin.add(Btn_Activar_Estado_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

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

    private void Btn_Desactivar_Estado_MecanicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Desactivar_Estado_MecanicaActionPerformed
        int Selected_Row = Tbl_Mecanica.getSelectedRow();
        String Selected_Item = (String) Jcb_Mecanica.getSelectedItem();

        if (Selected_Item.equals("Partes de Equipos")) {
            try {
                int Part_Id = (int) Tbl_Mecanica.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Part_Status(Part_Id, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tipos de Mantenimientos")) {
            try {
                int Maintenance_Id = (int) Tbl_Mecanica.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Maintenance_Type_Status(Maintenance_Id, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Asignacion de Mantenimientos")) {

        } else if (Selected_Item.equals("Boletas de Mantenimiento")) {

        }
    }//GEN-LAST:event_Btn_Desactivar_Estado_MecanicaActionPerformed

    private void Btn_Desactivar_Estado_DispensadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Desactivar_Estado_DispensadorActionPerformed
        int Selected_Row = Tbl_Dispensador.getSelectedRow();
        String Selected_Item = (String) Jcb_Dispensador.getSelectedItem();

        if (Selected_Item.equals("Combustibles")) {
            try {
                int Fuel_Id = (int) Tbl_Dispensador.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Fuel_Status(Fuel_Id, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tanques de Combustibles")) {

        } else if (Selected_Item.equals("Ingreso de Combustibles")) {

        } else if (Selected_Item.equals("Dispensadores")) {

        } else if (Selected_Item.equals("Dispensado de Combustible")) {

        }
    }//GEN-LAST:event_Btn_Desactivar_Estado_DispensadorActionPerformed

    private void Btn_Activar_Estado_DispensadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Activar_Estado_DispensadorActionPerformed
        int Selected_Row = Tbl_Dispensador.getSelectedRow();
        String Selected_Item = (String) Jcb_Dispensador.getSelectedItem();

        if (Selected_Item.equals("Combustibles")) {
            try {
                int Fuel_Id = (int) Tbl_Dispensador.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Fuel_Status(Fuel_Id, 1);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tanques de Combustibles")) {

        } else if (Selected_Item.equals("Ingreso de Combustibles")) {

        } else if (Selected_Item.equals("Dispensadores")) {

        } else if (Selected_Item.equals("Dispensado de Combustible")) {

        }
    }//GEN-LAST:event_Btn_Activar_Estado_DispensadorActionPerformed

    private void Btn_Desactivar_Estado_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Desactivar_Estado_AdminActionPerformed
        int Selected_Row = Tbl_Admin.getSelectedRow();
        String Selected_Item = (String) Jcb_Admin.getSelectedItem();

        if (Selected_Item.equals("Usuarios")) {
            try {
                int User_Id = (int) Tbl_Admin.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_User_Status(User_Id, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String Licensed_Plate = (String) Tbl_Admin.getValueAt(Selected_Row, 1);
                CUD_SQL.Update_Vehicle_Status(Licensed_Plate, 0);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Btn_Desactivar_Estado_AdminActionPerformed

    private void Btn_Activar_Estado_AdminAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Activar_Estado_AdminAdminActionPerformed
        int Selected_Row = Tbl_Admin.getSelectedRow();
        String Selected_Item = (String) Jcb_Admin.getSelectedItem();

        if (Selected_Item.equals("Usuarios")) {
            try {
                int User_Id = (int) Tbl_Admin.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_User_Status(User_Id, 1);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String Licensed_Plate = (String) Tbl_Admin.getValueAt(Selected_Row, 1);
                CUD_SQL.Update_Vehicle_Status(Licensed_Plate, 1);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Btn_Activar_Estado_AdminAdminActionPerformed

    private void Btn_Activar_Estado_MecanicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Activar_Estado_MecanicaActionPerformed
        int Selected_Row = Tbl_Mecanica.getSelectedRow();
        String Selected_Item = (String) Jcb_Mecanica.getSelectedItem();

        if (Selected_Item.equals("Partes de Equipos")) {
            try {
                int Part_Id = (int) Tbl_Mecanica.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Part_Status(Part_Id, 1);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Tipos de Mantenimientos")) {
            try {
                int Maintenance_Id = (int) Tbl_Mecanica.getValueAt(Selected_Row, 0);
                CUD_SQL.Update_Maintenance_Type_Status(Maintenance_Id, 1);
            } catch (SQLException ex) {
                Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Selected_Item.equals("Asignacion de Mantenimientos")) {

        } else if (Selected_Item.equals("Boletas de Mantenimiento")) {

        }
    }//GEN-LAST:event_Btn_Activar_Estado_MecanicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Activar_Estado_Admin;
    private javax.swing.JButton Btn_Activar_Estado_Dispensador;
    private javax.swing.JButton Btn_Activar_Estado_Mecanica;
    private javax.swing.JButton Btn_Desactivar_Estado_Admin;
    private javax.swing.JButton Btn_Desactivar_Estado_Dispensador;
    private javax.swing.JButton Btn_Desactivar_Estado_Mecanica;
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
