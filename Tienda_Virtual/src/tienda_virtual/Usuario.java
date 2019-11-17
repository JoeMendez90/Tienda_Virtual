package tienda_virtual;

public class Usuario {
    String username;
    String desc;
    Queue<Producto> productos;
    Carrito carrito;
    LinkedList<Carrito> garage;
    
    
    public Usuario(String username){
        this.username=username;
        this.desc = " ";
        productos = new Queue<>();
        carrito = new Carrito();
        garage = new LinkedList<>();
    }
   public Usuario(String username, String desc){
        this(username);
        this.desc=desc;
    }
    // Setters y Getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    //Funciones del usuario:
    
    //Pone a la venta un producto añadiéndolo a la lista de productos
    public void vender(String nombre, double precio){
        Producto p = new Producto(nombre, precio);
        productos.enQueue(p);
    }
    public void vender(String nombre, double precio, String desc){
        Producto p = new Producto(nombre, precio, desc);
        p.setSeller(this.username);
        productos.enQueue(p);
    }
    
    //Cambia la descripción de un producto en su lista
    public void cambiarDesc(Producto p){
        p.setDesc(desc);
    }
    public void nuevo_carrito(String name){
        Carrito car = new Carrito(name);
        garage.PushFront(car);
    }
}
