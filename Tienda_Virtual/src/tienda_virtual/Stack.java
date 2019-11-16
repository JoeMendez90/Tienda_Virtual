package tienda_virtual;

public class Stack<T> {
    public int length;
    public SinglyLinkedList<T> listBase = new SinglyLinkedList<>();
    
    public void Push(T key){
        listBase.PushFront(key);

        length++;
    }
    public void Pop(){
        listBase.popFront();
        length--;

    }
    public boolean isEmpty(){
        return listBase.isEmpty();
    }
    public Node<T> Peek(){
        return listBase.TopFront();
    }
    
    public void DisplayStack(){
        listBase.DisplayList();
    }
}
