
public class StringDinamicArray {
    int tam = 0;
    int cap = 2;
    int i = 0;
    String[] arr = new String[cap];
    
    public void addBack(String a){
        if (tam >= cap){
            String[] aux = new String[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new String[cap];
            for (int j = 0; j<tam; j++){
                arr[j] = aux[j];
            }
        }
        arr[i] = a;
        tam++;
        i++;
    }
    public void addFront(String a){
        tam++;
        if (tam >= cap){
            String[] aux = new String[cap];
            for (int j = 0; j<cap;j++){
                aux[j] = arr[j];
            }
            if (cap <10000000) cap *= 2;
            if (cap >= 10000000) cap+=10000000;
            arr = new String[cap];
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
    public String get(int index){
        return arr[index];
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        return tam==0;
    }
    public void delete(int index){
        String[] respaldo = new String[cap];
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
    boolean exist(String l){
        boolean t = true;
        if(isEmpty()){
            t = false;
        } else{
            for (int a = 0; a<tam;a++){
                if (arr[a].equals(l)){
                    t = true;
                    break;
                }
            }
        }
        return t;
    }
}
