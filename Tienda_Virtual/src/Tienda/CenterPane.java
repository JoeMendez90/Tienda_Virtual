/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.Color;
import javax.swing.JPanel;
import static tienda_virtual.LectoUpdater.getTime;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public abstract class CenterPane {
    protected JPanel centerPane;
    protected Tienda tienda;
    protected String orden;
    protected ReturnAction actionPrev;

    public CenterPane(Tienda tienda, String orden,ReturnAction actionPrev,String action) {
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        this.tienda = tienda;
        this.orden = orden;
        this.actionPrev = actionPrev;
        System.out.println("ini");
        create();
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,action);
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
        actionPrev.addAction("Center|"+action);
        Actions(action);
    }
    public JPanel getCenterPane() {
        return centerPane;
    }
}
