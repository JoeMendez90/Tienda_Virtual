
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
public class Node<T> {
    private T key;
    private Node<T> next;

    public Node(T key, Node<T> next) {
        this.key = key;
        this.next = next;
    }

    public Node(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    
}
=======
public class Node<T> {
    T key;
    Node next;
    
    public Node(){    
    
    }
    public Node(T key){
        this.key = key;
        next = null;
    }
    public Node(T key, Node next){
        this.key = key;
        this.next = next;
    }
}
