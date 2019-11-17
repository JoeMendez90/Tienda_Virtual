package tienda_virtual;

/**
 * Clase que define los Usuarios de la aplicacion, 
 * guarda su nombre descripcion, productos subidos,
 * su carro de compras, y el garage de carros que desea guardar.
 * 
 * @author Team
 */

public class Usuario {
    String username;
    String desc;
    Queue<Producto> productos;
    Carrito carrito;
    LinkedList<Carrito> garage;
    private DinamicArray<Carrito> carritos;
    
    
    /**
     * Construcor que inicializa el usuario por el recibido, 
     * la descripcion vacia, los productos los inicia, al igual que el carro y el garage
     * @param username nombre del usuario a crear
     */
    
    public Usuario(String username){
        this.username=username;
        this.desc = " ";
        productos = new Queue<>();
        carrito = new Carrito();
        garage = new LinkedList<>();
    }
    
    /**
     * este contructor llama al primer ocntructor y 
     * cambia su descripcion por la recibida
     * @param username usuario a crear
     * @param desc descripcion nueva
     */
    
   public Usuario(String username, String desc){
        this(username);
        this.desc=desc;
    }
   
   /**
    * Constructor con descripcion nombre y carro de compra
    * @param username
    * @param desc
    * @param carrito 
    */
   
    public Usuario(String username, String desc, Carrito carrito) {
        this.username = username;
        this.desc = desc;
        this.carrito = carrito;
        productos = new Queue<>();
    }
   
    /**
     * constructor que sirve para iniciar el usuario, desripcion, y garage 
     * @param username nombre del usuario
     * @param desc descripcion guardar
     * @param carritos lista de carros guardados
     */
   
    public Usuario(String username, String desc,LinkedList<Carrito> carritos) {
        this.username = username;
        this.desc = desc;
        this.carrito = null;
        productos = new Queue<>();
        this.garage = carritos;
    }
    
    /**
     * Constructor que inicia  el nombre de usuario, la descripcion, carrito, y lista de garage
     * @param username
     * @param desc
     * @param carrito
     * @param carritos 
     */
    
    public Usuario(String username, String desc, Carrito carrito,DinamicArray<Carrito> carritos) {
        this.username = username;
        this.desc = desc;
        this.carrito = carrito;
        productos = new Queue<>();
        this.carritos = carritos;
    }
    
    /**
     * este constructor crea un usuario sin nombre, que sirve como el usuario anonimo por defecto en la tienda
     */
    
    public Usuario(){
        username= "";
        productos = new Queue<>();
        carrito = new Carrito();
    }
    // Setters y Getters
    
    /**
     * get del nombre de usuario
     * @return 
     */
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
    
    public void aCarrito(Producto p){
        carrito.agregar(p);
    }
    //Cambia la descripción de un producto en su lista
    public void cambiarDesc(Producto p,String desc){
        p.setDesc(desc);
    }
       
    public int cantCarr(){
        return carrito.getLength();
    }
    
}
