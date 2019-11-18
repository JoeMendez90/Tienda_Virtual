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
    private CenterPane central;
    private JTextField txtSearch;

    public Tienda tienda;
    public ReturnAction actionsPrev;
    public int cant=100;
    
    public Principal(Tienda tienda, int CantPrub) {
        this.CantPrub= CantPrub;
        this.tienda=tienda;	
        actionsPrev= new ReturnAction();
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
        
        central = new centerSearch(tienda, "",actionsPrev);
        centerPan=central.getCenterPane();
        contentPane.add(centerPan);
        
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
                central = new centerSearch(tienda, txtSearch.getText(), actionsPrev);
                actionsPrev.addAction("Search|"+txtSearch.getText());
                
            });

            JButton btnRegister = new JButton("");
            btnRegister.setIcon(createIcon("/Images/Register2.png"));
            btnRegister.setBounds(1069, 10, 74, 81);
            btnRegister.addActionListener((ActionEvent e) -> {
                Loggin login = new Loggin(this, true);
                login.setVisible(true);
                if(!tienda.actualUser.getUsername().equals("")){
                    //central = centerUser();
                    System.out.println(tienda.actualUser.getUsername());
                }
            });

            up.add(btnRegister);                                                     

            JButton btnCrt = new JButton("");
            btnCrt.setIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setSelectedIcon(createIcon("/Images/carrito2.png"));
            btnCrt.setBounds(1153, 10, 74, 81);
            up.add(btnCrt);

            btnCrt.addActionListener((ActionEvent e) -> {
                central = new centerSearch(tienda, "",actionsPrev);
                centerPan=central.getCenterPane();
                ShowCar();
            });
        contentPane.add(up);
        
    }
    
    
    public static ImageIcon createIcon(String icon, int x,int y){
        return new ImageIcon(new ImageIcon(Principal.class.getResource(icon)).getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
    }
    
    public static ImageIcon createIcon(String icon){
        return new ImageIcon(Principal.class.getResource(icon));
    }
    
    private static Font createFont(Component component,int as){
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
                central = new centerSearch(tienda, subActions[1], actionsPrev);
                hey ="";
                for (int i = 2; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                if(subActions.length>2){
                    central.Actions(hey);
                }
            case "Center":
                hey ="";
                System.out.println("saliendocenter");
                for (int i = 1; i < subActions.length; i++) {
                     hey= hey+subActions[i]+"|";
                }
                System.out.println(hey);
                central.Actions(hey);
            break;
            
                
            
        }
        
    }

    private void ShowCar() {
        for (int i = 0; i < 10; i++) {
            System.out.println(tienda.prod.get(i).getId());
        }
        
    }

    

    
}
