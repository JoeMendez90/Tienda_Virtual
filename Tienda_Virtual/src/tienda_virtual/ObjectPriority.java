/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *  esta clase representa a los objetos con su prioridad dentro de las colas prioritarias
 * @author fanat
 */
public class ObjectPriority<T> {
    public int priority;
    public T object;

    /**
     * object priority vacio
     */
    
    public ObjectPriority() {
    }

    /**
     * object priority completo
     * @param priority prioridad
     * @param object  objeto
     */
    
    public ObjectPriority(int priority, T object) {
        this.priority = priority;
        this.object = object;
    }
}
