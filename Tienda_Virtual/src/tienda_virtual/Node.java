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
    public T key;
    public Node<T> next;

    public Node(T key, Node<T> next) {
        this.key = key;
        this.next = next;
    }

    public Node(T key) {
        this.key = key;
    }
    
}
