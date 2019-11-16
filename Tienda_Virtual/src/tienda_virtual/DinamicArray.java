/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author fanat
 * @param <T>
 */
public class DinamicArray<T>  {
    int tam = 0;
    int cap = 2;
    int i = 0;
    Generica<T>[] arr;

    public DinamicArray() {
        this.arr = new Generica[cap];
    }
    
    public void addBack(T a){
        if (tam >= cap){
            Generica<T>[] aux = new Generica[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Generica[cap];
            for (int j = 0; j<tam; j++){
                arr[j] = aux[j];
            }
        }
        arr[i] = new Generica<>(a);
        tam++;
        i++;
    }
    public void addFront(T a){
        tam++;
        if (tam >= cap){
            Generica[] aux = new Generica[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Generica[cap];
            for (int j = 0; j<tam;j++){
                arr[j] = aux[j];
            }
        }
        for (int j = tam-1; j >= 0; j--){
            arr[j+1] = arr[j];
        }
        arr[0] = new Generica<>(a);
        i++;
    }
    public T get(int index){
        return arr[index].object;
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        return tam==0;
    }
    public void delete(int index){
        Generica<T>[] respaldo = new Generica[cap];
        int j = 0;
        while (j < tam){
            if (j==index) break;
            respaldo[j] = arr[j];
            j++;
        }
        j++;
        while (j<tam){
            respaldo[j] = arr[j];
            j++;
        }
        arr = respaldo;
        for (int k = index+1; k<tam;k++){
            arr[k-1] = arr[k];
        }
        tam--;
        i--;
    }
    public void imprime(){
        for(int j = 0; j<tam;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}
