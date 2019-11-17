
public class Heap{
    IntDinamicArray H;
    int root;
    public Heap(){
        H = new IntDinamicArray();
    }
    public Heap(int n){
        H = new IntDinamicArray();
        H.addBack(0);
        H.addBack(n);
    }
    public int Parent(int i){
        return (int)(i/2);
    }
    public int leftSon(int i){
        return 2*i;
    }
    int rightSon(int i){
        return 2*i + 1;
    }
    public void siftUp(int i){
        while (i > 1 && H.get(Parent(i)) < H.get(i)){
            int aux = H.get(Parent(i));
            H.set(Parent(i), H.get(i));
            H.set(i,aux);
            i = Parent(i);
        }
    }
    public void siftDown(int i){
        int maxIndex = i;
        int l = leftSon(i);
        if (l <= H.size() && H.get(l) > H.get(maxIndex)){
            maxIndex = l;
        }
        int r = rightSon(i);
        if (r <= H.size() && H.get(r) > H.get(maxIndex)){
            maxIndex = r;
        }
        if (i != maxIndex){
            int aux = H.get(maxIndex);
            H.set(maxIndex, H.get(i));
            H.set(i, aux);
            siftDown(maxIndex);
        }
    }
    public void Insert(int p){
        H.addBack(p);
        siftUp(H.size()-1);
    }
    public int extractMax(){
        int result = H.get(1);
        H.set(1, H.get(H.size()-1));
        H.delete(H.size()-1);
        siftDown(1);
        return result;
    }
    public void Remove(int i){
        H.set(i,H.get(1)+10);
        siftUp(i);
        extractMax();
    }
    public void changePriority(int i, int p){
        int oldp = H.get(i);
        H.set(i,p);
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
