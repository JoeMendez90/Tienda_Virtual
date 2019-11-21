package Tienda;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import tienda_virtual.Carrito;
import tienda_virtual.LectoUpdater;

public class Register extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
        private JPasswordField passwordField2;
        private Principal princ;

	/**
	 * Create the frame.
	 */
	public Register(Principal principal,boolean mode){
            super(principal,mode);
            this.princ=principal;
            CreateDialog();
        }
       

	/**
	 * Create the frame.
	 */
	public Register() {		
            CreateDialog();
	}
        private void CreateDialog() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 556);
                setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVirtualShop = new JLabel();
		lblVirtualShop.setBounds(100, 10, 424, 82);
                lblVirtualShop.setIcon(Principal.createIcon("/Images/Logotipo.png", 300, 100));
		contentPane.add(lblVirtualShop);
		
                JLabel lblName = new JLabel("Name");
		lblName.setBounds(100, 120, 48, 14);
		contentPane.add(lblName);
                
		textField = new JTextField();
		textField.setBounds(100, 140, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 170, 66, 14);
		contentPane.add(lblPassword);
                
                JLabel lblPassword2 = new JLabel("Repeat Password");
		lblPassword2.setBounds(100, 220, 150, 14);
		contentPane.add(lblPassword2);
		
                JLabel error = new JLabel("");
		error.setBounds(100, 300, 424, 82);
		contentPane.add(error);
                
		
		passwordField = new JPasswordField("");
		passwordField.setBounds(100, 190, 193, 20);
                passwordField2 = new JPasswordField("");
		passwordField2.setBounds(100, 250, 193, 20);
		contentPane.add(passwordField);
                contentPane.add(passwordField2);
                
                JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(100, 350, 100, 40);
                
                btnNewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        switch(LectoUpdater.CrearCuenta(textField.getText(), passwordField.getText(), passwordField2.getText(),princ.tienda, princ.CantPrub)){
                            case -1:
                                error.setText("Contraseñas no coinciden");
                            break;
                            case 1:
                                error.setText("usuario Ya existe");
                            break;
                            default:
                                error.setText("");
                                Carrito carr = princ.tienda.actualUser.getCarrito();
                                princ.tienda.actualUser = princ.tienda.users.get(princ.tienda.users.tam-1);                                
                                princ.tienda.actualUser.setCarrito(carr);
                                dispose();
                            break;
                        }
                        textField.setText("");
                        passwordField.setText("");
                        passwordField2.setText("");
                    }
                });
                
		contentPane.add(btnNewButton);
                JButton btnNewButton2 = new JButton("Regresar");
		btnNewButton2.setBounds(100, 450, 100, 40);
                
                btnNewButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                
		contentPane.add(btnNewButton2);
	}
}
