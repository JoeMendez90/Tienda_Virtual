
package Tienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;

/**
 *
 * @author fanat
 */
public class centerSearch extends CenterPane{
    private DinamicArray<Producto> search;
    private JTabbedPane tabsearch;
    private JPanel center;
    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane_2;
    private JComboBox<String> box1;
    private JComboBox<String> box2;
    private int div;
    private int save;
    
    
    public centerSearch(Principal principal, String orden) {
        super(principal, orden,"Busqueda nueva");
    }

    @Override
    protected void createButton() {
        centerPane.setLayout(null);
        tabsearch = new JTabbedPane();
        tabsearch.setBounds(10, 10, centerPane.getWidth()-10, centerPane.getHeight()-10);
        tabsearch.add("productos",createProd());
        center= new JPanel();
        center.setBounds(0,0, 1265, 538);
        this.center.setBackground(Color.decode("#424242"));
        this.center.setLayout(null);
        center.add(tabsearch);
        centerPane.add(center);
    }

    public JPanel createProd(){
        JPanel center = new JPanel();
        center.setBackground(Color.decode("#414141"));
        center.setBounds(0, 0, centerPane.getWidth()-20, centerPane.getHeight()-20);
        center.setLayout(null);
        search = principal.tienda.BuscarProd(orden);
            div=search.tam/50;
            
            if(search.tam % 50 ==0 && div >0){
                div-=1;
            }
            
        
            String[] numbers = new String[div+1];
            for (int i = 1; i < div+2; i++) {
                numbers[i-1]=i+"";
            }
            save=-1;
            box1 = new JComboBox<>(numbers);
            box1.setBounds(100, 5, 60, 27);
            scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(100, 50, 1000, 450);
            scrollPane_1.setBackground(Color.decode("#424242"));

            JLabel busqueda = new JLabel("Search: ");
            busqueda.setBounds(200, 0, 200,50);
            busqueda.setForeground(Color.white);
            busqueda.setFont(Principal.createFont(busqueda, 20));
            JLabel busqueda2 = new JLabel(orden);
            busqueda2.setBounds(320, 0, 500,50);
            busqueda2.setForeground(Color.white);
            busqueda2.setFont(Principal.createFont(busqueda2, 20));

            center.add(busqueda);
            center.add(busqueda2);
            
            int tamano = search.tam;
            int digitos = 0;
            while(tamano>=1){
                digitos++;
                tamano= tamano/10;
            }
            
            int Rx, Tx;
            if(digitos <1){
                Rx = 750 + (15*(9-1));
                Tx = 940 + (15*(9-1));
            }else{
                Rx = 750 + (15*(9-digitos));
                Tx = 940 + (15*(9-digitos));
            }
            
            // 9 940 750
            
            JLabel resultados = new JLabel("Resultados: ");
            resultados.setBounds(Rx, 0, 200,50);
            resultados.setForeground(Color.white);
            resultados.setFont(Principal.createFont(resultados, 20));
            JLabel resultados2 = new JLabel(search.tam+"");
            resultados2.setBounds(Tx, 0, 700,50);
            resultados2.setForeground(Color.white);
            resultados2.setFont(Principal.createFont(resultados2, 20));
            center.add(resultados);
            center.add(resultados2);

            box1.setSelectedIndex(0);
            box1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(save!=box1.getSelectedIndex()){
                        StackAction("set|"+box1.getSelectedIndex());
                    }
                }
            });

            center.add(box1);

            center.add(scrollPane_1);

            scrollPane_1.setViewportView(createListSet());
            
        return center;
    }


    @Override
    public void Actions(String set) {
        String[] subAction = set.split(Pattern.quote("|"));
        
        switch(subAction[0]){
            case "set":
                    System.out.println("acction");
                    save=Integer.valueOf(subAction[1]);
                    if(box1.getSelectedIndex()!=save){
                        box1.setSelectedIndex(Integer.valueOf(subAction[1]));
                    }
                    
                    scrollPane_1.setViewportView(createListSet());
            break;
            case "select":
                
            break;
            case "Search":
                orden = subAction[1];
                Reset();
            break;
            
        }
    }
    
    public DinamicArray<Producto> search2(){
        DinamicArray<Producto> search2 = new DinamicArray<>();
        if(box1.getSelectedIndex()==div){
            for (int i = box1.getSelectedIndex()*50; i < search.tam; i++) {
                search2.addBack(search.get(i));
            }
        }else{
            for (int i = box1.getSelectedIndex()*50; i < box1.getSelectedIndex()*50+50; i++) {
                search2.addBack(search.get(i));
            }
        }
        return search2;
    }
    
    public JPanel createList(DinamicArray<Producto> serch){
        JPanel busqueda = new JPanel(new BorderLayout());
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setBackground(Color.decode("#525252"));
        list.setBorder(new EmptyBorder(0, 0, 0, 0));
        JLabel date = new JLabel("         Nombre     ");
        JLabel date2 = new JLabel("       Precio");
        date.setFont(Principal.createFont(date, 20));
        date2.setFont(Principal.createFont(date2, 20));
        for (int i = 0; i < serch.tam; i++) {
             list.add(createProduct(serch.get(i)));
        }
        JPanel busqueda2 = new JPanel();
        busqueda2.setLayout(new BoxLayout(busqueda2, BoxLayout.X_AXIS));
        busqueda2.add(date);
        busqueda2.add(Box.createRigidArea(new Dimension(500, 50)));
        busqueda2.add(date2);
        busqueda2.add(Box.createRigidArea(new Dimension(10, 50)));
        busqueda.add(busqueda2,BorderLayout.NORTH);
        busqueda.add(list,BorderLayout.CENTER);
           
        
        return busqueda;
    }
    
    
    public JPanel createListSet(){
        DinamicArray<Producto> serch = search2();
        return createList(serch);
    }
    
    
    public JPanel createProduct(Producto producto){
        String nombre = producto.getNombre();
        String Seller = producto.getSeller();
        String Valor = "$"+(int)producto.getValor()+"";
        
        
        
        int extra = 50 - Valor.length() - Seller.length()/3;
        
        if(extra < nombre.length() && extra > 10){
            nombre = nombre.substring(0, extra/2-2);
            nombre = nombre +"..";
            
        }
        extra = extra - nombre.length();
        
        JLabel label1 = new JLabel(nombre);
        label1.setFont(Principal.createFont(label1, 20));
        JLabel label2 = new JLabel(Seller);

        JLabel label3 = new JLabel(Valor);
        label3.setFont(Principal.createFont(label3, 20));
        JPanel label = new JPanel();
        label.setLayout(new BoxLayout(label, BoxLayout.X_AXIS));
        label.setBounds(0,0,250,250);
        label.add(label1);
        label.add(label2);
        label.add(Box.createRigidArea(new Dimension(extra*15, 50)));
        label.add(label3);
        
        JButton Prod = new JButton();
        Prod.add(label);
        Prod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.setVisible(false);
                center = new ProductoVisual(producto,principal.tienda.actualUser,principal.tienda);
                center.setVisible(true);
                centerPane.add(center);
                centerPane.validate();
                System.out.println("probando");
                productoB = true;
                StackAction("select|"+producto.getId());
            }
            
        });
        
        JPanel prod2 = new JPanel();
        prod2.setBackground(Color.red);
        prod2.setBorder(new EmptyBorder(0, 0, 0, 0));
        prod2.add(Prod);
        return prod2;
    }

       
}
