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