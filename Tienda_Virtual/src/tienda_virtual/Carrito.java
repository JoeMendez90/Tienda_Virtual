package tienda_virtual;

/**
 * La Clase carrito representa a los carros de compra de la tienda,
 * se pueden tener vacios/nobuscados o iniciados/llenos
 * en la version actual su Id es la union de todos los id de los Productos,
 * para una busqueda rapida de su contenido
 * 
 * @author Team
 */

public class Carrito {
    private DinamicArray<Producto> carrito ;
    private String carId;
    private boolean searched;
    private int length;
    
    /**
     * el iniciador de un carro vacio, es el que se genera por defecto
     * su id esta vacio, su carrito/listadeobjetos se inicia
     * su tamaño es 0, y ya fue buscado, dado que su id y su contenido son el mismo
     */
    

    public Carrito() {
        carId= "";
        carrito = new DinamicArray<>();
        length=0;
        searched=true;
    }
    
    
    public void vaciar(){
        carrito=new DinamicArray<>();
    }
    /**
     * el iniciador con string guarda el id dado, el carrito no lo inicia, por que solo es referencia
     * su longitud igualmente es 0 y no ha sido buscado, dado que no tiene los productos enlistados en su id.
     * @param id 
     */
    
    public Carrito(String id){
        carId =id;
        carrito = null;
        length=0;
        searched=false;
    }

    /**
     * 
     * @return id del carro
     */
    
    public String getCarId() {
        return carId;
    }
    
    /**
     * 
     * @return lista de objetos en el carro
     */
    

    public DinamicArray<Producto> getCarrito() {
        return carrito;
    }
    
    /**
     * cambiar el id del carro
     * @param carId nuevo id del carro
     */

    public void setCarId(String carId) {
        if(!this.carId.equals(carId)){
            this.carId = carId;
            searched = false;
        }
    }
    
    /**
     * agrega un producto al carro si este no existe previamente
     * @param key producto a agregar
     */
    
    public void agregar(Producto key){
        if(!exists(key.getId())){
            carrito.addBack(key);
            carId= carId+key.getId();
            length++;
            System.out.println("agregado");
        }
    }
    
    
    public boolean exists(String key){
        for (int i = 0; i < carrito.tam; i++) {
            if(carrito.get(i).getId().equals(key)){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * elimina un producto del carro que posea el id dado
     * @param id id a eliminar
     */
    
    public void sacar(String id){
        for (int i = 0; i < carrito.tam; i++) {
            if(carrito.get(i).getId().equals(id)){
                carrito.delete(i);
                break;
            }
        }
    }
    
    /**
     * elimina un producto dado del carro
     * @param key producto a eliminar
     */
    
    public void sacar(Producto key){
        carrito.delete(carrito.getIndex(key));
    }    
  
    /**
     * consigue la cantidad actual de productos dentro del carro
     * @return productos en el carro
     */
    
    public int getLength() {
        return length;
    }
    
    /**
     * si el carro no fue buscado busca los productos dentro del id para añadirlos al carro
     * @param tienda lugar donde se guardan todos los productos
     * @return 
     */
    
    public boolean search(Tienda tienda){
        if(!searched){
            length=0;
            String[] palabras = carId.split("#");
            for (int i=1; i<palabras.length;i++) {
                int a=0;
                for (int j = 0; j< tienda.prod.tam; j++) {
                    if (tienda.prod.get(j).getId().equals("#" + palabras[i])) {
                        carrito.addBack(tienda.prod.get(j));
                        length++;
                        break;
                    }
                    a=j;
                }
                if(a==tienda.prod.tam){
                    return false;
                }
            }
            
            searched=true;
            
        }
        return true;
    }
    
    /**
     *  el id y sus productos concuerdan?
     * @return buscado?
     */

    public boolean isSearched() {
        return searched;
    }
}
