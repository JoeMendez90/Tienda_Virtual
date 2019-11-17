package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import tienda_virtual.LectoUpdater;
import tienda_virtual.Usuario;

public class Loggin extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
        private Principal princ;

        public Loggin(Principal principal,boolean mode){
            super(principal,mode);
            this.princ=principal;
            CreateDialog();
        }
       

	/**
	 * Create the frame.
	 */
	public Loggin() {		
            CreateDialog();
	}
        private void CreateDialog(){
            setBounds(0, 0, 450, 342);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel label = new JLabel("Virtual Shop");
            label.setBounds(31, 11, 366, 82);
            label.setFont(new Font("Segoe UI Black", Font.PLAIN, 60));
            contentPane.add(label);

            JLabel lblUsuario = new JLabel("Usuario");
            lblUsuario.setBounds(189, 104, 46, 14);
            contentPane.add(lblUsuario);

            textField = new JTextField();
            textField.setBounds(164, 129, 96, 20);
            contentPane.add(textField);
            textField.setColumns(10);

            JLabel lblPassword = new JLabel("Contrase\u00F1a");
            lblPassword.setBounds(179, 160, 71, 14);
            contentPane.add(lblPassword);

            passwordField = new JPasswordField();
            passwordField.setBounds(164, 185, 96, 20);
            contentPane.add(passwordField);

            JButton Registro = new JButton("Registrarse");
            
            Registro.setBounds(164, 220, 100, 30);
            
            JButton confirma = new JButton("Confirmar");
            
            confirma.setBounds(164, 260, 100, 30);
            
            confirma.addActionListener((ActionEvent e) -> {
                //if()
            });
            contentPane.add(Registro);
            contentPane.add(confirma);
            setLocationRelativeTo(null);
        }
}
