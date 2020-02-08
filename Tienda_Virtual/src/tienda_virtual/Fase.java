/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author Usuario
 */
public class Fase {
    int time;
    String nombre;
    
    public Fase(String n, int t){
        nombre = n;
        time = t;
    }
    public int getTime(){
        return time;
    }
    public String getNombre(){
        return nombre;
    }
}
