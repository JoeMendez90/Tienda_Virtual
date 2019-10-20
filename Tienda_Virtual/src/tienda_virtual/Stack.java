public class Stack<T> {
    T key;
    DoubleLinkedList<T> listBase = new DoubleLinkedList<>();
    
    public void Push(T key){
        listBase.PushBack(key);
    }
    public void Pop(){
        listBase.PopBack();
    }
    public boolean isEmpty(){
        return listBase.IsEmpty();
    }
    public T Peek(){
        return listBase.getBack();
    }
    public void DisplayStack(){
        listBase.DisplayList();
    }
}
