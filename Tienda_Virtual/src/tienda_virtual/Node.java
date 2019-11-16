package tienda_virtual;

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

