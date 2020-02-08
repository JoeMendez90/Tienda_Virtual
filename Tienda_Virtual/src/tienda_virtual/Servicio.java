/**
 * Un servicio también es algo comerciable
 * Un servicio se diferencia de los productos en tanto tiene tiempo de entrega
 * el tiempo de entrega determina la prioridad del servicio
 * =]
 */
package tienda_virtual;

public class Servicio {
    int tiempoMax;
    int valor;
    int comision;
    int task;
    int cump;
    public boolean ready;
    String nombre;
    String vendedor;
    String descripcion;
    Producto product;
    DinamicArray<Fase> fases;
    public Servicio(String nombre, int tiempoMax, int valor){
        this.nombre = nombre;
        this.tiempoMax = tiempoMax;
        this.valor = valor;
        task = 0;
        cump = 0;
        ready = false;
    }
    public Servicio(String nombre, int tiempoMax, int valor, String descripcion){
        this(nombre, tiempoMax, valor);
        this.descripcion = descripcion;
    }
    public Servicio(String nombre, int tiempoMax, int valor, String descripcion, String vendedor){
        this(nombre, tiempoMax, valor, descripcion);
        this.vendedor = vendedor;
    }
    public void addFase(String nombre, int t){
        fases.addBack(new Fase(nombre,t));
        task++;
    }
    // ejecute esto cuando se haya cumplido una fase
    void cumplir(){
        fases.get(0).chulito();
        cump++;
        // el servicio se ha cumplido
        if(task==cump){
            ready = true;
        }
    }
}
