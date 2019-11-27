package Tienda;

import java.awt.BorderLayout;
import java.awt.Color;
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

            JLabel label = new JLabel();
            label.setBounds(70, 5, 300,100);
            label.setIcon(Principal.createIcon("/Images/Logotipo.png",300,100));
            contentPane.add(label);

            JLabel lblUsuario = new JLabel("Usuario");
            lblUsuario.setBounds(189, 105, 46, 14);
            contentPane.add(lblUsuario);

            textField = new JTextField();
            textField.setBounds(164, 125, 96, 20);
            contentPane.add(textField);
            textField.setColumns(10);

            JLabel lblPassword = new JLabel("Contrase\u00F1a");
            lblPassword.setBounds(179, 150, 71, 14);
            contentPane.add(lblPassword);

            passwordField = new JPasswordField();
            passwordField.setBounds(164, 170, 96, 20);
            contentPane.add(passwordField);

            JButton Registro = new JButton("Registrarse");
            
            Registro.setBounds(164, 220, 100, 30);
            
            Registro.addActionListener((ActionEvent e) -> {
                Register registro = new Register(princ, true);
                registro.setVisible(true);
                if(!princ.tienda.actualUser.getUsername().equals("")){
                    //central = centerUser();
                    dispose();
                }
                
            });
            
            
            JButton confirma = new JButton("Confirmar");
            
            confirma.setBounds(164, 260, 100, 30);
            JLabel lblerror = new JLabel("");
            lblerror.setBounds(100, 190, 300, 14);
            lblerror.setForeground(Color.red);
            
            confirma.addActionListener((ActionEvent e) -> {
                System.out.println("confirma");
                if(princ.tienda.Acceder(textField.getText(), passwordField.getText())){
                    dispose();
                }else{
                    lblerror.setText("usuario o contraseña incorrectos");
                    textField.setText("");
                    passwordField.setText("");
                }
            });
            
            
            contentPane.add(lblerror);
            contentPane.add(Registro);
            contentPane.add(confirma);
            setLocationRelativeTo(null);
        }
}
