package Tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import javax.swing.JMenuBar;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;
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
import tienda_virtual.Stack;
import tienda_virtual.Tienda;
import tienda_virtual.Usuario;

public class Principal extends JFrame {

    
    private int CantPrub;
    private JPanel contentPane;
    private JPanel centerPane;
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
        centerPane = new JPanel();
        centerPane.setBounds(5, 170, 1265, 475);
        centerPane.setBackground(Color.decode("#424242"));
        
        //centerPane.setLayout(new);
        for (int i = 0; i < 10; i++) {
            centerPane.add(new JLabel("heyafdsdsdsdsdsdsdsds"));
        }
        
        JScrollPane scroll = new JScrollPane();
        contentPane.add(/*new JScrollPane(*/centerPane/*)*/);
        //productsList();
        setLocationRelativeTo(null);
    }
        
    public void CreateUp(){
        JPanel up= new JPanel();
        up.setBounds(5,5,1265,160);
        up.setBackground(Color.decode("#212121"));
        up.setLayout(null);

            txtSearch = new JTextField("search");
            txtSearch.setBounds(325, 50, 535, 50);
            txtSearch.setToolTipText("");
            txtSearch.setFont(createFont(txtSearch, 20));
            up.add(txtSearch);
            txtSearch.setColumns(10);

            JLabel label = new JLabel();
            label.setIcon(createIcon("/Images/LogotipoBlanc.png", 300, 100));
            label.setBounds(0, 25, 300, 100);
            up.add(label);

            JButton btnExit = new JButton();
            btnExit.setBackground(Color.LIGHT_GRAY);
            btnExit.setIcon(createIcon("/Images/Captura2.png",80,80));
            btnExit.setBorder(new EmptyBorder(20, 20, 20, 20));
            btnExit.setBounds(950, 38, 100, 80);

            btnExit.addActionListener((ActionEvent e) -> {
                returnAction();
            });

            up.add(btnExit);

            JButton btnSearch = new JButton("");
            btnSearch.setIcon(createIcon("/Images/Search.png",50,40));
            btnSearch.setBounds(870, 50, 50, 50);
            up.add(btnSearch);

            btnSearch.addActionListener((ActionEvent e) -> {/*
                if(tienda.actualUser.getUsername()!=null)               falta
                    System.out.println(tienda.actualUser.getUsername());*/
            });

            JButton btnRegister = new JButton("");
            btnRegister.setIcon(createIcon("/Images/Register2.png"));
            btnRegister.setBounds(1069, 38, 74, 81);
            btnRegister.addActionListener((ActionEvent e) -> {
                Loggin login = new Loggin(this, true);
                login.setVisible(true);
            });

            up.add(btnRegister);                                                     

            JButton btnCrt = new JButton("");
            btnCrt.setIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setSelectedIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setBounds(1153, 38, 74, 81);
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

    
}
