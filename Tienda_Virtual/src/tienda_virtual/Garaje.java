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
public class Garaje {
    public Carrito mainCar;
    private DinamicArray<GuardCarr> garage;
    
    public Garaje(DinamicArray<GuardCarr> garage) {
        this.garage = garage;
    }
    public DinamicArray<GuardCarr> getGarage() {
        return garage;
    }
    private GuardCarr convert(){
        return new GuardCarr(this.mainCar,this.mainCar.getCarId());
    }
    public void setMainCar(Carrito carrito){
        this.mainCar = carrito;
    }
    public void nuevo_carrito(Carrito name, String Nombre){
        garage.addBack(new GuardCarr(name, Nombre));
    }
    public void agregar(){
        garage.addBack(new GuardCarr(this.mainCar,mainCar.getCarId()));
    }
    public void eliminar(GuardCarr f){
        if(garage.exist(f)) this.garage.delete(garage.getIndex(f));
    }
    public void guardRemp(GuardCarr remplazado){
        if(garage.exist(remplazado))this.garage.set(garage.getIndex(remplazado), convert());
    }
    public String exportar(GuardCarr exportable){
        boolean t = false;
        if(garage.exist(exportable)) t = true;
        return exportable.getCarr().getCarId();
    }
    public void importar(Tienda tend, String id){
        //¿?
        Carrito duda = new Carrito();
        duda.setCarId(id);
        duda.search(tend);
        garage.addBack(new GuardCarr(duda,duda.getCarId()));
    }
    public void sacar(GuardCarr out){
        this.mainCar = garage.get(garage.getIndex(out)).getCarr();
    }
    
}
