/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.Color;
import javax.swing.JPanel;
import tienda_virtual.LectoUpdater;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public abstract class CenterPane {
    protected JPanel centerPane;
    protected Principal principal;
    protected String orden;
    public boolean productoB;

    public CenterPane(Principal principal, String orden, String action) {
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        this.principal = principal;
        this.orden = orden;
        System.out.println("ini");
        create();
        TFin = System.currentTimeMillis();
        LectoUpdater.getTime(TFin - TInicio,action);
    }
    
    private void create(){
        this.centerPane = new JPanel();
        centerPane.setBounds(5, 110, 1265, 538);
        this.centerPane.setBackground(Color.decode("#424242"));
        this.centerPane.setLayout(null);
        createButton();
    }
    
    protected abstract void createButton();
    
    public abstract void Actions(String set);
    
    protected void StackAction(String action){
        principal.actionsPrev.addAction("Center|"+action);
        Actions(action);
    }
    public JPanel getCenterPane() {
        return centerPane;
    }
    
    protected void Reset(){
        this.centerPane = new JPanel();
        centerPane.setBounds(5, 110, 1265, 538);
        this.centerPane.setBackground(Color.decode("#424242"));
        this.centerPane.setLayout(null);
        createButton();
    }
}
