
package Tienda;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

/**
 * el center cuenta es la ventana center donde se visualizara la cuenta del usuario actual, 
 * debe salir cuando se oprime el boton de usuario, y al loguearse o al estarlo debe mostrar un tabpane
 * este contendra 6 pestañas, cuenta, productos, servicios, garage, archivo, contratos.
 * cada uno llamado en una funcion especifica
 * @author Team
 */
public class centerCuenta extends CenterPane{
    
    
    public centerCuenta(Tienda tienda, String orden, ReturnAction actionPrev) {
        super(tienda, orden, actionPrev, "Cuenta Propia");
    }

    /**
     * crea las pestañas de la cuenta
     */
    
    @Override
    protected void createButton() {
        JTabbedPane pestanas=new JTabbedPane();
        pestanas.setBounds(0, 0, 1265, 538);
        centerPane.add(pestanas);
    
        pestanas.addTab("Cuenta", Cuenta());
        pestanas.addTab("Productos", Productos());
        pestanas.addTab("Productos", Servicios());
        pestanas.addTab("Garage", Garage());
        pestanas.addTab("Archivo", Archivo());
        pestanas.addTab("Contratos", Contratos());
        centerPane.add(pestanas);
    }
    
    /**
     * acciones ah realizar por la cuenta
     * @param set accion a realizar
     */

    @Override
    public void Actions(String set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * pestaña de productos
     * @return la pestaña de los productos enlistando los que posee el usuario
     */

    private Component Productos() {
        JPanel Productos = new  JPanel();
        Productos.setBounds(0, 0, 1000, 500);
        DinamicArray<Producto> search = tienda.actualsProducts();
        if(search.isEmpty()){
            return Error("Productos");
        }
        
        int div=search.tam/50; 
        
        String[] numbers = new String[div+1];
        for (int i = 1; i < div+2; i++) {
            numbers[i-1]=i+"";
        }
        int save=-1;
        JComboBox box = new JComboBox<>(numbers);
        box.setBounds(1150, 120, 60, 27);
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 20, 1000, 500);
        scrollPane_1.setBackground(Color.decode("#424242"));

        JLabel busqueda = new JLabel("Search: ");
        busqueda.setBounds(1050, 200, 200,50);
        busqueda.setForeground(Color.white);
        busqueda.setFont(Principal.createFont(busqueda, 20));
        JLabel busqueda2 = new JLabel(orden);
        busqueda2.setBounds(1050, 300, 200,50);
        busqueda2.setForeground(Color.white);
        busqueda2.setFont(Principal.createFont(busqueda2, 20));

        centerPane.add(busqueda);
        centerPane.add(busqueda2);


        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(save!=box.getSelectedIndex()){
                    //StackAction("set|"+box.getSelectedIndex());
                }
            }
        });
        box.setSelectedIndex(0);
        return Productos;
    }
        
    public DinamicArray<Producto> search2(JComboBox box, int div, DinamicArray<Producto> search){
        DinamicArray<Producto> search2 = new DinamicArray<>();
        if(box.getSelectedIndex()==div){
            for (int i = box.getSelectedIndex()*50; i < search.tam; i++) {
                search2.addBack(search.get(i));
            }
        }else{
            for (int i = box.getSelectedIndex()*50; i < box.getSelectedIndex()*50+50; i++) {
                search2.addBack(search.get(i));
            }
        }
        return search2;
    }
    
    public JPanel createList(DinamicArray<Producto> serch){
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.X_AXIS));
        list.setBackground(Color.decode("#424242"));
        
        if(serch.tam%2==0){
            for (int i = 0; i < serch.tam; i+=2) {
                list.add(createDoubleProd(serch.get(i),serch.get(i+1)));
            }
        }else{
            for (int i = 0; i < serch.tam-1; i+=2) {
                list.add(createDoubleProd(serch.get(i),serch.get(i+1)));
            }
            list.add(createProd(serch.get(serch.tam-1)));
        }
        
        return list;
    }

    public JPanel createDoubleProd(Producto producto, Producto producto2){
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.setBounds(0, 0, 250, 500);
        pan.add(createProduct(producto));
        pan.add(createProduct(producto2));
        return pan;
    }
    
    public JPanel createProd(Producto producto2){
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.setBounds(0, 0, 250, 500);
        pan.add(createProduct(producto2));
        pan.add(Box.createRigidArea(new Dimension(250, 250)));
        return pan;
    }
    
    public JPanel createListSet(JComboBox box, int div, DinamicArray<Producto> search){
        DinamicArray<Producto> serch = search2(box,div,search);
        return createList(serch);
    }
    
    
    public JPanel createProduct(Producto producto){
        JLabel label1 = new JLabel(producto.getNombre());
        JLabel label2 = new JLabel(producto.getSeller());
        JLabel label3 = new JLabel(producto.getValor()+"");
        JPanel label = new JPanel();
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.setBounds(0,0,250,250);
        label.add(label1);
        label.add(label2);
        label.add(label3);
        
        JButton Prod = new JButton();
        Prod.add(label);
        Prod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StackAction("select|"+producto.getId());
            }
            
        });
        
        JCheckBox Prod3 = new JCheckBox("to Car");
        Prod3.setBounds(0,0,100,50);
        /*DinamicArray<Producto> car = tienda.tienda.actualUser.getCarrito().getCarrito().DisplayList();
        System.out.println(producto.getNombre());
        for (int i = 0; i < car.tam; i++) {
            System.out.print(car.get(i).getNombre()+" | ");
        }
        System.out.println(car.exist(producto));
        if(car.exist(producto)){
            
            Prod3.setSelected(true);
        }*/
        Prod3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(e.equals(Prod3)){
                    System.out.println(Prod3);
                    if(Prod3.isSelected()){
                        tienda.actualUser.aCarrito(producto);
                    }else{
                        tienda.actualUser.dCarrito(producto);
                    }
                }
            }
        });
        JPanel boxcheck = new JPanel();
        boxcheck.add(Prod3);
        
        JPanel prod2 = new JPanel();
        prod2.setLayout(new BoxLayout(prod2, BoxLayout.Y_AXIS));
        prod2.add(Prod);
        prod2.add(boxcheck);
        return prod2;
    }

    private Component Cuenta() {
        JPanel Cuenta1 = new  JPanel();
        Cuenta1.setForeground(Color.WHITE);
        Cuenta1.setBounds(0,0,1000,500);
        Cuenta1.setLayout(new BoxLayout(Cuenta1, BoxLayout.Y_AXIS));
        Cuenta1.setBackground(Color.red);
            JPanel first = new JPanel();
            first.setBackground(Color.red);
            first.setLayout(new BoxLayout(first, BoxLayout.X_AXIS));
                JLabel text = new JLabel(tienda.actualUser.getUsername());
                text.setFont(Principal.createFont(text,50));
                text.setForeground(Color.WHITE);
                JPanel image = new JPanel();
                image.setBackground(Color.decode("#616161"));
                image.setLayout(new BoxLayout(image, BoxLayout.Y_AXIS));
                    JLabel image1 = new JLabel("imagen no");
                    image1.setForeground(Color.WHITE);
                    image1.setFont(Principal.createFont(image,10));
                    JLabel image2 = new JLabel("disponible");
                    image2.setForeground(Color.WHITE);
                    image2.setFont(Principal.createFont(image,10));
                    image.add(image1);
                    image.add(image2);
            first.add(text);
            first.add(Box.createRigidArea(new Dimension(100, 100)));
            first.add(image);
            
            JTextArea second = new JTextArea(tienda.actualUser.getDesc(),100,50);
            second.setBackground(Color.decode("#616161"));
            second.setEditable(false);
            second.setFont(Principal.createFont(image,20));
            second.setForeground(Color.WHITE);
            
            JPanel Buttons = new JPanel();
            Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
                JButton edit = new JButton("editar Cuenta");
                edit.setSize(70,25);
                edit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("edit not list");
                    }
                });
            Buttons.add(edit);
                JButton delete = new JButton("eliminar Cuenta");
                delete.setSize(70,25);
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("delete not list");
                    }
                });
            Buttons.add(delete);
            
        Cuenta1.add(first);
        Cuenta1.add(second);
        Cuenta1.add(Buttons);
        return Cuenta1;
    }

    private Component Servicios() {
        JPanel Contrat = new  JPanel();
        Contrat.setBounds(0, 0, 1000, 500);
        JLabel text = new JLabel("No hay Servicios");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Garage() {
        JPanel Contrat = new  JPanel();
        Contrat.setBounds(0, 0, 1000, 500);
        JLabel text = new JLabel("No hay Garage");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Archivo() {
        JPanel Contrat = new  JPanel();
        Contrat.setBounds(0, 0, 1000, 500);
        JLabel text = new JLabel("No hay Archivo");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Contratos() {
        JPanel Contrat = new  JPanel();
        Contrat.setBounds(0, 0, 1000, 500);
        JLabel text = new JLabel("No hay Contratos");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }
    
    /**
     * regresa una ventana que dice que no hay lo que recibe
     * @param falla cosa que no se posee
     * @return ventana de error
     */
    
    private JPanel Error(String falla) {
        JPanel error = new JPanel();
        error.setLayout(null);
            JLabel error1 = new JLabel("No Posee "+falla);
            System.out.println("error");
            error1.setFont(Principal.createFont(error1, 50));
            error1.setBounds(50, 50, 800, 300);
        error.add(error1);
        return error;
    }
    
}
