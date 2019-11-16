package tienda_virtual;


public class UDinamicArray {
    int size;
    int cap;
    Usuario[] arr = new Usuario[cap];

    
    public void addBack(Usuario a){
        if (tam >= cap){
            Usuario[] aux = new Usuario[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Usuario[cap];
            for (int j = 0; j<tam; j++){
                arr[j] = aux[j];
            }
        }
        arr[i] = a;
        tam++;
        i++;
    }
    public void addFront(Usuario a){
        tam++;
        if (tam >= cap){
            Usuario[] aux = new Usuario[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new Usuario[cap];
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
    public Usuario get(int index){
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
        } else {
            Usuario[] respaldo = new Usuario[cap];
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
            System.out.print(arr[j].username +" ");
        }
        System.out.println();
    }
    
}
