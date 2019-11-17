/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public class GeneralWindow extends JFrame{
    
    private JSplitPane principalPane;
    private JPanel toolbar;
    public JPanel pane;
    private Tienda shop;
    

    public GeneralWindow(Tienda tienda) {
        shop = tienda;
        start();
        
    }
    
    private void start(){
        setIconImage(new ImageIcon("src/Images/Isotipo.png").getImage());
        setSize(1000, 600);
        setTitle(shop.TiendName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        
        // toolbar create;
        toolbar = new JPanel();
        toolbar.setLayout(null);
        toolbar.setBackground(Color.decode("#494E6B"));
        toolbar.setForeground(Color.BLACK);
        toolbar.setBounds(50, 10, (int) getSize().getWidth(), 100);
        toolbar.add(new JTextArea("helloWorld"),BorderLayout.CENTER);

            ImageIcon imagotipo = new ImageIcon(new ImageIcon("src/Images/Imagotipo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));   // Imagotipo
            JButton IniButton = new JButton(imagotipo);
            IniButton.setBounds(0,0,100,100);
            IniButton.setBackground(Color.decode("#494E6B"));
            toolbar.add(IniButton);
            
        
            JPanel searchPane = new JPanel();
            searchPane.setLayout(null);
            searchPane.setBounds(150,0,(int) getSize().getWidth()-500,100);
            searchPane.setBackground(Color.red);
                JTextField txtSearch = new JTextField("Search");
                txtSearch.setBounds(50, 25, (int) getSize().getWidth()-650, 50);
                //txtSearch.setColumns(20);
                txtSearch.setBackground(Color.decode("#161720"));
                txtSearch.setForeground(Color.WHITE);
                Font font = new Font(txtSearch.getFont().getFontName(), txtSearch.getFont().getStyle(), txtSearch.getFont().getSize()+20);
                txtSearch.setFont(font);
                searchPane.add(txtSearch);
                
                ImageIcon searchIcon = new ImageIcon("src/Images/Search.png");   // Imagotipo
                JButton searchButton = new JButton(searchIcon);
                searchButton.setBounds(txtSearch.getSize().width+50,25,50,50);
                searchButton.setBackground(Color.LIGHT_GRAY);
                searchPane.add(searchButton);
                
            toolbar.add(searchPane);
            
            
            
        
        principalPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        
        //principalPane.setLayout(null);

        principalPane.setDividerLocation(100);
        principalPane.setEnabled( false );    
        principalPane.add(toolbar);

        
        

        pane = new JPanel();
        
        //pane.setSize(principalPane.getSize());        
        
        //setContentPane(new JScrollPane(Jpane));
        pane.setBackground(Color.decode("#192231"));
        
        principalPane.add(pane);
        for(int i= 0; i<20;i++){
             pane.add(new JLabel("asd"+i),BorderLayout.SOUTH);
        }
            
        
		
        
        
        
        
        //principalPane.add(pane,BorderLayout.CENTER);
        setContentPane(new JScrollPane(principalPane));
    }
    
    private void initUI() {

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        ImageIcon exitIcon = new ImageIcon("src/Images/Captura.png");
        JButton exitBtn = new JButton(exitIcon);
        exitBtn.setBorder(new EmptyBorder(1, 1, 1, 1));
        toolbar.add(exitBtn);

        add(toolbar, BorderLayout.NORTH);

        JToolBar vertical = new JToolBar(JToolBar.VERTICAL);
        vertical.setFloatable(false);
        vertical.setMargin(new Insets(10, 5, 5, 5));

        ImageIcon driveIcon = new ImageIcon("src/Images/Captura.png");
        ImageIcon compIcon = new ImageIcon("src/Images/Captura2.png");
        ImageIcon printIcon = new ImageIcon("src/Images/Logout.png");

        JButton driveBtn = new JButton(driveIcon);
        driveBtn.setBorder(new EmptyBorder(3, 0, 3, 0));

        JButton compBtn = new JButton(compIcon);
        compBtn.setBorder(new EmptyBorder(3, 0, 3, 0));
        JButton printBtn = new JButton(printIcon);
        printBtn.setBorder(new EmptyBorder(3, 0, 3, 0));

        vertical.add(driveBtn);
        vertical.add(compBtn);
        vertical.add(printBtn);

        add(vertical, BorderLayout.WEST);

        add(new JTextArea(), BorderLayout.CENTER);

        JLabel statusbar = new JLabel(" Statusbar");
        add(statusbar, BorderLayout.SOUTH);
        setTitle("BorderLayout");
    }
    
    private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

    private void createWindow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
         


}
