/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import tienda_virtual.ReturnAction;
import tienda_virtual.Stack;
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

    public CenterPane(Tienda tienda, String orden,ReturnAction actionPrev) {
        this.centerPane = new JPanel();
        this.tienda = tienda;
        this.orden = orden;
        this.actionPrev = actionPrev;
        this.centerPane.setBackground(Color.BLUE);
        create();
    }
    
    private void create(){
        centerPane.setBounds(5, 110, 1265, 538);
        createButton();
    }
    
    protected abstract void createButton();
    
    public abstract void Actions(String set);
    
    protected void StackAction(String action){
        actionPrev.addAction("Center"+action);
        Actions(action);
    }
    public JPanel getCenterPane() {
        return centerPane;
    }
}
