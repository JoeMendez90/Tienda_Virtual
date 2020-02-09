package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class Cuenta2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
        JButton seh;
        JButton  search;
        JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuenta2 frame = new Cuenta2();
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
	public Cuenta2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 1254, 631);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(245, 222, 179));
		scrollPane.setViewportView(panel);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(325, 65, 535, 34);
		panel.add(textField);
		
		Label label = new Label("ValhasTim");
		label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 60));
		label.setBounds(10, 38, 296, 77);
		panel.add(label);
		
                  search =new JButton("Serch");
		search.setBounds(870, 71, 91, 23);
                search.addActionListener((e) -> {
                    System.out.println("search");
                });
                search.setVisible(true);
                
                seh =new JButton("set");
		seh.setBounds(870, 71, 91, 23);
                seh.addActionListener((e) -> {
                    System.out.println("seh");
                });
                 seh.setVisible(true);
                
		 button = search;
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/Captura2.png")));
		button_1.setBounds(985, 38, 74, 77);
                
                button_1.addActionListener((ActionEvent e) -> {
                        button = search;
                        button.validate();
                    
                });
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/Register2.png")));
		button_2.setBounds(1069, 38, 74, 77);
		panel.add(button_2);
                button_2.addActionListener((e) -> {
                        button = seh;
                        button.validate();
                });
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/carrito2.png")));
		button_3.setBounds(1153, 38, 74, 77);
		panel.add(button_3);
                button_3.addActionListener((e) -> {
                    search.setEnabled(!search.isEnabled());
                    button.validate();
                });
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.setBounds(10, 161, 341, 446);
		panel.add(layeredPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 341, 446);
		layeredPane.add(panel_1);
		
		JLabel label_1 = new JLabel("Datos de Usuario");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(22, 11, 153, 25);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre de usuario");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(58, 47, 140, 21);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Administrar");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(22, 142, 102, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("A\u00F1adir Producto");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(58, 190, 117, 21);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Eliminar Producto");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(58, 243, 130, 21);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Modificar Productto");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(58, 302, 143, 21);
		panel_1.add(label_6);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(58, 213, 109, 23);
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(58, 272, 109, 23);
		panel_1.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(58, 330, 109, 23);
		panel_1.add(radioButton_2);
		
		JButton button_4 = new JButton("Confirmar");
		button_4.setBounds(221, 399, 95, 23);
		panel_1.add(button_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(361, 161, 875, 446);
		//panel_2.setPreferredSize(new Dimension(875, 800)); /////////////////////////////////////////
		
		panel.add(panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 875, 446);
		panel_2.add(scrollPane_1);
		
		JPanel panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		panel_3.setPreferredSize(new Dimension(875, 15000));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 53, 0, 48, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 26, 0, 73, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 1;
		panel_3.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 1;
		panel_3.add(label_8, gbc_label_8);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 5;
		gbc_label_12.gridy = 1;
		panel_3.add(label_12, gbc_label_12);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto");
		GridBagConstraints gbc_lblNombreDelProducto = new GridBagConstraints();
		gbc_lblNombreDelProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelProducto.gridx = 1;
		gbc_lblNombreDelProducto.gridy = 2;
		panel_3.add(lblNombreDelProducto, gbc_lblNombreDelProducto);
		
		JLabel label_9 = new JLabel("Nombre del Producto");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 3;
		gbc_label_9.gridy = 2;
		panel_3.add(label_9, gbc_label_9);
		
		JLabel label_13 = new JLabel("Nombre del Producto");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 5;
		gbc_label_13.gridy = 2;
		panel_3.add(label_13, gbc_label_13);
		
		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 3;
		panel_3.add(lblPrecio, gbc_lblPrecio);
		
		JLabel label_10 = new JLabel("Precio");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 3;
		gbc_label_10.gridy = 3;
		panel_3.add(label_10, gbc_label_10);
		
		JLabel label_14 = new JLabel("Precio");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 5;
		gbc_label_14.gridy = 3;
		panel_3.add(label_14, gbc_label_14);
		
		JLabel lblDescripccion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripccion = new GridBagConstraints();
		gbc_lblDescripccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripccion.gridx = 1;
		gbc_lblDescripccion.gridy = 4;
		panel_3.add(lblDescripccion, gbc_lblDescripccion);
		
		JLabel label_11 = new JLabel("Descripcion");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 3;
		gbc_label_11.gridy = 4;
		panel_3.add(label_11, gbc_label_11);
		
		JLabel label_15 = new JLabel("Descripcion");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 5;
		gbc_label_15.gridy = 4;
		panel_3.add(label_15, gbc_label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 1;
		gbc_label_16.gridy = 5;
		panel_3.add(label_16, gbc_label_16);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 3;
		gbc_label_18.gridy = 5;
		panel_3.add(label_18, gbc_label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 5;
		gbc_label_19.gridy = 5;
		panel_3.add(label_19, gbc_label_19);
	}
}
