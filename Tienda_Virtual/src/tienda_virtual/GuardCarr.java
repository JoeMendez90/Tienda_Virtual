/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *  esta clase contiene un carro y su nombre de busqueda, para generar mas calma a
 * la hora de interactuar con el usuario
 * @author Team
 */
public class GuardCarr {
    private Carrito carr;
    private String string;

    public GuardCarr(Carrito carr, String string) {
        this.carr = carr;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public Carrito getCarr() {
        return carr;
    }

    public void setCarr(Carrito carr) {
        this.carr = carr;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    
}
