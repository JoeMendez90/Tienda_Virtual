/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author fanat
 */
public class GarageVisual extends JPanel{
    
    
    
    public GarageVisual(){
        generateGarage();
        
    }
    
    private void generateGarage(){
        setLayout(new BorderLayout());
        setBounds(0, 0, 1000, 500);
        setBackground(Color.red);
            JPanel Garage2 = new JPanel();
            Garage2.setLayout(new BoxLayout(Garage2, BoxLayout.X_AXIS));
                JPanel Visual  = new JPanel();
                Visual.setLayout(new BoxLayout(Visual, BoxLayout.Y_AXIS));
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(20, 20, 1000, 500);
                    scrollPane_1.setBackground(Color.decode("#424242"));
                    JPanel fondo = new JPanel();
                    fondo.setBackground(Color.green);
                    JPanel fondo2 = new JPanel();
                    fondo2.setLayout(new BoxLayout(Visual, BoxLayout.X_AXIS));
                    JButton fondo3 = new JButton("hey");
                    scrollPane_1.setViewportView(fondo3);
                Visual.add(scrollPane_1);
                Visual.add(fondo);
            Garage2.add(Visual);
        add(Garage2,BorderLayout.CENTER);
            JPanel Top = new JPanel(new BorderLayout());
            Top.setBorder(new EmptyBorder(0, 200,0, 30));
                JLabel text = new JLabel(/*"      Carros guardados: "+ principal.tienda.actualUser.getGarage().tam*/);
                text.setFont(Principal.createFont(text,20));
            Top.add(text, BorderLayout.CENTER);
        add(Top,BorderLayout.NORTH);
            JPanel Buttons = new JPanel();
            Buttons.setSize(1000, 100);
            Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
                //Button
    }
    
    
}
