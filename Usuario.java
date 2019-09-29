public class Usuario {
    String username;
    String password;
    String desc;
    Queue<Producto> productos;
    Stack<Producto> carrito;
    
    public Usuario(String username, String password){
        setUsername(username);
        setPassword(password);
        this.desc = "";
        productos = new Queue<Producto>();
        carrito = new Stack<Producto>();
    }
    public Usuario(String username, String password, String desc){
        this(username, password);
        setDesc(desc);
        productos = new Queue<Producto>();
        carrito = new Stack<Producto>();
    }
    // Setters y Getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    // Por obvias razones no hay getter para password
    public void setPassword(String password) {
        this.password = password;
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
    public void aCarrito(Producto p){
        carrito.Push(p);
    }
    //Cambia la descripción de un producto en su lista
    public void cambiarDesc(Producto p){
        p.setDesc(desc);
    }
    
}
