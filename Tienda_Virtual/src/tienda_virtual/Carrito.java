public class Carrito {
    LinkedList<Producto> carrito = new LinkedList<Producto>();
    String carname;
    public Carrito(String nombre){
        setCarname(nombre);
    }
    
    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarname() {
        return carname;
    }
    
    public void agregar(Producto key){
        carrito.PushFront(key);
    }
    public void sacar(String key){
        Node<Producto> i = new Node<Producto>();
        i = carrito.head;
        while(i != carrito.tail){
            if (!i.key.getId().equals(key)){
                carrito.Pop(i.key);
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
