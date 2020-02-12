/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import tienda_virtual.Producto;
import tienda_virtual.Tienda;
import tienda_virtual.Usuario;

/**
 *
 * @author fanat
 */
public class ProductoVisual extends JPanel {
    private JPanel extra;
    private Producto producto;
    private Usuario user;
    private Tienda tienda;
    
    public ProductoVisual(Producto producto,Usuario Actualuser,Tienda tienda){
        this.producto = producto;
        user = Actualuser;
       this.tienda = tienda;
        generate();
    }
    
    private void generate(){
        setLayout(null);
        setBounds(0, 0, 1265, 538);
        setBackground(Color.decode("#000000"));
        extra = new JPanel();
        extra.setLayout(null);
        extra.setBounds(0, 0, 1265, 538);
        extra.setBackground(Color.decode("#424242"));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 1265, 538);
        scrollPane_1.setBackground(Color.decode("#424242"));
        
        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(Color.red);
        JPanel fondo2 = new JPanel();
        fondo2.setLayout(new BoxLayout(fondo2, BoxLayout.Y_AXIS));
            JLabel Nombre = new JLabel(producto.getNombre());
            Nombre.setFont(Principal.createFont(Nombre, 20));
        fondo2.add(Nombre);
        String sd = producto.getDesc();
        JTextArea desc =new JTextArea();
        desc.append(sd);
        desc.setEditable(false);
        //desc.setBounds(10,50,400,300);
        fondo2.add(desc);
        
        JButton Seller = new JButton(producto.getSeller());
        
        
        if(producto.getSeller().equals(user.username)){
            Seller.setEnabled(false);
        }
        
        Seller.addActionListener((e) -> {
            extra.setVisible(false);
            extra = new UsuarioVisual(tienda.User(producto) , tienda);
            extra.setVisible(true);
            add(extra);
        });
        
        
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
            JLabel vend = new JLabel("Vendedor: ");
            vend.setFont(Principal.createFont(vend, 10));
        bottom.add(vend);
        bottom.add(Seller);
            JLabel precio = new JLabel("Precio: "+(int)producto.getValor()+"");
            precio.setFont(Principal.createFont(precio, 10));
            
        bottom.add(Box.createRigidArea(new Dimension(500,20)));
        
            JPanel fdas = new JPanel();
            
            JButton carro = new JButton("Añadir al carro");
            JButton eliCarro = new JButton("Eliminar del carro");
            
            if(user.getCarrito().exists(producto.getId())){
                fdas.add(eliCarro);
                System.out.println("existe");
            }else {
                fdas.add(carro);
                    carro.setEnabled(!(producto.getSeller().equals(user.getUsername()) || user.producAdquire.exist(producto.getId()))); 
            }
            
            carro.addActionListener((e) -> {
               if(user.getCarrito().exists(producto.getId())){
                   System.out.println("why? why???");
               }else{
                    user.aCarrito(producto);
               }
               
                carro.setVisible(false);
                eliCarro.setVisible(true);
                fdas.add(eliCarro);
                fdas.validate();
                user.getCarrito().getCarrito().imprime();
                
            });

            eliCarro.addActionListener((e) -> {
                user.getCarrito().sacar(producto.getId());
                eliCarro.setVisible(false);
                carro.setVisible(true);
                fdas.add(carro);
                fdas.validate();
            });
        bottom.add(fdas);
        bottom.add(precio);
        
        fondo2.add(bottom);
        
        fondo2.add(Box.createRigidArea(new Dimension(1200, 200)));
        
        
        
        
        fondo.add(fondo2);
        scrollPane_1.setViewportView(fondo);
        extra.add(scrollPane_1);

        add(extra);
    }
    
}
