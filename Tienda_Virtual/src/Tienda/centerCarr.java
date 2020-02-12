
package Tienda;

import com.sun.scenario.effect.impl.state.RenderState;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;

/**
 *
 * @author fanat
 */
public class centerCarr extends CenterPane{
    private DinamicArray<Producto> Carr;
    private JScrollPane scrollPane_1;
    private int div;
    private int save;
    private JLabel precio;
    private int precio2;
    private JPanel extra;
    
    
    public centerCarr(Principal principal, String orden) {
        super(principal, orden," VisualizarCarro ");
    }

    @Override
    protected void createButton() {
        extra = new JPanel();
        extra = new JPanel();
        extra.setBounds(0, 0, 1265, 538);
        extra.setBackground(Color.decode("#424242"));
        extra.setLayout(null);
        Carr = principal.tienda.actualUser.getCarrito().getCarrito();
        centerPane.setLayout(null);
        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 20, 600, 400);
        scrollPane_1.setBackground(Color.decode("#424242"));
        
        extra.add(scrollPane_1);
        precio2 = 0;
        precio = new JLabel(precio2+"");
        JLabel total = new JLabel("Total:");
        total.setBounds(370,400,200,100);
        total.setForeground(Color.WHITE);
        total.setFont(Principal.createFont(total, 20));
        
        scrollPane_1.setViewportView(reload());
        
        
        precio.setBounds(460,400,200,100);
        precio.setForeground(Color.WHITE);
        precio.setFont(Principal.createFont(precio, 20));
        
        JButton comprar = new JButton("comprar");
        comprar.setBounds(700,100,100,50);
        
        JButton vaciar = new JButton("vaciar carro");
        vaciar.setBounds(700,300,100,50);
        if(Carr.isEmpty()){
            comprar.setEnabled(false);
            vaciar.setEnabled(false);
        }
        
        if(principal.tienda.actualUser.getUsername().length()<1){
            comprar.setEnabled(false);
        }
        
        comprar.addActionListener((e) -> {
            for(int i=0; i< Carr.tam;i++){
                principal.tienda.actualUser.producAdquire.addBack(Carr.get(i).getId());
                System.out.println(Carr.get(i).getNombre());
            }
            principal.tienda.actualUser.getCarrito().vaciar();
            scrollPane_1.setViewportView(reload());
            scrollPane_1.validate();
        });
        
        vaciar.addActionListener((e) -> {
            principal.tienda.actualUser.getCarrito().vaciar();
            scrollPane_1.setViewportView(reload());
            scrollPane_1.validate();
        });
        
        extra.add(comprar);
        extra.add(vaciar);
        
        extra.add(total);
        extra.add(precio);
        
        
        centerPane.add(extra);
        //scrollPane_1.setViewportView(/*createListSet()*/);
        
        
    }
    
    public JPanel reload(){
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        precio2=0;
        for (int i = 0; i < principal.tienda.actualUser.getCarrito().getCarrito().tam; i++) {
            JPanel prod = new JPanel();
            prod.setLayout(new BoxLayout(prod, BoxLayout.X_AXIS));
            
            
            precio2+=principal.tienda.actualUser.getCarrito().getCarrito().get(i).getValor();
            
            /*prod.add(nombre);
            prod.add(Box.createRigidArea(new Dimension(200, )))
            */
            JButton produ = new JButton();
            
            Producto proer = principal.tienda.actualUser.getCarrito().getCarrito().get(i);
            
            String Mane = proer.getNombre();
            
            String valor = "$"+(int)principal.tienda.actualUser.getCarrito().getCarrito().get(i).getValor();
            
            int set = 30 - valor.length();
            
            if(set-5<Mane.length()){
                Mane = Mane.substring(0, set-5)+"..";
            }
            
            set = set - Mane.length();
            
            JLabel nombre = new JLabel(Mane);
             nombre.setFont(Principal.createFont(nombre, 20));
            
            String hey = "";
            
            for (int j = 0; j < set; j++) {
                hey+="     ";
            }
            
            JLabel procio = new JLabel(valor);
            procio.setFont(Principal.createFont(procio, 20));
            
            JPanel pordu = new JPanel();
            pordu.setLayout(new BoxLayout(pordu, BoxLayout.X_AXIS));
            
            JLabel heyy = new JLabel(hey);
            //heyy.setFont(Principal.createFont(heyy, 20));
            
            pordu.add(nombre);
            pordu.add(heyy);
            pordu.add(procio);
            
            
            produ.add(pordu);
            produ.addActionListener((e) -> {
                extra.setVisible(false);
                extra =  new ProductoVisual(proer, principal.tienda.actualUser, principal.tienda);
                extra.setVisible(true);
                centerPane.add(extra);
                productoB = true;
            });
            
            JButton elimi = new JButton("X");
            
            elimi.setFont(Principal.createFont(elimi, 20));
            String id = principal.tienda.actualUser.getCarrito().getCarrito().get(i).getId();
            elimi.addActionListener((e) -> {
                principal.tienda.actualUser.getCarrito().sacar(id);
                scrollPane_1.setViewportView(reload());
                scrollPane_1.validate();
            });
                    
            
            prod.add(produ);
            prod.add(elimi);
            
            list.add(prod);
        }
        
        precio.setText("$"+precio2);
        
        return list;
    }
    
    @Override
    public void Actions(String set) {
        /*String[] subAction = set.split(Pattern.quote("|"));
        
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
        }*/
    }
    
    /*public DinamicArray<Producto> search2(){
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
    */
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
    
    /*public JPanel createListSet(){
        DinamicArray<Producto> serch = search2();
        return createList(serch);
    }*/
    
    
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
