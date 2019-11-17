package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
        private JPasswordField passwordField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVirtualShop = new JLabel("Virtual Shop");
		lblVirtualShop.setBounds(49, 27, 424, 82);
		lblVirtualShop.setFont(new Font("Segoe UI Black", Font.PLAIN, 60));
		contentPane.add(lblVirtualShop);
		
		textField = new JTextField();
		textField.setBounds(49, 153, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 133, 48, 14);
		contentPane.add(lblName);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 200, 66, 14);
		contentPane.add(lblPassword);
                
                JLabel lblPassword2 = new JLabel("Repeat Password");
		lblPassword2.setBounds(49, 300, 150, 14);
		contentPane.add(lblPassword2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/Images/Register2.png")));
		btnNewButton.setBounds(217, 434, 66, 72);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField("qw");
		passwordField.setBounds(49, 250, 193, 20);
                passwordField2 = new JPasswordField("wqww");
		passwordField2.setBounds(49, 100, 193, 20);
		contentPane.add(passwordField);
                contentPane.add(passwordField2);
	}
}
