package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class Cuenta_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuenta frame = new Cuenta();
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
	public Cuenta_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(245, 222, 179));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(325, 65, 535, 34);
		textField.setToolTipText("");
		textField.setColumns(10);
		panel.add(textField);
		
		Label label_1 = new Label("ValhasTim");
		label_1.setBounds(10, 38, 296, 77);
		label_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 60));
		panel.add(label_1);
		
		JButton button = new JButton("Serch");
		button.setBounds(870, 71, 91, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/Captura2.png")));
		button_1.setBounds(985, 38, 74, 77);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/Register2.png")));
		button_2.setBounds(1069, 38, 74, 77);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/carrito2.png")));
		button_3.setBounds(1153, 38, 74, 77);
		panel.add(button_3);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 161, 341, 459);
		panel.add(layeredPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 341, 459);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatosDeUsuario = new JLabel("Datos de Usuario");
		lblDatosDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDeUsuario.setBounds(22, 11, 153, 25);
		panel_1.add(lblDatosDeUsuario);
		
		JLabel lblNombre = new JLabel("Nombre de usuario");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(58, 47, 140, 21);
		panel_1.add(lblNombre);
		
		JLabel lblAdministrar = new JLabel("Administrar");
		lblAdministrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdministrar.setBounds(22, 142, 102, 25);
		panel_1.add(lblAdministrar);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(58, 190, 117, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblEliminarProducto = new JLabel("Eliminar Producto");
		lblEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEliminarProducto.setBounds(58, 243, 130, 21);
		panel_1.add(lblEliminarProducto);
		
		JLabel lblModificarProductto = new JLabel("Modificar Productto");
		lblModificarProductto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblModificarProductto.setBounds(58, 302, 143, 21);
		panel_1.add(lblModificarProductto);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(58, 213, 109, 23);
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(58, 272, 109, 23);
		panel_1.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(58, 330, 109, 23);
		panel_1.add(radioButton_2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(215, 425, 95, 23);
		panel_1.add(btnConfirmar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(361, 161, 883, 459);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		lblArticulo.setBackground(Color.WHITE);
		lblArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticulo.setBounds(68, 11, 100, 100);
		panel_2.add(lblArticulo);
		
		JLabel label = new JLabel("Articulo");
		label.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setBounds(226, 11, 100, 100);
		panel_2.add(label);
		
		JLabel label_2 = new JLabel("Articulo");
		label_2.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(543, 11, 100, 100);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Articulo");
		label_3.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(385, 11, 100, 100);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Articulo");
		label_4.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(68, 152, 100, 100);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Articulo");
		label_5.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(226, 152, 100, 100);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Articulo");
		label_6.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(385, 152, 100, 100);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Articulo");
		label_7.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(543, 152, 100, 100);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Articulo");
		label_8.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(68, 302, 100, 100);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Articulo");
		label_9.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(226, 302, 100, 100);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Articulo");
		label_10.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(385, 302, 100, 100);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Articulo");
		label_11.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBackground(Color.WHITE);
		label_11.setBounds(543, 302, 100, 100);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Articulo");
		label_12.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBackground(Color.WHITE);
		label_12.setBounds(703, 11, 100, 100);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Articulo");
		label_13.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(703, 152, 100, 100);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Articulo");
		label_14.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBackground(Color.WHITE);
		label_14.setBounds(703, 302, 100, 100);
		panel_2.add(label_14);
		
		JLabel lblDetalles = new JLabel("Detalles");
		lblDetalles.setBounds(68, 122, 48, 14);
		panel_2.add(lblDetalles);
		
		JLabel label_15 = new JLabel("Detalles");
		label_15.setBounds(68, 263, 48, 14);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Detalles");
		label_16.setBounds(68, 413, 48, 14);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Detalles");
		label_17.setBounds(226, 413, 48, 14);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel("Detalles");
		label_18.setBounds(226, 263, 48, 14);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel("Detalles");
		label_19.setBounds(226, 122, 48, 14);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("Detalles");
		label_20.setBounds(543, 413, 48, 14);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("Detalles");
		label_21.setBounds(543, 263, 48, 14);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("Detalles");
		label_22.setBounds(543, 122, 48, 14);
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("Detalles");
		label_23.setBounds(385, 122, 48, 14);
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("Detalles");
		label_24.setBounds(385, 263, 48, 14);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel("Detalles");
		label_25.setBounds(385, 413, 48, 14);
		panel_2.add(label_25);
		
		JLabel label_26 = new JLabel("Detalles");
		label_26.setBounds(703, 413, 48, 14);
		panel_2.add(label_26);
		
		JLabel label_27 = new JLabel("Detalles");
		label_27.setBounds(703, 263, 48, 14);
		panel_2.add(label_27);
		
		JLabel label_28 = new JLabel("Detalles");
		label_28.setBounds(703, 122, 48, 14);
		panel_2.add(label_28);
	}
}
