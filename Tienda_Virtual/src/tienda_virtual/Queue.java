package tienda_virtual;

public class Queue<T> {
    public T key;
    private SinglyLinkedList<T> listBase = new SinglyLinkedList<>();
    public int length;

    public Queue() {
        length=0;
    }
    
    public void enQueue(T key){
        listBase.pushBack(key);
        length++;
    }
    public void deQueue(){
        listBase.popFront();
        length--;
    }
    public boolean isEmpty(){
        return listBase.isEmpty();
    }
    public T Peek(){
        return listBase.TopFront().key;
    }
    public DinamicArray<T> DisplayQueue(){
        return listBase.DisplayList();
    }
}
