public class PDinamicArray {
    int size;
    int cap;
    Producto[] arr;
    
    
    public PDinamicArray(){
        cap = 3;
        arr = new Producto[cap];
        size = 0;
    }
    public void add(Producto o){
        if(size < cap){
            arr[size] = o;
            size++;
        } else if (size >= cap && cap <= 100000){
            Producto[] arr2 = new Producto[cap];
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
