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
    private Heap<Servicio> Servicios;
    private int servlim;
    
    // la variable servlim es para que el usuario no se sature de servicios
    // se sugiere que se pueda editar esto en el perfil
    
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
     * Constructor que inicia  el nombre de usuario, la descripcion, carrito, lista de garage y heap de servicios
     * @param username
     * @param desc
     * @param carrito
     * @param carritos 
     * @param servicios
     */
    
    public Usuario(String username, String desc, Carrito carrito,SinglyLinkedList<GuardCarr> carritos, Heap<Servicio> servicios) {
        this(username,desc,carrito,carritos);
        this.Servicios = servicios;
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
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * cambia el nombre de usuario
     * @param username nuevo nombre de usuario
     */

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
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
    /*
     * Este metodo añade un servicio a la lista de servicios
     * @param name -- el nombre del servicio
     * @param valor -- el costo del servicio
     * @param time -- el tiempo que va a tomar el servicio
    */
    public void addService(String name, int valor, int time){
        if (servlim > Servicios.Size()){
            Servicio serv = new Servicio(time,valor,name);
            // prioridad = dias del año menos el tiempo que toma el servicio
            int p = 365 - time;
            Servicios.Insert(p, serv);    
        }
        
    }

    public int getServlim() {
        return servlim;
    }

    public void setServlim(int servlim) {
        this.servlim = servlim;
    }
}
