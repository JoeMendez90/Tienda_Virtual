package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Articulos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articulos frame = new Articulos();
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
	public Articulos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(166, 68, 100, 100);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(166, 191, 100, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(219, 25, 71, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(292, 25, 79, 23);
		contentPane.add(btnRegister);
		
		JButton btnCrt = new JButton("Crt");
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrt.setBounds(381, 25, 53, 23);
		contentPane.add(btnCrt);
		
		JLabel lblVirtualShop = new JLabel("Virtual Shop");
		lblVirtualShop.setBounds(10, 11, 71, 23);
		contentPane.add(lblVirtualShop);
		
		JRadioButton rdbtnAadir = new JRadioButton("A\u00F1adir");
		rdbtnAadir.setBounds(262, 172, 109, 23);
		contentPane.add(rdbtnAadir);
	}
}
