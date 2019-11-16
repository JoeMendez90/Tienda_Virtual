public class Stack<T> {
    T key;
    DoubleLinkedList<T> listBase = new DoubleLinkedList<>();
    
    public void Push(T key){
        listBase.PushFront(key);
    }
    public void Pop(){
        listBase.PopFront();
    }
    public boolean isEmpty(){
        return listBase.IsEmpty();
    }
    public T Peek(){
        return listBase.getFront();
    }
    public void DisplayStack(){
        listBase.DisplayList();
    }
}
