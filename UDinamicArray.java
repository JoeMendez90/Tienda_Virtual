
public class UDinamicArray {
    int size;
    int cap;
    Usuario[] arr;
    
    
    public UDinamicArray(){
        cap = 3;
        arr = new Usuario[cap];
        size = 0;
    }
    public void add(Usuario o){
        if(size < cap){
            arr[size] = o;
            size++;
        } else if (size == cap && cap <= 100000){
            Usuario[] arr2 = new Usuario[cap];
            for (int i = 0; i< cap; i++){
                arr2[i] = arr[i];
           }
            cap *= 2;
            arr = new Usuario[cap];
            for (int i = 0; i<size;i++){
                arr[i] = arr2[i];
            }
        } else if (size == cap && cap >= 10000){
            Usuario[] arr2 = new Usuario[cap];
            for (int i = 0; i< cap; i++){
                arr2[i] = arr[i];
           }
            cap += 30;
            arr = new Usuario[cap];
            for (int i = 0; i<size;i++){
                arr[i] = arr2[i];
            }
        }
    }
    public int getSize(){
        return this.size;
    }
    public Usuario get(int i){
        return arr[i];
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
