/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentation;

import Logic.Log_In_Logic;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class Principal_Panel extends javax.swing.JFrame {

    String Instance_Role = "";

    public Principal_Panel(String Role) {
        initComponents();
        setLocationRelativeTo(null);
        Btn_Pnl_Ad.setVisible(false);

        Instance_Role = Role;

        setPreferredSize(new java.awt.Dimension(720, 720));
        pack();

        Show_Admin_Panel(Role);
    }

    // Obtiene el rol desde el login, y verifica que debe mostrar o no el panel de admin
    private void Show_Admin_Panel(String Role) {
        if ("Admin".equalsIgnoreCase(Role)) {
            Btn_Pnl_Ad.setVisible(true);
        } else {
            Btn_Pnl_Ad.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Menu = new javax.swing.JPanel();
        Btn_Mecanico = new javax.swing.JButton();
        Btn_Reportes = new javax.swing.JButton();
        Btn_Dispensador = new javax.swing.JButton();
        Btn_Estado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pnl_Titulo = new javax.swing.JPanel();
        Btn_Cerrar_Sesion = new javax.swing.JButton();
        Btn_Pnl_Ad = new javax.swing.JButton();
        Btn_Chofer_Conductor = new javax.swing.JButton();
        Pnl_Contenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 716));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Menu.setBackground(new java.awt.Color(250, 235, 215));
        Pnl_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Mecanico.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Mecanico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Mecanico.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Mecanico.setText("Mecánica");
        Btn_Mecanico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Mecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MecanicoActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Mecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 50));

        Btn_Reportes.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Reportes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Reportes.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Reportes.setText("Reportes");
        Btn_Reportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReportesActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 50));

        Btn_Dispensador.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Dispensador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Dispensador.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Dispensador.setText("Dispensador");
        Btn_Dispensador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Dispensador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DispensadorActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Dispensador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 150, 50));

        Btn_Estado.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Estado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Estado.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Estado.setText("Estado");
        Btn_Estado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EstadoActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 150, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mecanico-removebg-preview.png"))); // NOI18N
        Pnl_Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 20, 220, 190));

        getContentPane().add(Pnl_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 720));

        Pnl_Titulo.setBackground(new java.awt.Color(245, 215, 215));
        Pnl_Titulo.setPreferredSize(new java.awt.Dimension(760, 50));
        Pnl_Titulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Cerrar_Sesion.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Cerrar_Sesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Cerrar_Sesion.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Cerrar_Sesion.setText("Cerrar Sesión");
        Btn_Cerrar_Sesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Cerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Cerrar_SesionActionPerformed(evt);
            }
        });
        Pnl_Titulo.add(Btn_Cerrar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 131, 29));

        Btn_Pnl_Ad.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Pnl_Ad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Pnl_Ad.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Pnl_Ad.setText("Panel de Administrador");
        Btn_Pnl_Ad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Pnl_Ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Pnl_AdActionPerformed(evt);
            }
        });
        Pnl_Titulo.add(Btn_Pnl_Ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 29));

        Btn_Chofer_Conductor.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Chofer_Conductor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Chofer_Conductor.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Chofer_Conductor.setText("Empleados");
        Btn_Chofer_Conductor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Chofer_Conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Chofer_ConductorActionPerformed(evt);
            }
        });
        Pnl_Titulo.add(Btn_Chofer_Conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 180, 29));

        getContentPane().add(Pnl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 820, 30));

        Pnl_Contenedor.setMinimumSize(new java.awt.Dimension(820, 800));
        Pnl_Contenedor.setPreferredSize(new java.awt.Dimension(820, 800));

        javax.swing.GroupLayout Pnl_ContenedorLayout = new javax.swing.GroupLayout(Pnl_Contenedor);
        Pnl_Contenedor.setLayout(Pnl_ContenedorLayout);
        Pnl_ContenedorLayout.setHorizontalGroup(
            Pnl_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Pnl_ContenedorLayout.setVerticalGroup(
            Pnl_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(Pnl_Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 820, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Boton que muestra el Panel de la seccion de mecanica
    private void Btn_MecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MecanicoActionPerformed
        Mechanics_Section Mechanic_Window = null;
        try {
            Mechanic_Window = new Mechanics_Section();
        } catch (SQLException ex) {
            Logger.getLogger(Principal_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mechanic_Window.setSize(820, 688);
        Mechanic_Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Mechanic_Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_MecanicoActionPerformed

    private void Btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReportesActionPerformed
        Reports Window = null;
        try {
            Window = new Reports();
        } catch (SQLException ex) {
            Logger.getLogger(Principal_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Window.setSize(820, 688);
        Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_ReportesActionPerformed
    // Boton que muestra el Panel de la seccion del dispensador
    private void Btn_DispensadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DispensadorActionPerformed
        Dispenser_Section Window = null;
        try {
            Window = new Dispenser_Section();
        } catch (SQLException ex) {
            Logger.getLogger(Principal_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Window.setSize(820, 688);
        Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_DispensadorActionPerformed

    // Boton que muestra el Panel de la seccion de los estados
    private void Btn_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EstadoActionPerformed
        Status Status_Window = new Status(Instance_Role);
        Status_Window.setSize(820, 688);
        Status_Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Status_Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_EstadoActionPerformed
//GEN-FIRST:event_Btn_Pnl_AdminActionPerformed
//GEN-LAST:event_Btn_Pnl_AdminActionPerformed
    private void Btn_Pnl_AdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Pnl_AdActionPerformed
        Admin_Panel Admin = new Admin_Panel();
        Admin.setSize(820, 688);
        Admin.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Admin);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_Pnl_AdActionPerformed

    private void Btn_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Cerrar_SesionActionPerformed
        Window window = SwingUtilities.getWindowAncestor(Btn_Cerrar_Sesion);
        window.dispose();
        Log_In Log_Window = new Log_In();
        Log_Window.setVisible(true);
    }//GEN-LAST:event_Btn_Cerrar_SesionActionPerformed

    private void Btn_Chofer_ConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Chofer_ConductorActionPerformed
        Driver_Mechanic Window = new Driver_Mechanic();
        Window.setSize(820, 688);
        Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();

    }//GEN-LAST:event_Btn_Chofer_ConductorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_Panel("User").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar_Sesion;
    private javax.swing.JButton Btn_Chofer_Conductor;
    private javax.swing.JButton Btn_Dispensador;
    private javax.swing.JButton Btn_Estado;
    private javax.swing.JButton Btn_Mecanico;
    private javax.swing.JButton Btn_Pnl_Ad;
    private javax.swing.JButton Btn_Reportes;
    private javax.swing.JPanel Pnl_Contenedor;
    private javax.swing.JPanel Pnl_Menu;
    private javax.swing.JPanel Pnl_Titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
