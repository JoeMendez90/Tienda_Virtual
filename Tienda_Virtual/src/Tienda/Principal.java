package Tienda;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import tienda_virtual.LectoUpdater;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

public class Principal extends JFrame {

    
    public int CantPrub;
    private JPanel contentPane;
   
    private CenterPane center;
    private JTextField txtSearch;

    public Tienda tienda;
    public ReturnAction actionsPrev;
    public int cant=100;
    
    public Principal(Tienda tienda, int CantPrub) {
        this.CantPrub= CantPrub;
        this.tienda=tienda;	
        actionsPrev= new ReturnAction();
        init();
        createFrame();    
    }
    
    private  void init(){
        center= new centerDefault(this, "");
        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#616161"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(center.getCenterPane());
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            LectoUpdater.Cerrar(tienda, CantPrub);
            System.out.println("Estoy cerrando");
        }
 });
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
        
        CreateUp();
        
        
        //contentPane.add(centerPan);
        
        setLocationRelativeTo(null);
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
            JButton logotipo = new JButton();
            logotipo.add(label);
            logotipo.setBackground(Color.decode("#212121"));
            logotipo.setBounds(0, 5, 300, 100);
            
            logotipo.addActionListener((e) -> {
                if(!(center instanceof centerDefault) || center.productoB){
                    center.getCenterPane().setVisible(false);
                    center = new centerDefault(this, "");
                    center.getCenterPane().setVisible(true);
                    contentPane.add(center.getCenterPane());
                }

                contentPane.validate();
            });
            
            
            
            up.add(logotipo);

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

            btnSearch.addActionListener((ActionEvent e) -> {
                search(txtSearch.getText());
                System.out.println(txtSearch.getText());
                actionsPrev.addAction("Search|"+txtSearch.getText());
                
            });

            JButton btnRegister = new JButton("");
            btnRegister.setIcon(createIcon("/Images/Register2.png"));
            btnRegister.setBounds(1069, 10, 74, 81);
            btnRegister.addActionListener((ActionEvent e) -> {
                if(tienda.actualUser.getUsername().equals("")){
                    Loggin login = new Loggin(this, true);
                    login.setVisible(true);
                    tienda.actualUser.searchGarage(tienda);
                }
                if(!tienda.actualUser.getUsername().equals("")){
                    center.getCenterPane().setVisible(false);
                    center = new centerCuenta(this, "");
                    center.getCenterPane().setVisible(true);
                    contentPane.add(center.getCenterPane());

                    contentPane.validate();
                    actionsPrev.addAction("Cuenta|");
                }
            });

            up.add(btnRegister);                                                     

            JButton btnCrt = new JButton("");
            btnCrt.setIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setSelectedIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setBounds(1153, 10, 74, 81);
            up.add(btnCrt);

            btnCrt.addActionListener((ActionEvent e) -> {
                if(!tienda.actualUser.getCarrito().isSearched()){
                    tienda.actualUser.getCarrito().search(tienda);
                }
                cart();
                actionsPrev.addAction("Car|");
                
            });
        contentPane.add(up);
        
    }
    
    
    public static ImageIcon createIcon(String icon, int x,int y){
        return new ImageIcon(new ImageIcon(Principal.class.getResource(icon)).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    public static ImageIcon createIcon(String icon){
        return new ImageIcon(Principal.class.getResource(icon));
    }
    
    public static Font createFont(Component component,int as){
        return new Font(component.getFont().getFontName(), component.getFont().getStyle(), component.getFont().getSize()+as);
    }

    private void returnAction() {
        String doAction=actionsPrev.Action();
        String[] subActions = doAction.split(Pattern.quote("|"));
        String hey;
        switch(subActions[0]){
            case "out":
                dispose();
                System.out.println("estoy cerrando 2");
            break;
            case "Search":
                System.out.println("Searchhhh");
                search(subActions[1]);
                hey ="";
                System.out.println("saliendocenter");
                for (int i= 2; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                center.Actions(hey);
                
                
            case "Center":
                System.out.println("centeerererre");
                hey ="";
                System.out.println("saliendocenter");
                for (int i = 1; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                System.out.println(hey);
                
                center.Actions(hey);
                
                    
            break;
            case "Car":
                cart();
            break;
            
        }
        
    }
   
    public void cart(){

        if(!(center instanceof centerCarr)|| center.productoB){
            center.getCenterPane().setVisible(false);
            center = new centerCarr(this, "this");
            center.getCenterPane().setVisible(true);
            contentPane.add(center.getCenterPane());
        }

        contentPane.validate();
    }
    
    public void search(String busqueda){

        if(!(center instanceof centerSearch) || !center.orden.equals(busqueda) || center.productoB){
            center.getCenterPane().setVisible(false);
            center = new centerSearch(this, busqueda);
            center.getCenterPane().setVisible(true);
            contentPane.add(center.getCenterPane());
        }

        contentPane.validate();
    }
    
}
