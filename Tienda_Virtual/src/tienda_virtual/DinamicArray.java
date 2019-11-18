
package tienda_virtual;

/**
 * La clase arreglo Dinamico  generalizada (al no poder hacer arreglos genericos se uso la clase generica)
 * @author Team
 * @param <T>
 */
public class DinamicArray<T>  {
    public int tam = 0;
    public int cap = 2;
    public int i = 0;
    Generica<T>[] arr;

    /**
     * el constructor incializa el arreglo con uno nuevo 
     */
    
    public DinamicArray() {
        this.arr = new Generica[cap];
    }
    
    /**
     * esta funcion agrega el objeto ingresado al final del arreglo
     * @param a objeto a a agregar
     */
    
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
    
    /**
     * añade el objeto ingresado  al inicio del arreglo
     * @param a objeto a añadir
     */
    
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
    
    /**
     * devuelve el objeto encontrado dentro del index pedido
     * @param index index donde busca el objeto
     * @return objeto encontrado
     */
    
    public T get(int index){
        return arr[index].object;
    }
    
    /**
     * cambia el objeto dentro de el index dado
     * @param index index donde se cambia el objeto
     * @param l objeto nuevo
     */
    
    public void set(int index, T l){
        arr[index].object = l;
    }
    
    /**
     * da el tamaño actual del arreglo
     * @return  tamaño del arreglo
     */
    
    public int size(){
        return tam;
    }
    
    /**
     * 
     * @return el arreglo esta vacio?
     */
    
    public boolean isEmpty(){
        return tam==0;
    }
    
    /**
     * borra la ubicacion del index dado
     * @param index index a borrar
     */
    
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
    
    /**
     * imprime el arreglo en consola
     */
    
    public void imprime(){
        for(int j = 0; j<tam;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
    
    /**
     * revisa si existe el objeto dentro del arreglo
     * @param l objeto a encontrar
     * @return esta el objeto en lista?
     */
    
    
    public boolean exist(T l){
        boolean t = true;
        if(isEmpty()){
            t = false;
        } else{
            for (int a = 0; a<tam;a++){
                if (arr[a].object.equals(l)){
                    t = true;
                    break;
                }
            }
        }
        return t;
    }
    
    /**
     * busca el indice de un objeto especifico
     * @param l objeto a buscar
     * @return  indice donde se encuentra
     */
    
    public int getIndex(T l){
        int t = -1;
        if(!isEmpty()){
            for (int a = 0; a<tam;a++){
                if (arr[a].object.equals(l)){
                    t = a;
                    break;
                }
            }
        }
        return t;
    }
}
