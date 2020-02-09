/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author fanat
 */
public class Garage {
    
    public DinamicArray<String> names;
    private DinamicArray<GuardCarr> garage;

    public Garage() {
        names = new DinamicArray<>();
        garage = new DinamicArray<>();
    }

    public Garage(DinamicArray<GuardCarr> garage) {
        this.garage = garage;
        names = new DinamicArray<>();
        for (int i = 0; i < garage.tam; i++) {
            names.addBack(garage.get(i).getString());
        }
    }
    
    public void nuevo_carrito(Carrito name, String Nombre){
        garage.addBack(new GuardCarr(name, Nombre));
        names.addBack(Nombre);
    }

    public DinamicArray<GuardCarr> getGarage() {
        return garage;
    }
    
    
    
}
