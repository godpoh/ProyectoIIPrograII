/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentation;

/**
 *
 * @author user
 */
public class Principal_Panel extends javax.swing.JFrame {

    public Principal_Panel(String Role) {
        initComponents();
        setLocationRelativeTo(null);
        Btn_Pnl_Admin.setVisible(false);

        setPreferredSize(new java.awt.Dimension(720, 720));
        pack();

        if ("Admin".equalsIgnoreCase(Role)) {
            Show_Admin_Panels();
        } else {
            Hide_Admin_Panels();
        }

    }

    private void Show_Admin_Panels() {
        Btn_Pnl_Admin.setVisible(true);
    }

    private void Hide_Admin_Panels() {
        Btn_Pnl_Admin.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Menu = new javax.swing.JPanel();
        Btn_Mecanico = new javax.swing.JButton();
        Btn_Estadisticas = new javax.swing.JButton();
        Btn_Dispensador = new javax.swing.JButton();
        Pnl_Titulo = new javax.swing.JPanel();
        Btn_Cerrar_Sesion = new javax.swing.JButton();
        Btn_Pnl_Admin = new javax.swing.JButton();
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
        Btn_Mecanico.setText("Mecanico");
        Btn_Mecanico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Mecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MecanicoActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Mecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 150, 50));

        Btn_Estadisticas.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Estadisticas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Estadisticas.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Estadisticas.setText("Estadísticas");
        Btn_Estadisticas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EstadisticasActionPerformed(evt);
            }
        });
        Pnl_Menu.add(Btn_Estadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 150, 50));

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
        Pnl_Titulo.add(Btn_Cerrar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 0, 131, 29));

        Btn_Pnl_Admin.setBackground(new java.awt.Color(255, 111, 97));
        Btn_Pnl_Admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Pnl_Admin.setForeground(new java.awt.Color(51, 51, 51));
        Btn_Pnl_Admin.setText("Panel de Admin");
        Btn_Pnl_Admin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Pnl_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Pnl_AdminActionPerformed(evt);
            }
        });
        Pnl_Titulo.add(Btn_Pnl_Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 131, 29));

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


    private void Btn_MecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MecanicoActionPerformed
//        Tournament_Management Tournament_Window = null;
//        try {
////            Tournament_Window = new Tournament_Management();
//        } catch (SQLException ex) {
//            Logger.getLogger(Principal_Panel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Tournament_Window.setSize(820, 688);
//        Tournament_Window.setLocation(0, 0);
//
//        Pnl_Contenedor.removeAll();
//        Pnl_Contenedor.add(Tournament_Window);
//
//        Pnl_Contenedor.revalidate();
//        Pnl_Contenedor.repaint();

    }//GEN-LAST:event_Btn_MecanicoActionPerformed

    private void Btn_EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EstadisticasActionPerformed

    }//GEN-LAST:event_Btn_EstadisticasActionPerformed

    private void Btn_DispensadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DispensadorActionPerformed
//        Team_Managment Team = null;
//        try {
//            Team = new Team_Managment();
//       
//        } catch (SQLException ex) {
//            Logger.getLogger(Principal_Panel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Team.setSize(820, 688);
//        Team.setLocation(0, 0);
//        
//        Pnl_Contenedor.removeAll();
//        Pnl_Contenedor.add(Team);
//
//        Pnl_Contenedor.revalidate();
//        Pnl_Contenedor.repaint();

    }//GEN-LAST:event_Btn_DispensadorActionPerformed

    private void Btn_Cerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Cerrar_SesionActionPerformed
        this.dispose();

        Log_In Login_Window = new Log_In();
        Login_Window.setVisible(true);
    }//GEN-LAST:event_Btn_Cerrar_SesionActionPerformed

    private void Btn_Pnl_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Pnl_AdminActionPerformed
        Admin_Panel Admin_Window = new Admin_Panel();
        Admin_Window.setSize(820, 688);
        Admin_Window.setLocation(0, 0);

        Pnl_Contenedor.removeAll();
        Pnl_Contenedor.add(Admin_Window);

        Pnl_Contenedor.revalidate();
        Pnl_Contenedor.repaint();
    }//GEN-LAST:event_Btn_Pnl_AdminActionPerformed

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
    private javax.swing.JButton Btn_Dispensador;
    private javax.swing.JButton Btn_Estadisticas;
    private javax.swing.JButton Btn_Mecanico;
    private javax.swing.JButton Btn_Pnl_Admin;
    private javax.swing.JPanel Pnl_Contenedor;
    private javax.swing.JPanel Pnl_Menu;
    private javax.swing.JPanel Pnl_Titulo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
