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
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.Tienda;
import tienda_virtual.Usuario;

/**
 *
 * @author fanat
 */
public class UsuarioVisual extends JPanel {
    private JPanel extra;
    private DinamicArray<Producto> productos;
    private Usuario user;
    private Tienda tienda;
    
    public UsuarioVisual(Usuario usuario, Tienda tienda){
        productos = new DinamicArray<>();
        for (int i=0;i<usuario.productos.tam;i++) {
            productos.addBack(tienda.BuscarId(usuario.productos.get(i)));
        }
        this.tienda = tienda;
        user = usuario;
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
            JLabel Nombre = new JLabel(user.getUsername());
            Nombre.setFont(Principal.createFont(Nombre, 20));
        fondo2.add(Nombre);
        String sd = user.getDesc();
        JTextArea desc =new JTextArea();
        desc.append(sd);
        desc.setEditable(false);
        //desc.setBounds(10,50,400,300);
        fondo2.add(desc);
        
        for(int i=0;i<productos.tam;i++){
            Producto prod = productos.get(i);
            JButton producto = new JButton();
                JPanel sa = new JPanel();
                sa.setLayout(new BoxLayout(sa, BoxLayout.X_AXIS));
                    JLabel nombre = new JLabel(prod.getNombre());
                    nombre.setFont(Principal.createFont(nombre, 20));
                    JLabel valor = new JLabel("$"+prod.getValor());
                    valor.setFont(Principal.createFont(valor, 20));
                sa.add(nombre);
                sa.add(Box.createRigidArea(new Dimension(500,20)));
                sa.add(valor);
            producto.add(sa);
            producto.addActionListener((e) -> {
                extra.setVisible(false);
                extra= new ProductoVisual(prod, tienda.actualUser, tienda);
                extra.setVisible(true);
                add(extra);
            });
            fondo2.add(producto);
        }
        
        
        
        
        fondo2.add(Box.createRigidArea(new Dimension(1200, 200)));
        
        
        
        
        fondo.add(fondo2);
        scrollPane_1.setViewportView(fondo);
        extra.add(scrollPane_1);

        add(extra);
    }
    
}
