package tienda_virtual;

public class PDinamicArray {
    int tam = 0;
    int cap = 2;
    int i = 0;
    Producto[] arr = new Producto[cap];
    
    public void addBack(Producto a){
        if (tam >= cap){
            Producto[] aux = new Producto[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Producto[cap];
            for (int j = 0; j<tam; j++){
                arr[j] = aux[j];
            }
        }
        arr[i] = a;
        tam++;
        i++;
    }
    public void addFront(Producto a){
        tam++;
        if (tam >= cap){
            Producto[] aux = new Producto[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Producto[cap];
            for (int j = 0; j<tam;j++){
                arr[j] = aux[j];
            }
        }
        for (int j = tam-1; j >= 0; j--){
            arr[j+1] = arr[j];
        }
        arr[0] = a;
        i++;
    }
    public Producto get(int index){
        return arr[index];
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        return tam==0;
    }
    public void delete(int index){
        if (isEmpty()){
            return;
        } else{
            Producto[] respaldo = new Producto[cap];
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
    }
    public void imprime(){
        for(int j = 0; j<tam;j++){
            System.out.print(arr[j].getNombre() +" ");
        }
        System.out.println();
    }
    
    
    
}
