package tienda_virtual;

/**
 * La clase de una lista doblemente encadenada
 * @author Team
 * @param <T> objeto generico del la lista
 */

public class DoubleLinkedList<T>{
    DoubleNode<T> head = null;
    DoubleNode<T> tail = null;
    
    /**
     * 
     * @return esta vacio?
     */
    
    public boolean IsEmpty(){
        return this.head == null;
    }
    
    /**
     * agrega en la cabeza de la lista un objeto
     * @param key objeto a agregar
     */
    
    public void PushFront(T key){
        DoubleNode<T> node2 = new DoubleNode<>(key);
        if (IsEmpty()){
            this.tail = node2;
            this.head = tail;
        } else {
            node2.next = head;
            node2.prev = null;
            this.head = node2;
            this.head.next.prev = head;
        }
        if (this.tail == null){
            this.tail = this.head;
        }
    }
    
    /**
     * agrega en la cola de la lista un objeto
     * @param key objeto a agregar
     */
    
    public void PushBack(T key){
        DoubleNode<T> node2 = new DoubleNode<>(key);
        node2.next = null;
        node2.prev = tail;
        if (IsEmpty()){
            this.tail = node2;
            this.head = tail;
        } else {
            this.tail.next = node2;
            node2.prev = this.tail;
            this.tail = node2;
        }
    }
    
    /**
     * elimina la ultima cosa de la lista
     */
    
    public void PopBack(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            this.tail = null;
            this.head = tail;
        } else{
            this.tail = tail.prev; 
            this.tail.next = null;
        }
    }
    
    /**
     * elimina la primera cosa de la lista
     */
    
    public void PopFront(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            this.head = null;
            this.tail = this.head;
        } else {
            head = this.head.next;
            head.prev.next = null;
            this.head.prev = null;
        }
    }
    
    /**
     * elimina un objeto en especifico
     * @param key objeto a eliminar
     */
    
    public void Pop(T key){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            if(head.key.equals(key)){
                this.head = null;
                this.tail = this.head;
            }
        } else if (head.key == key){
            head = head.next;
        } else {
            DoubleNode anterior = head;
            DoubleNode p = head.next;
            while (p != tail && p.key != key){
                anterior = anterior.next;
                p = p.next;
            }
            if (p != null){
                anterior.next = p.next;
                if (p == tail){
                    tail = anterior;
                }
            }
        }
    }
    
    /**
     * de vuelve el la llave eel nodo final
     * @return llave de la cola
     */
    
    public T getBack(){
        return this.tail.key;
    }
    
    /**
     * devuelve el primer elemento
     * @return llave de la cabeza
     */
    
    public T getFront(){
        return this.head.key;
    }
    
    /**
     * muestra en consola toda la lista
     */
    
    public void DisplayList(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            return;
        }
        DoubleNode<T> a = head;
        while (a != null){
            if (a.next != null){
                System.out.print(a.key + " <--> ");
            } else{
                System.out.println(a.key);
            }
            a = a.next;
        }
    }
    
}
