
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
public class centerCarr extends CenterPane{
    private DinamicArray<Producto> Carr;
    private JScrollPane scrollPane_1;
    private JComboBox<String> box;
    private int div;
    private int save;
    
    
    public centerCarr(Tienda tienda, String orden, ReturnAction actionPrev) {
        super(tienda, orden, actionPrev," VisualizarCarro ");
    }

    @Override
    protected void createButton() {
        Carr = tienda.actualUser.getCarrito().getCarrito();
        if(Carr.isEmpty()){
            
        }
        centerPane.setLayout(null);
        
        div=Carr.tam/50;
        
        String[] numbers = new String[div];
        for (int i = 1; i < div+2; i++) {
            numbers[i-1]=i+"";
        }
        save=-1;
        box = new JComboBox<>(numbers);
        box.setBounds(1150, 120, 60, 27);
        
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
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 20, 1000, 500);
        scrollPane_1.setBackground(Color.decode("#424242"));
        centerPane.add(scrollPane_1);
        
              
        scrollPane_1.setViewportView(createListSet());
    }

    @Override
    public void Actions(String set) {
        String[] subAction = set.split(Pattern.quote("|"));
        
        switch(subAction[0]){
            case "set":
                if(box.getSelectedIndex()!=Integer.valueOf(subAction[1])){
                    System.out.println("acction");
                    save=Integer.valueOf(subAction[1]);
                    box.setSelectedIndex(Integer.valueOf(subAction[1]));
                    scrollPane_1.setViewportView(createListSet());
                }
            break;
            case "select":
                
            break;
        }
    }
    
    public DinamicArray<Producto> search2(){
        DinamicArray<Producto> search2 = new DinamicArray<>();
        if(box.getSelectedIndex()==div){
            for (int i = box.getSelectedIndex()*50; i < Carr.tam; i++) {
                search2.addBack(Carr.get(i));
            }
        }else{
            for (int i = box.getSelectedIndex()*50; i < box.getSelectedIndex()*50+50; i++) {
                search2.addBack(Carr.get(i));
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
        
        JPanel prod2 = new JPanel();
        prod2.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        prod2.add(Prod);
        return prod2;
    }
    
}
