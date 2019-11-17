/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import tienda_virtual.DinamicArray;
import tienda_virtual.Producto;
import tienda_virtual.ReturnAction;
import tienda_virtual.Stack;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public class centerSearch extends CenterPane{
    private DinamicArray<Producto> search;
    private DinamicArray<Producto> search2;
    private JComboBox<Integer> tamSlide;
    int prevTam;
    
    
    public centerSearch(Tienda tienda, String orden, ReturnAction actionPrev) {
        super(tienda, orden, actionPrev);
        createSearch();
    }

    private void createSearch(){
        centerPane.setLayout(null);
        search = tienda.Buscar(orden);
        Integer[] tams = new Integer[]{50,100,500};
        tamSlide = new JComboBox<>(tams);
        prevTam = tamSlide.getItemAt(0);
        tamSlide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(prevTam!=tamSlide.getItemAt(tamSlide.getSelectedIndex())){
                    String Action = "SetTam"+tamSlide.getSelectedIndex();
                    StackAction(Action);
                }
                
            }
        });
        centerPane.add(tamSlide);
        
    }

    @Override
    protected void createButton() {
        
        centerPane.setBackground(Color.red);
    }

    @Override
    public void Actions(String set) {
        switch(set){
            case "SetTam0":
                prevTam=tamSlide.getItemAt(0);
                System.out.println(prevTam);
            break;
            case "SetTam1":
                prevTam=tamSlide.getItemAt(1);
                System.out.println(prevTam);
            break;
            case "SetTam2":
                prevTam=tamSlide.getItemAt(2);
                System.out.println(prevTam);
            break;
        }
    }
    
}
