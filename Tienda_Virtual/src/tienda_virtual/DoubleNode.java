package tienda_virtual;

/**
 * La clase doble node es un nodo generico con un nodo siguiente y uno previo
 * @author Team
 * @param <T> clase generica a utilizar
 */

public class DoubleNode<T> {
    public T key;
    public DoubleNode next;
    public DoubleNode prev;
    
    /**
     * constructor vacio para iniciar en null;
     */
    
    public DoubleNode(){
    }
    
    /**
     * constructor con llave iniciada
     * @param key iniciacion de llave
     */
    public DoubleNode(T key){
        this.key = key;
        next = null;
        prev = null;
    }
    
    /**
     * constructor completo
     * @param key llave
     * @param next siguiente nodo
     * @param prev nodo previo
     */
    
    public DoubleNode(T key, DoubleNode next, DoubleNode prev){
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}
