public class Queue<T> {
    T key;
    DoubleLinkedList<T> listBase = new DoubleLinkedList<>();
    
    public void enQueue(T key){
        listBase.PushFront(key);
    }
    public void deQueue(){
        listBase.PopBack();
    }
    public boolean isEmpty(){
        return listBase.IsEmpty();
    }
    public T Peek(){
        return listBase.getBack();
    }
    public void DisplayQueue(){
        listBase.DisplayList();
    }
}
