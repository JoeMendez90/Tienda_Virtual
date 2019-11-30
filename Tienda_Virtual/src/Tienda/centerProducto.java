/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import tienda_virtual.ReturnAction;
import tienda_virtual.Stack;
import tienda_virtual.Tienda;
import tienda_virtual.Producto;
import tienda_virtual.DinamicArray;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author fanat
 */
public class centerProducto extends CenterPane{
    
    private Producto producto;

    public centerProducto(Principal principal, String orden,Producto producto) {
        super(principal, orden,"Muestra Producto");
        this.producto=producto;
    }

    @Override
    protected void createButton() {
        /*
        private void iniciar(DinamicArray<Producto> p){
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
       
        JScrollPane barra = new JScrollPane();
        this.getContentPane().add(barra);
        //panel.add(barra);
        barra.setBackground(Color.BLACK);
        //barra.add(panel);
        //this.getContentPane().add(barra);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        int j = 0;
        for (int i = 0; i<p.size(); i++){
            JLabel etiqueta = new JLabel(p.get(i).getNombre()+"\t"+ (p.get(i).getValor()+"")+ "\t" + p.get(i).getDesc()+ "\t" );
           
            etiqueta.setBounds(100,j,100,100);
            etiqueta.setForeground(Color.WHITE);
            //barra.add(etiqueta);
            panel.add(etiqueta);
            j+=20;*/
        
    }

    @Override
    public void Actions(String set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
