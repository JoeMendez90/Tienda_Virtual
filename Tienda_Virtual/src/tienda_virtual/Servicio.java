/*
 * Un servicio también es algo comerciable
 * Un servicio se diferencia de los productos en tanto tiene tiempo de entrega
 * el tiempo de entrega determina la prioridad del servicio
 * =]
 */
package tienda_virtual;

public class Servicio {
    /*
     * Tstandar: el tiempo estandar que tarda el servicio en cumplirse
     * name: nombre del servicio
     * cumplido: determina si ya se cumplió el servicio
     * seller: el que ofrece el servicio
     * valor: el precio: 
    */
    private int Tstandar;
    private int valor;
    private String name;
    private String seller;
    private String desc;
    private boolean cumplido;

    public Servicio(int Tstandar, int valor, String name) {
        setTstandar(Tstandar);
        setValor(valor);
        setName(name);
    }
    
    public Servicio(int Tstandar, int valor, String name, String seller){
        this(Tstandar, valor, name);
        setSeller(seller);
    }
    public Servicio(int Tstandar, int valor, String name, String seller, String desc){
        this(Tstandar, valor, name, seller);
        setDesc(desc);
    }
    
    public int getTstandar() {
        return Tstandar;
    }

    public void setTstandar(int Tstandar) {
        this.Tstandar = Tstandar;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }
    
}
