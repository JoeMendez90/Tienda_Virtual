package tienda_virtual;

public class Carrito {
    private SinglyLinkedList<Producto> carrito ;
    private String carId;
    private boolean searched;
    private int length;

    public Carrito() {
        carId= "";
        carrito = new SinglyLinkedList<>();
        length=0;
        searched=true;
    }
    
    public Carrito(String id){
        carId =id;
        carrito = null;
        length=0;
        searched=false;
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
        carId= carId+key.getId();
        length++;
    }
    public void sacar(String key){
        Node<Producto> i = carrito.head;
        while(!i.equals(carrito.tail)){
            if (!i.key.getId().equals(key)){
                carrito.Erase(i.key);
                break;
            }                
            i = i.next;
        }
        length--;
    }
   public void sacar(Producto key){
        carrito.Erase(key);
        carId = carId.substring(carId.indexOf(key.getId())+key.getId().length(),carId.length());
        length--;
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
  
    public int getLength() {
        return length;
    }
    
    public void search(Tienda tienda){
        if(!searched){
            String[] palabras = carId.split("#");
            for (String palabra : palabras) {
                for (int j = 0; j< tienda.prod.tam; j++) {
                    if (tienda.prod.get(j).getId().equals("#" + palabra)) {
                        carrito.pushBack(tienda.prod.get(j));
                        break;
                    }
                }
            }
            searched=true;
        }
    }

    public boolean isSearched() {
        return searched;
    }
}
