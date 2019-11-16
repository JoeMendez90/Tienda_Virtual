public class Producto {
    private String id;
    private String nombre;
    private String desc;
    private double valor;
    private String seller;
    
    public Producto(String nombre, double valor){
        setNombre(nombre);
        setValor(valor);
        this.seller="";
    }
    public Producto(String nombre, double valor, String desc){
        this(nombre, valor);
        setDesc(desc);
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public void setSeller(String seller){
        this.seller = seller;
    }
    //Getters:

    public String getId() {
        return id;
    }
   
    public String getNombre(){
        return this.nombre;
    }
    public String getDesc(){
        return this.desc;
    }
    public double getValor(){
        return this.valor;
    }
    public String getSeller(){
        return this.seller;
    }
    
}
