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
    //private DinamicArray<GuardCarr> garage;
    private Hash_Map<String, GuardCarr> garage;

    public Garage() {
        names = new DinamicArray<>();
        garage = new Hash_Map<>();
    }

    public Garage(Hash_Map<String, GuardCarr> garage) {
        this.garage = garage;
        names = new DinamicArray<>();
        for (int i = 0; i < garage.size(); i++) {
            names.addBack(garage.elements.get(i).getKey());
            //names.addBack(garage.get(i).getString());
        }
    }
    
    public void nuevo_carrito(Carrito name, String Nombre){
        garage.put(Nombre, new GuardCarr(name,Nombre));
        //garage.addBack(new GuardCarr(name, Nombre));
        names.addBack(Nombre);
    }

    public Hash_Map<String, GuardCarr> getGarage() {
        return garage;
    }
    
    public void searchGarage(Tienda tienda){
        for(int i = 0; i< garage.elements.tam;i++){
            garage.elements.get(i).value.getCarr().search(tienda);
        }
    }
    
}
