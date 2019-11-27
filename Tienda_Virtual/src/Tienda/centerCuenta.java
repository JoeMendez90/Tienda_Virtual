/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import tienda_virtual.ReturnAction;
import tienda_virtual.Tienda;

/**
 *
 * @author fanat
 */
public class centerCuenta extends CenterPane{

    private JScrollPane Cuenta;
    private JScrollPane Productos;
    private JScrollPane Servicios;
    private JScrollPane Garage;
    private JScrollPane Archivo;
    private JScrollPane Contratos;
    
    
    public centerCuenta(Tienda tienda, String orden, ReturnAction actionPrev) {
        super(tienda, orden, actionPrev, "Cuenta Propia");
    }

    @Override
    protected void createButton() {
        JTabbedPane pestanas=new JTabbedPane();
        pestanas.setBounds(0, 0, 1265, 538);
        centerPane.add(pestanas);
        
        Cuenta= new JScrollPane();
        Cuenta.setBounds(0, 0, 1000, 500);
        Cuenta.setViewportView(Cuenta());
        
        Productos= new JScrollPane();
        Productos.setBounds(0, 0, 1000, 500);
        Productos.setViewportView(Productos());
        
        Servicios = new JScrollPane();
        Servicios.setBounds(0, 0, 1000, 500);
        Servicios.setViewportView(Servicios());
        
        Garage=new JScrollPane();
        Garage.setBounds(0, 0, 1000, 500);
        Garage.setViewportView(Garage());
        
        Archivo=new JScrollPane();
        Archivo.setBounds(0, 0, 1000, 500);
        Archivo.setViewportView(Archivo());
        
        Contratos=new JScrollPane();
        Contratos.setBounds(0, 0, 1000, 500);
        Contratos.setViewportView(Contratos());
        
    
        pestanas.addTab("Cuenta", Cuenta);
        pestanas.addTab("Productos", Productos);
        pestanas.addTab("Productos", Servicios);
        pestanas.addTab("Garage", Garage);
        pestanas.addTab("Archivo", Archivo);
        pestanas.addTab("Contratos", Contratos);
        centerPane.add(pestanas);
    }

    @Override
    public void Actions(String set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component Productos() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Productos");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Cuenta() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Cuenta");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Servicios() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Servicios");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Garage() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Garage");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Archivo() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Archivo");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }

    private Component Contratos() {
        JPanel Contrat = new  JPanel();
        JLabel text = new JLabel("No hay Contratos");
        text.setFont(Principal.createFont(text,100));
        Contrat.add(text);
        return Contrat;
    }
    
}
