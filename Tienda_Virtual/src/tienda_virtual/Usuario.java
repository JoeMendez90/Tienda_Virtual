package tienda_virtual;

/**
 * Clase que define los Usuarios de la aplicacion, 
 * guarda su nombre descripcion, productos subidos,
 * su carro de compras, y el garage de carros que desea guardar.
 * 
 * @author Team
 */

public class Usuario {
    public String username;
    public String desc;
    public Queue<String> productos;
    private  Carrito carrito;
    private SinglyLinkedList<GuardCarr> garage;
    
    
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
        garage = new SinglyLinkedList<>();
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
   
    public Usuario(String username, String desc,SinglyLinkedList<GuardCarr> carritos) {
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
    
    public Usuario(String username, String desc, Carrito carrito,SinglyLinkedList<GuardCarr> carritos) {
        this.username = username;
        this.desc = desc;
        this.carrito = carrito;
        productos = new Queue<>();
        this.garage = carritos;
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
    
    //Cambia la descripción de un producto en su lista
    public void nuevo_carrito(Carrito name, String Nombre){
        garage.PushFront(new GuardCarr(name, Nombre));
    }

    public Queue<String> getProductos() {
        return productos;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public SinglyLinkedList<GuardCarr> getGarage() {
        return garage;
    }

    public void setProductos(Queue<String> productos) {
        this.productos = productos;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void setGarage(SinglyLinkedList<GuardCarr> garage) {
        this.garage = garage;
    }
    
    public void aCarrito(Producto p){
        carrito.agregar(p);
    }
    
    public void dCarrito(Producto p){
        carrito.sacar(p);
    }
    //Cambia la descripción de un producto en su lista
    public void cambiarDesc(Producto p,String desc){
        p.setDesc(desc);
    }
       
    public int cantCarr(){
        return carrito.getLength();
    }
    
}
