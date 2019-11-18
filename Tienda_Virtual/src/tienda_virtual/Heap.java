package tienda_virtual;

/**
 * La clase Heap es una cola prioritaria
 * @author fanat
 */
public class Heap<T>{
    DinamicArray<ObjectPriority<T>> H;
    int root;
    
    /**
     * crea un Heap vacio
     */
    
    public Heap(){
        H = new DinamicArray<>();
    }
    
    /**
     * crea un Heap con un objeto inicial de prioridad n 
     * @param n prioridad
     * @param object obbjeto inicial
     */
    
    public Heap(int n, T object){
        H = new DinamicArray<>();
        H.addBack(new ObjectPriority<>(0, null));
        H.addBack(new ObjectPriority<>(n, object));
    }
    
    /**
     * busca el padre del indice
     * @param i indice buscado
     * @return padre
     */
    
    public int Parent(int i){
        return (int)(i/2);
    }
    
    /**
     * busca el hijo derecho del indice dado
     * @param i indiec
     * @return  hijo derecho
     */
    
    public int leftSon(int i){
        return 2*i;
    }
    
    /**
     * busca el hijo izquierdo del indice dado
     * @param i indice
     * @return  hijo izquierdo
     */
    
    int rightSon(int i){
        return 2*i + 1;
    }
    
    /**
     * intercambia hacia arriba el indice dado
     * @param i indice a subir
     */
    
    public void siftUp(int i){
        while (i > 1 && H.get(Parent(i)).priority < H.get(i).priority){
            ObjectPriority<T> aux = H.get(Parent(i));
            H.set(Parent(i), H.get(i));
            H.set(i,aux);
            i = Parent(i);
        }
    }
    public void siftDown(int i){
        int maxIndex = i;
        int l = leftSon(i);
        if (l <= H.size() && H.get(l).priority > H.get(maxIndex).priority){
            maxIndex = l;
        }
        int r = rightSon(i);
        if (r <= H.size() && H.get(r).priority > H.get(maxIndex).priority){
            maxIndex = r;
        }
        if (i != maxIndex){
            ObjectPriority<T> aux = H.get(maxIndex);
            H.set(maxIndex, H.get(i));
            H.set(i, aux);
            siftDown(maxIndex);
        }
    }
    public void Insert(int p,T object){
        H.addBack(new ObjectPriority<>(p,object));
        siftUp(H.size()-1);
    }
    public T extractMax(){
        ObjectPriority<T> result = H.get(1);
        H.set(1, H.get(H.size()-1));
        H.delete(H.size()-1);
        siftDown(1);
        return result.object;
    }
    public void Remove(int i){
        H.get(1).priority+=10;
        H.set(i,H.get(1));
        siftUp(i);
        extractMax();
    }
    public void changePriority(int i, int p){
        int oldp = H.get(i).priority;
        H.get(i).priority=p;
        if(p>oldp){
            siftUp(i);
        } else {
            siftDown(i);
        }
    }
    
    public void printHeap(){
        for (int i = 1; i<H.size();i++){
            System.out.print(H.get(i) + " ");
        }
        System.out.println();
    }
}
