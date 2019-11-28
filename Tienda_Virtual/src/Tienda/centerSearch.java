
package Tienda;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public class centerSearch extends CenterPane{
    private DinamicArray<Producto> search;
    private JScrollPane scrollPane_1;
    private JComboBox<String> box;
    private int div;
    private int save;
    
    
    public centerSearch(Principal principal, String orden, ReturnAction actionPrev) {
        super(principal, orden, actionPrev,"Busqueda nueva");
    }

    @Override
    protected void createButton() {
        centerPane.setLayout(null);
        search = principal.tienda.Buscar(orden);
        if(search.isEmpty()){
            Error();
        }else{
            div=search.tam/50;
        
            String[] numbers = new String[div+1];
            for (int i = 1; i < div+2; i++) {
                numbers[i-1]=i+"";
            }
            save=-1;
            box = new JComboBox<>(numbers);
            box.setBounds(1150, 120, 60, 27);
            scrollPane_1 = new JScrollPane();
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
                        StackAction("set|"+box.getSelectedIndex());
                    }
                }
            });
            box.setSelectedIndex(0);
            centerPane.add(box);

            centerPane.add(scrollPane_1);


            scrollPane_1.setViewportView(createListSet());
        }
    }

    @Override
    public void Actions(String set) {
        String[] subAction = set.split(Pattern.quote("|"));
        
        switch(subAction[0]){
            case "set":
                    System.out.println("acction");
                    save=Integer.valueOf(subAction[1]);
                    if(box.getSelectedIndex()!=save){
                        box.setSelectedIndex(Integer.valueOf(subAction[1]));
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
    
    public JPanel createListSet(){
        DinamicArray<Producto> serch = search2();
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
                        principal.tienda.actualUser.aCarrito(producto);
                    }else{
                        principal.tienda.actualUser.dCarrito(producto);
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

    private void Error() {
        JLabel error1 = new JLabel("Error Busqueda");
        JLabel error2 = new JLabel("No Encontrada");
        System.out.println("error");
        error1.setFont(Principal.createFont(error1, 100));
        error1.setBounds(50, 50, 1000, 150);
        error2.setFont(Principal.createFont(error2, 100));
        error2.setBounds(50, 150, 1000, 300);
        centerPane.add(error1);
        centerPane.add(error2);
    }
    
}
