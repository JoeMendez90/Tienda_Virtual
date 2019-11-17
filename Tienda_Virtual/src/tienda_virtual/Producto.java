package tienda_virtual;

public class Producto {
    private String id;
    private String nombre;
    private String descr;
    private double valor;
    private String seller;
    
    public Producto(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
        this.seller=" ";
        this.id = createID();
    }
    
    public Producto(String nombre, double valor, String seller){
        this.nombre = nombre;
        this.valor = valor;
        this.seller=seller;
        this.descr="";
        this.id = createID();
    }
    
    private String createID(){
        String id = "#1D"; 
        int a,b,a1,b1;
        a= nombre.length()%3;
        a1=nombre.length()/3;
        b= seller.length()%4;
        b1=seller.length()/4;
        
        id= id+seller.substring(b1,b1*2)+nombre.substring(a1, a1*2)+seller.substring(b1*3, b1*4)+nombre.substring(a1*0, a1*1)+seller.substring(b1*0, b1*1)+nombre.substring(a1*2, a1*3)+seller.substring(b1*2, b1*3)+nombre.substring(a1*3,b1*3+a)+seller.substring(b1*4, b1*4+b);
        
        return id;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public Producto(String id, String nombre, String descr, double valor, String seller) {
        this.id = id;
        this.nombre = nombre;
        this.descr = descr;
        this.valor = valor;
        this.seller = seller;
    }

    
    public void setNombre(String nombre){
        this.nombre = nombre;
	this.id = createID();
    }
   
    public void setDesc(String descr){
        this.descr = descr;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    //Getters:

    public String getId() {
        return id;
    }
   
    public String getNombre(){
        return this.nombre;
    }
    public String getDesc(){
        return this.descr;
    }
    public double getValor(){
        return this.valor;
    }
    public String getSeller(){
        return this.seller;
    }
    
}
