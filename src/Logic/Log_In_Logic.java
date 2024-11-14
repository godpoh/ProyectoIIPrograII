/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Data.CUD_SQL;
import Data.Connection_SQL;
import static Data.Connection_SQL.get_Role;
import Presentation.Principal_Panel;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Log_In_Logic {

    public void Default_Text_PSW(JPasswordField txtContrasena, JTextField txtUsuario) {
        if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
            txtContrasena.setText("");
            txtContrasena.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su cedúla");
            txtUsuario.setForeground(Color.gray);
        }
    }

    public void Default_Text_User_Field(JTextField txtUsuario, JPasswordField txtContrasena) {
        if (txtUsuario.getText().equals("Ingrese su cedúla")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
            txtContrasena.setText("********");
            txtContrasena.setForeground(Color.gray);
        }
    }

    public void Open_Principal_Panel_Logic(JTextField txtUsuario, JPasswordField txtContrasena) throws SQLException {
        int get_User_Id = Integer.parseInt(txtUsuario.getText());
        String get_Password = String.valueOf(txtContrasena.getPassword());
        String Encrypted_Password = CUD_SQL.EncryptMD5(get_Password);
        try {
            Connection_SQL connectionSQL = new Connection_SQL();
            if (connectionSQL.Verify_User(get_User_Id, Encrypted_Password)) {
                String Role = get_Role(get_User_Id, Encrypted_Password);
                int Status = Connection_SQL.Verify_User_Status(get_User_Id);
                if (Status != 0) {
                    Principal_Panel principal_panel = new Principal_Panel(Role);
                    principal_panel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Este usuario está inactivo!", "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Intentelo de nuevo", "Mensaje Importante!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
