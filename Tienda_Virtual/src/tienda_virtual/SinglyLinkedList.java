/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

import sun.security.util.Length;

/**
 *
 * @author fanat
 */
public class SinglyLinkedList<T> {
    public  Node<T> head=null;
    public  Node<T> tail=null;
    public int length;

    public SinglyLinkedList() {
        length=0;
    }
    
    
    
    public void PushFront(T key){
        Node<T> node = new Node<>(key);
        node.next=head;
        head=node;
        if(tail == null){
            tail = head;
        }
        length++;
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
        
        head=head.next;
        if(head==null){
            tail=null;
        }
        length--;
    }
    
    public void pushBack(T key){
        Node<T> node = new Node<>(key);
        node.next =null;
        if(tail==null){
            head=tail=node;
        }else{
            tail.next =(node);
            tail=node;
        }
        length++;
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
            while(p.next.next != null){
                p=p.next;
            }
            p.next=(null);
            tail=p;
        }
        length--;
    }
    
    public boolean Find(T key){
        if(head==null){
            return false;
        }
        
        Node<T> p=head;
        
        while(p!=null){
            if(p.key.equals(key)){
                return true;
            }
        }
        
        return false;
        
    }
    
    public void Erase(T key){
        if(head==null){
            return;
        }
        
        if(head.key.equals(key)){
            head=head.next;
        }
        
        Node<T> p=head;
        
        while(p.next!=tail&&p.next.key!=key){
            p=p.next;
        }
        
        if(p.next.key==key){
            if(p.next==tail){
                tail=p;
                p.next = (null);
            }else{
                p.next = (p.next.next);
            }
        }
        
    }
    
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addAfter(Node<T> node, T key){
        Node<T> node2 = new Node<>(key);
        node2.next = (node.next);
        node.next = (node2);
        if(tail==node){
           tail=node2;
        }
    }
    
    public void addBefore(Node<T> node, T key){
        Node<T> node2 = new Node<>(key);
        node2.next = (node);
        if(head==node){
            head=node2;
        }
        
        Node<T> p =head;
        
        while(p.next!=tail && p.next!=node){
            p=p.next;
        }
       
        
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
    
    public DinamicArray<T> DisplayList(){
        DinamicArray<T> list = new DinamicArray<>();
        Node<T> a = head;
        while (a != null){
            list.addBack(a.key);
        }
        
        return list;
    }
}
