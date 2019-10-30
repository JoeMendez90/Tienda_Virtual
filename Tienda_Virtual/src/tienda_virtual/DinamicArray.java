/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

import java.lang.reflect.Array;

/**
 *
 * @author fanat
 * @param <T>
 */
public class DinamicArray<T>  {
     int size;
    int cap;
    T[] arr;
    
    
    public DinamicArray(Class<T[]> Ts,T a){
        cap = 3;
        arr = Ts.cast(Array.newInstance(Ts.getComponentType(), cap));  
        
        size = 0;
    }
    public void add(T o){
        if(size < cap){
            arr[size] = o;
            size++;
        } else if (size >= cap && cap <= 100000){
           
            T[] arr2 = arr;  
            //arr2 = arr.getClass().cast(Array.newInstance(this.arr.getClass().getComponentType(), cap));
            for (int i = 0; i< cap; i++){
                arr2[i] = arr[i];
           }
            cap *= 2;
            arr = new Producto[cap];
            for (int i = 0; i<size;i++){
                arr[i] = arr2[i];
            }
        } else if (size >= cap && cap >= 10000){
            Producto[] arr2 = new Producto[cap];
            for (int i = 0; i< cap; i++){
                arr2[i] = arr[i];
           }
            cap += 30;
            arr = new Producto[cap];
            for (int i = 0; i<size;i++){
                arr[i] = arr2[i];
            }
        }
    }
    public int getSize(){
        return this.size;
    }
    public Producto get(int i){
        return arr[i];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void deleteKey(int k){
        arr[k] = null;
        for (int i = k+1; i<size;i++){
            arr[i-1]= arr[i];
            arr[i] = null;
        }
    }
}
