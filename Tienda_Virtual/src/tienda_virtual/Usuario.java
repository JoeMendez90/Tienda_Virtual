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
   
    public Usuario(String username, String desc,LinkedList<Carrito> carritos) {
        this.username = username;
        this.desc = desc;
        this.carrito = null;
        productos = new Queue<>();
        this.garage = carritos;
    }
    public Usuario(){
        this("");
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

    public Queue<Producto> getProductos() {
        return productos;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public LinkedList<Carrito> getGarage() {
        return garage;
    }

    public void setProductos(Queue<Producto> productos) {
        this.productos = productos;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void setGarage(LinkedList<Carrito> garage) {
        this.garage = garage;
    }
    
    
    
}
