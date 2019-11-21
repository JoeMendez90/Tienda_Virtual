package tienda_virtual;

/**
 * clase pila
 * @author team
 * @param <T> clase generica a guardar en la pila
 */

public class Stack<T> {
    /**
     * posee un entero publico que es su cantidad de objetos
     * y una lista simplemente encadenada donde se pone la pila
     */
    public int length;
    public SinglyLinkedList<T> listBase = new SinglyLinkedList<>();
    /**
     * agrega un producto a la pila, en el frente de la lista
     * aumenta uno el tamaño
     * @param key objeto a agregar
     */
    public void Push(T key){
        listBase.PushFront(key);

        length++;
    }
    /**
     * la vfuncion pop elimina el objeto que se encuentra en la punta (se recomienda hacer peek previamente o se pierde el dato)
     */
    
    public void Pop(){
        listBase.popFront();
        length--;

    }
    /**
     * dice si la pila esta vacia
     * @return esta vacia?
     */
    
    public boolean isEmpty(){
        return listBase.isEmpty();
    }
    
    /**
     * devuelve el objeto que se encuentra en la cima de la pila, sin retirarlo
     * @return objeto en el pico
     */
    public T Peek(){
        return listBase.TopFront().key;
    }
    
    /**
     * enlista todos los componentes de la pila
     * @return arreglo dinamico con todos los datos de la pila
     */
    
    public DinamicArray<T> DisplayStack(){
        return listBase.DisplayList();
    }
}
