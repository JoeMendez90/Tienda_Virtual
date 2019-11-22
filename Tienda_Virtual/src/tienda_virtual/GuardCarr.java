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

    /**
     * guarda un carro con su etiqueta
     * @param carr carro
     * @param string  etiqueta
     */
    
    public GuardCarr(Carrito carr, String string) {
        this.carr = carr;
        this.string = string;
    }
    
    /**
     * consigue la etiqueta 
     * @return etiqueta
     */

    public String getString() {
        return string;
    }
    
    /**
     * consigue el carro guardado
     * @return carro
     */

    public Carrito getCarr() {
        return carr;
    }
    
    /**
     * cambia el carro guardado
     * @param carr carro nuevo
     */

    public void setCarr(Carrito carr) {
        this.carr = carr;
    }
    
    /**
     * cambia la etiqueta del carro guardado
     * @param string nueva etiqueta
     */

    public void setString(String string) {
        this.string = string;
    }
    
    
}
