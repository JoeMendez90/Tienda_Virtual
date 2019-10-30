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
public class SinglyLinkedList<T> {
    private Node<T> head=null;
    private Node<T> tail=null;
    
    public void PushFront(T key){
        Node<T> node = new Node<>(key);
        node.setNext(head);
        head=node;
        if(tail == null){
            tail = head;
        }
    }
    
    public Node<T> TopFront(){
        if(head==null){
            System.out.println("Error Empty List");
            return null;
        }
        return head;
    }
    
    public void popFront(){
        if(head==null){
            System.out.println("Error Empty List");
            return;
        }
        
        head=head.getNext();
        if(head==null){
            tail=null;
        }
    }
    
    public void pushBack(T key){
        Node<T> node = new Node<>(key);
        node.setNext(null);
        if(tail==null){
            head=tail=node;
        }else{
            tail.setNext(node);
            tail=node;
        }
    }
    
    public Node<T> TopBack(){
        if(tail==null){
            System.out.println("Error Empty List");
            return null;
        }
        return tail;
    }
    
    public void popBack(){
        if(head==null){
            System.out.println("Error Empty List");
            return;
        }
        if(head==tail){
            head=tail=null;
        }else{
            Node<T> p = head;
            while(p.getNext().getNext()!= null){
                p=p.getNext();
            }
            p.setNext(null);
            tail=p;
        }
    }
    
    public boolean Find(T key){
        if(head==null){
            return false;
        }
        
        Node<T> p=head;
        
        while(p!=null){
            if(p.getKey()==key){
                return true;
            }
        }
        
        return false;
        
    }
    
    public void Erase(T key){
        if(head==null){
            return;
        }
        
        if(head.getKey()==key){
            head=head.getNext();
        }
        
        Node<T> p=head;
        
        while(p.getNext()!=tail&&p.getNext().getKey()!=key){
            p=p.getNext();
        }
        
        if(p.getNext().getKey()==key){
            if(p.getNext()==tail){
                tail=p;
                p.setNext(null);
            }else{
                p.setNext(p.getNext().getNext());
            }
        }
        
    }
    
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addAfter(Node<T> node, T key){
        Node<T> node2 = new Node<>(key);
        node2.setNext(node.getNext());
        node.setNext(node2);
        if(tail==node){
           tail=node2;
        }
    }
    
    public void addBefore(Node<T> node, T key){
        Node<T> node2 = new Node<>(key);
        node2.setNext(node);
        if(head==node){
            head=node2;
        }
        
        Node<T> p =head;
        
        while(p.getNext()!=tail && p.getNext()!=node){
            p=p.getNext();
        }
       
        
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
