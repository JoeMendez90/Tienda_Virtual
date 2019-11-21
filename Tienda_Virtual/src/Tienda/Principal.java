package Tienda;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

public class Principal extends JFrame {

    
    public int CantPrub;
    private JPanel contentPane;
    private JPanel centerPan;
    private CenterPane search;
    private CenterPane carr;
    private CenterPane product;
    private CenterPane cuentaP;
    private CenterPane cuenta;
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
        search= new centerSearch(this, "", actionsPrev);
        //carr = new centerCarr(this, "", actionsPrev);
        product = new centerProducto(this, "Product", actionsPrev, null);
        cuentaP = new centerSearch(this, "", actionsPrev);
        cuenta = new centerSearch(this, "", actionsPrev);
        product.getCenterPane().setVisible(false);
        cuenta.getCenterPane().setVisible(false);
        search.getCenterPane().setVisible(true);
        cuentaP.getCenterPane().setVisible(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#616161"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(search.getCenterPane());
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
        centerPan = new JPanel();
        
        
        //contentPane.add(centerPan);
        
        setLocationRelativeTo(null);
    }
    
    public void aCar(Producto producto){
        tienda.actualUser.aCarrito(producto);
            carr = new centerCarr(this, "", actionsPrev);
       
    }
    public void dCar(Producto producto){
        tienda.actualUser.dCarrito(producto);
        carr = new centerCarr(this, "", actionsPrev);
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

            btnSearch.addActionListener((ActionEvent e) -> {
                search(txtSearch.getText());
                actionsPrev.addAction("Search|"+txtSearch.getText());
                
            });

            JButton btnRegister = new JButton("");
            btnRegister.setIcon(createIcon("/Images/Register2.png"));
            btnRegister.setBounds(1069, 10, 74, 81);
            btnRegister.addActionListener((ActionEvent e) -> {
                if(tienda.actualUser.getUsername().equals("")){
                    Loggin login = new Loggin(this, true);
                    login.setVisible(true);
                }
                if(!tienda.actualUser.getUsername().equals("")){
                    boolean ha=cuentaP.getCenterPane().isVisible();
                    carr.getCenterPane().setVisible(false);
                    product.getCenterPane().setVisible(false);
                    search.getCenterPane().setVisible(false);
                    cuenta.getCenterPane().setVisible(false); 
                    
                    search = new centerSearch(this, txtSearch.getText(),actionsPrev);
                    
                    
                    if(!ha){
                        cuentaP = new centerSearch(this, "this", actionsPrev);
                        cuentaP.getCenterPane().setVisible(true);
                        contentPane.add(cuentaP.getCenterPane());
                    }

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
                if(tienda.actualUser.getCarrito().getCarrito().isEmpty()){
                    cart();
                    actionsPrev.addAction("Car|");
                }
                
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
            break;
            case "Search":
                search(subActions[1]);
                hey ="";
                System.out.println("saliendocenter");
                for (int i= 2; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                search.Actions(hey);
                
                
            case "Center":
                hey ="";
                System.out.println("saliendocenter");
                for (int i = 1; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                System.out.println(hey);
                if(carr!=null){
                    if(carr.getCenterPane().isVisible()){
                        carr.Actions(hey);
                    }
                }
                if(cuentaP.centerPane.isVisible()){
                    cuentaP.Actions(hey);
                }
                if(product.centerPane.isVisible()){
                    product.Actions(hey);
                }
                if(search.centerPane.isVisible()){
                    search.Actions(hey);
                }
                if(cuenta.centerPane.isVisible()){
                    cuenta.Actions(hey);
                }
                    
            break;
            case "Car":
                cart();
            break;
            
        }
        
    }

    private void ShowCar() {
        for (int i = 0; i < 10; i++) {
            System.out.println(tienda.prod.get(i).getId());
        }
        
    }

    
    public void cart(){
        boolean ha=cuentaP.getCenterPane().isVisible();
        cuentaP.getCenterPane().setVisible(false);
        product.getCenterPane().setVisible(false);
        search.getCenterPane().setVisible(false);
        cuenta.getCenterPane().setVisible(false); 

        search = new centerSearch(this, txtSearch.getText(),actionsPrev);


        if(!ha){
            carr = new centerCarr(this, "this", actionsPrev);
            carr.getCenterPane().setVisible(true);
            contentPane.add(carr.getCenterPane());
        }

        contentPane.validate();
    }
    
    public void search(String busqueda){
        boolean ha=search.getCenterPane().isVisible();
        if(carr!=null){
            carr.getCenterPane().setVisible(false);
        }
        product.getCenterPane().setVisible(false);
        cuentaP.getCenterPane().setVisible(false);
        cuenta.getCenterPane().setVisible(false); 

        if(!ha&&!search.orden.equals(busqueda)){
            search = new centerSearch(this, busqueda,actionsPrev);
            search.getCenterPane().setVisible(true);
            contentPane.add(search.getCenterPane());
        }else if(!ha&&search.orden.equals(busqueda)){
            search.getCenterPane().setVisible(true);
            contentPane.add(search.getCenterPane());
        }else if(ha&&!search.orden.equals(busqueda)){
            search.getCenterPane().setVisible(false);
            search = new centerSearch(this, busqueda,actionsPrev);
            search.getCenterPane().setVisible(true);
            contentPane.add(search.getCenterPane());
        }

        contentPane.validate();
    }
    
}
