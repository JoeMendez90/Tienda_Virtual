package tienda_virtual;

/**
 * Generica es una clase que sirve principalmente poara arreglos dinamicos,
 * ya que guarda un objeto generico permitiendo contar como no generico en la creaccion de arreglos
 * @author fanat
 * @param <T> tipo de objeto a usar
 */

public class Generica<T> {
    public T object;

    /**
     * creador vacio
     */
    
    public Generica() {
    }
    
    /**
     * creador con objeto inicializado
     * @param object objeto a guardar
     */

    public Generica(T object) {
        this.object = object;
    }
    
    
}
