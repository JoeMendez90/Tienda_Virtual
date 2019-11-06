package tienda_virtual;

public class Carrito {
    private SinglyLinkedList<Producto> carrito ;
    private String carId;

    public Carrito() {
        carrito = new SinglyLinkedList<>();
    }
    
    
    
    public Carrito(String nombre){
        carId =nombre;
        carrito = new SinglyLinkedList<>();
    }

    public String getCarId() {
        return carId;
    }

    public SinglyLinkedList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
    
    
    
    public void agregar(Producto key){
        carrito.PushFront(key);
    }
    public void sacar(String key){
        Node<Producto> i = carrito.head;
        while(i.equals(carrito.tail)){
            if (!i.key.getId().equals(key)){
                carrito.Erase(i.key);
                break;
            }                
            i = i.next;
        }
    }
    public void verCarrito(){
        Node<Producto> i = carrito.head;
        while (i != carrito.tail){
            System.out.println(i.key.getId() + " " + i.key.getNombre() + " " + i.key.getValor());
            i = i.next;
        }
    }
    public String generar(){
        Node<Producto> i = carrito.head;
        String s = "";
        while (i != carrito.tail){
            s = s+i.key.getId();
            i = i.next;
        }
        return s;
    }
}
