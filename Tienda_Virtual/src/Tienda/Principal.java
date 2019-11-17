package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Label;
import javax.swing.JMenuBar;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.Stack;
import tienda_virtual.Tienda;
import tienda_virtual.Usuario;

public class Principal extends JFrame {

    
    private int CantPrub;
    private JPanel contentPane;
    private CardLayout centerLayout;
    private JPanel BarajaCentral;
    private DinamicArray<JPanel> centerPane;
    private JTextField txtSearch;

    public Tienda tienda;
    public Stack<String> actionsPrev;
    public int cant=100;
    
    public Principal(Tienda tienda, int CantPrub) {
        this.CantPrub= CantPrub;
        this.tienda=tienda;	
        actionsPrev= new Stack<>();
        createFrame();    
    }

    private void createFrame(){
        setType(Type.POPUP);
        setResizable(false);
        setFont(new Font("Ravie", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setIconImage(createIcon("/Images/Isotipo.png").getImage());
        setTitle(tienda.TiendName);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 680);
        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#616161"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        CreateUp();
        
        centerLayout = new CardLayout();
        BarajaCentral = new JPanel(centerLayout);
        centerPane =  new DinamicArray<>();
        centerPane.addBack(new JPanel()); // lista de productos(busqueda)
        centerPane.addBack(new JPanel()); // Cuenta/productos
        centerPane.addBack(new JPanel()); // carrito
        BarajaCentral.add(centerPane.get(0),"Busqueda");
        BarajaCentral.add(centerPane.get(1),"Cuenta");
        BarajaCentral.add(centerPane.get(2),"Carrito");
        BuscarProductos();
        contentPane.add(BarajaCentral);
        
        setLocationRelativeTo(null);
    }
    
    
    public void MostrarProductos(DinamicArray<Producto> productos){
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 875, 446);
                scrollPane_1.setBackground(Color.decode("#424242"));
		//centerPane.add(scrollPane_1);
		
		JPanel panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		//panel_3.setLayout(null);
                panel_3.setBackground(Color.decode("#424242"));
		/*GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 53, 0, 48, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 26, 0, 73, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);*/
                JPanel j = new JPanel();
                j.setSize(1000, 500);
                j.setBackground(Color.red);
		
                
                JButton button = new JButton();
                button.add(j);
                panel_3.add(button);
                
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
                label_7.setBounds(500,500,400,400);
                JLabel label = new JLabel("                 ");
                label.setSize(300,200);
                j.add(label);
		/*GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 1;*/
		j.add(label_7/*, gbc_label_7*/);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		/*GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 1;*/
		panel_3.add(label_8/*, gbc_label_8*/);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Cuenta.class.getResource("/Images/images.jpg")));
		/*GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 5;
		gbc_label_12.gridy = 1;*/
		panel_3.add(label_12 /*, gbc_label_12*/);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto");
		/*GridBagConstraints gbc_lblNombreDelProducto = new GridBagConstraints();
		gbc_lblNombreDelProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDelProducto.gridx = 1;
		gbc_lblNombreDelProducto.gridy = 2;*/
		panel_3.add(lblNombreDelProducto/*, gbc_lblNombreDelProducto*/);
		
		JLabel label_9 = new JLabel("Nombre del Producto");
		/*GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 3;
		gbc_label_9.gridy = 2;*/
		panel_3.add(label_9/*, gbc_label_9*/);
		/*
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
		panel_3.add(label_19, gbc_label_19);*/
    }
        
    public void CreateUp(){
        JPanel up= new JPanel();
        up.setBounds(5,5,1265,100);
        up.setBackground(Color.decode("#212121"));
        up.setLayout(null);

            txtSearch = new JTextField("");
            txtSearch.setBounds(325, 25, 535, 50);
            txtSearch.setToolTipText("");
            txtSearch.setFont(createFont(txtSearch, 20));
            up.add(txtSearch);
            txtSearch.setColumns(10);

            JLabel label = new JLabel();
            label.setIcon(createIcon("/Images/LogotipoBlanc.png", 300, 100));
            label.setBounds(0, 5, 300, 100);
            up.add(label);

            JButton btnExit = new JButton();
            btnExit.setBackground(Color.LIGHT_GRAY);
            btnExit.setIcon(createIcon("/Images/Captura2.png",80,80));
            btnExit.setBorder(new EmptyBorder(20, 20, 20, 20));
            btnExit.setBounds(950, 10, 100, 80);

            btnExit.addActionListener((ActionEvent e) -> {
                returnAction();
            });

            up.add(btnExit);

            JButton btnSearch = new JButton("");
            btnSearch.setIcon(createIcon("/Images/Search.png",50,40));
            btnSearch.setBounds(870, 25, 50, 50);
            up.add(btnSearch);

            btnSearch.addActionListener((ActionEvent e) -> {/*
                if(tienda.actualUser.getUsername()!=null)               falta
                    System.out.println(tienda.actualUser.getUsername());*/
            });

            JButton btnRegister = new JButton("");
            btnRegister.setIcon(createIcon("/Images/Register2.png"));
            btnRegister.setBounds(1069, 10, 74, 81);
            btnRegister.addActionListener((ActionEvent e) -> {
                Loggin login = new Loggin(this, true);
                login.setVisible(true);
            });

            up.add(btnRegister);                                                     

            JButton btnCrt = new JButton("");
            btnCrt.setIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setSelectedIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setBounds(1153, 10, 74, 81);
            up.add(btnCrt);

            btnCrt.addActionListener((ActionEvent e) -> {
                ShowCar();
            });
        contentPane.add(up);
        
    }
    
    private ImageIcon createIcon(String icon, int x,int y){
        return new ImageIcon(new ImageIcon(Principal.class.getResource(icon)).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    private ImageIcon createIcon(String icon){
        return new ImageIcon(Principal.class.getResource(icon));
    }
    
    private Font createFont(Component component,int as){
        return new Font(component.getFont().getFontName(), component.getFont().getStyle(), component.getFont().getSize()+as);
    }

    public void productsList(){
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBounds(269, 263, 100, 100);
        contentPane.add(scrollPane);
        

        JRadioButton rdbtnAadirAlCarrito = new JRadioButton("A\u00F1adir al carrito");
        rdbtnAadirAlCarrito.setBounds(260, 369, 109, 23);
        contentPane.add(rdbtnAadirAlCarrito);

        JRadioButton radioButton = new JRadioButton("A\u00F1adir al carrito");
        radioButton.setBounds(375, 369, 109, 23);
        contentPane.add(radioButton);

        ScrollPane scrollPane_1 = new ScrollPane();
        scrollPane_1.setBounds(384, 263, 100, 100);
        contentPane.add(scrollPane_1);

        JRadioButton radioButton_1 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_1.setBounds(490, 369, 109, 23);
        contentPane.add(radioButton_1);

        ScrollPane scrollPane_2 = new ScrollPane();
        scrollPane_2.setBounds(499, 263, 100, 100);
        contentPane.add(scrollPane_2);

        JRadioButton radioButton_2 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_2.setBounds(605, 369, 109, 23);
        contentPane.add(radioButton_2);

        ScrollPane scrollPane_3 = new ScrollPane();
        scrollPane_3.setBounds(614, 263, 100, 100);
        contentPane.add(scrollPane_3);

        JRadioButton radioButton_3 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_3.setBounds(720, 369, 109, 23);
        contentPane.add(radioButton_3);

        ScrollPane scrollPane_4 = new ScrollPane();
        scrollPane_4.setBounds(729, 263, 100, 100);
        contentPane.add(scrollPane_4);

        JRadioButton radioButton_4 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_4.setBounds(835, 369, 109, 23);
        contentPane.add(radioButton_4);

        ScrollPane scrollPane_5 = new ScrollPane();
        scrollPane_5.setBounds(844, 263, 100, 100);
        contentPane.add(scrollPane_5);

        JRadioButton radioButton_5 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_5.setBounds(950, 369, 109, 23);
        contentPane.add(radioButton_5);

        ScrollPane scrollPane_6 = new ScrollPane();
        scrollPane_6.setBounds(959, 263, 100, 100);
        contentPane.add(scrollPane_6);

        JRadioButton radioButton_6 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_6.setBounds(949, 501, 109, 23);
        contentPane.add(radioButton_6);

        ScrollPane scrollPane_7 = new ScrollPane();
        scrollPane_7.setBounds(958, 395, 100, 100);
        contentPane.add(scrollPane_7);

        ScrollPane scrollPane_8 = new ScrollPane();
        scrollPane_8.setBounds(268, 395, 100, 100);
        contentPane.add(scrollPane_8);

        JRadioButton radioButton_7 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_7.setBounds(259, 501, 109, 23);
        contentPane.add(radioButton_7);

        ScrollPane scrollPane_12 = new ScrollPane();
        scrollPane_12.setBounds(383, 395, 100, 100);
        contentPane.add(scrollPane_12);

        JRadioButton radioButton_8 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_8.setBounds(374, 501, 109, 23);
        contentPane.add(radioButton_8);

        ScrollPane scrollPane_13 = new ScrollPane();
        scrollPane_13.setBounds(498, 395, 100, 100);
        contentPane.add(scrollPane_13);

        JRadioButton radioButton_9 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_9.setBounds(489, 501, 109, 23);
        contentPane.add(radioButton_9);

        ScrollPane scrollPane_14 = new ScrollPane();
        scrollPane_14.setBounds(613, 395, 100, 100);
        contentPane.add(scrollPane_14);

        JRadioButton radioButton_10 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_10.setBounds(604, 501, 109, 23);
        contentPane.add(radioButton_10);

        ScrollPane scrollPane_15 = new ScrollPane();
        scrollPane_15.setBounds(728, 395, 100, 100);
        contentPane.add(scrollPane_15);

        JRadioButton radioButton_11 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_11.setBounds(719, 501, 109, 23);
        contentPane.add(radioButton_11);

        ScrollPane scrollPane_16 = new ScrollPane();
        scrollPane_16.setBounds(843, 395, 100, 100);
        contentPane.add(scrollPane_16);

        JRadioButton radioButton_12 = new JRadioButton("A\u00F1adir al carrito");
        radioButton_12.setBounds(834, 501, 109, 23);
        contentPane.add(radioButton_12);
    }

    private void returnAction() {
        
        if(actionsPrev.isEmpty()){
            dispose();
            return;
        }
        switch( actionsPrev.Peek().key){
            
            
        
        }
        
        actionsPrev.Pop();
    }

    private void ShowCar() {
        for (int i = 0; i < 10; i++) {
            System.out.println(tienda.prod.get(i).getId());
        }
        
    }

    private void BuscarProductos() {
        centerPane.get(0).setLayout(null);
        centerPane.get(0).setBackground(Color.decode("#424242"));
        centerPane.get(0).setBounds(5, 110, 1265, 565);
        String search=txtSearch.getText();
        DinamicArray<Producto> resultados = tienda.Buscar(search);
        MostrarProductos(resultados);
        centerLayout.show(BarajaCentral, "Busqueda");
        
        
    }

    
}
