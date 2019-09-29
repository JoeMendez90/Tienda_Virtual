
public class DoubleNode<T> {
    T key;
    DoubleNode next;
    DoubleNode prev;
    public DoubleNode(){

    }
    public DoubleNode(T key){
        this.key = key;
        next = null;
        prev = null:
    }
    public DoubleNode(T key, DoubleNode next, DoubleNode prev){
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}
