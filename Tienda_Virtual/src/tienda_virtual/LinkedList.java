package tienda_virtual;

public class LinkedList<T>{
    Node<T> head = null;
    Node<T> tail = null;
    
    public boolean IsEmpty(){
        return this.head == null;
    }
    public void PushFront(T key){
        Node<T> node2 = new Node<>(key);
        if (IsEmpty()){
            this.tail = node2;
            this.head = tail;
        } else {
            node2.next = head;
            this.head = node2;
        }
        if (tail == null){
            this.tail = this.head;
        }
    }
    public void PushBack(T key){
        Node<T> node2 = new Node<>(key);
        if (IsEmpty()){
            this.tail = node2;
            this.head = tail;
        } else {
            this.tail.next = node2;
            this.tail = node2;
            node2 = this.tail;
        }
        if (tail == null){
            this.tail = this.head;
        }
    }
    public void Add(int index, T key){
        int c = 0;
        Node<T> aux = this.head;
        Node<T> node2 = new Node<>(key);
        if (index == 0){
            PushFront(key);
        } else {
            while (c != index - 1){
                aux = aux.next;
                c++;
            }
            node2.next = aux.next;
            aux.next = node2;
        }
    }
    public void PopFront(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            this.head = null;
            this.tail = this.head;
        } else {
            head = this.head.next;
        }
    }
    public void PopBack(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            this.tail = null;
            this.head = tail;
        } else{
            Node<T> aux = this.head;
            Node<T> p = head.next;
            while (p != tail){
                aux = aux.next;
                p = p.next;
            }
            if (p != null){
                aux.next = p.next;
                if (p == tail){
                    tail = aux;
                }
            }            
        }
    }
    public void Pop(T key){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            System.out.println("ERROR");
            return;
        }
        if (this.head == this.tail){
            this.head = null;
            this.tail = this.head;
        } else if (head.key == key){
            head = head.next;
        } else {
            Node anterior = head;
            Node p = head.next;
            while (p != tail && p.key != key){
                anterior = anterior.next;
                p = p.next;
            }
            if (p != null){
                anterior.next = p.next;
                if (p == tail){
                    tail = anterior;
                }
            }
        }
    }
    T get(int index){
        int c = 0;
        Node<T> aux = this.head;
        while (c != index){
            aux = aux.next;
            c++;
        }
        return aux.key;
    }
    public T getBack(){
        return this.tail.key;
    }
    public T getFront(){
        return this.head.key;
    }
    public void DisplayList(){
        if (IsEmpty()){
            System.out.println("      ,,,,,,,,,,,,,,,,,");
            System.out.println("     / Oye!!!         |");
            System.out.println("(\\_/)\\Aqui no hay nada|");
            System.out.println("(^w^) '''''''''''''''''");
            System.out.println("(W W)3");
            return;
        }
        Node<T> a = head;
        while (a != null){
            if (a.next != null){
                System.out.print(a.key + " --> ");
            } else{
                System.out.println(a.key);
            }
            a = a.next;
        }
    }
}