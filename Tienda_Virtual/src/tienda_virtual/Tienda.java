package tienda_virtual;

public class Tienda{
    public String TiendName;
    public DinamicArray<Producto> prod;
    public DinamicArray<Usuario> users; 
    public Usuario actualUser;
    
    public Tienda(int ex){
        TiendName = "ValhasTim";
        prod = LectoUpdater.initProd(ex);
        users = LectoUpdater.initUser(ex,prod);
        actualUser = new Usuario();
    }
    
    public DinamicArray<Producto> genLista(int cantGen, int indexIn){
        DinamicArray<Producto> prod1 = new DinamicArray<>();
        for (int i = 0; i<cantGen; i++){
            prod1.addBack(this.prod.get(indexIn+i));
        }
        return prod1;
    }
    
    /**
     * primer tipo de busqueda, para productos
     * retorna todos los productos que poseen esa palabra dentro, o una de las palabras que contiene
     * @param search palabra o palabras a buscar
     * @return productos encontrados
     */
    
    public DinamicArray<Producto> BuscarProd(String search){
        search = search.trim();
        DinamicArray<Producto> prod1 = new DinamicArray<>();
        DinamicArray<Producto> not1 = new DinamicArray<>();
        if(search.equals("")){
            return prod;
        }
        
        for(int i=0; i<prod.tam;i++){
            if(prod.get(i).getNombre().contains(search)){
                prod1.addBack(prod.get(i));
            }else{
                not1.addBack(prod.get(i));
            }
        }
        
        String[] palabras = search.split(" ");
        
        if(palabras.length<=1){
            return prod1;
        }
        
        String newSearch="";
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 1; j < palabras.length-1; j++) {
                if(palabras[i].equals("")){
                    break;
                }
                
                if(i!=j){
                    if(palabras[i].equals(palabras[j])){
                        // eliminamos su valor
                        palabras[j]="";
                    }
                }
            }
            if(!palabras[i].equals("")){
                newSearch+=" "+palabras[i];
            }
        }
        
        newSearch = newSearch.trim();
        
        palabras = newSearch.split(" ");
        
            for (int j = 0; j < palabras.length; j++) {
                DinamicArray<Producto> prod2 = BusquedaIndList(palabras[j],not1);
                for (int i = 0; i < prod2.tam; i++) {
                    prod1.addBack(prod2.get(i));
                }
            }
        
        return prod1;
    }
    
    /**
     * primer tipo de busqueda, para usuarios
     * retorna todos los usuarios que poseen ese nombre dentro, o una de las palabras que contiene
     * @param search palabra o palabras a buscar
     * @return productos encontrados
     */
    
    public DinamicArray<Producto> BuscarUsers(String search){
        search = search.trim();
        DinamicArray<Producto> prod1 = new DinamicArray<>();
        DinamicArray<Producto> not1 = new DinamicArray<>();
        if(search.equals("")){
            return prod;
        }
        
        for(int i=0; i<prod.tam;i++){
            if(prod.get(i).getNombre().contains(search)){
                prod1.addBack(prod.get(i));
            }else{
                not1.addBack(prod.get(i));
            }
        }
        
        String[] palabras = search.split(" ");
        if(palabras.length>1){
            for (int j = 0; j < palabras.length; j++) {
                DinamicArray<Producto> prod2 = BusquedaIndList(palabras[j],not1);
                for (int i = 0; i < prod2.tam; i++) {
                    prod1.addBack(prod2.get(i));
                }
            }
        }
        
        return prod1;
    }
    
    
    /**
     * busca una palabra dentro de una lista dada, y lo que encuentra lo va sacando
     * @param word
     * @param list
     * @return 
     */
    
    private DinamicArray<Producto> BusquedaIndList(String word,DinamicArray<Producto> list){
        DinamicArray<Producto> prod1 = new DinamicArray<>();
        for(int i=0; i<list.tam;i++){
            if(list.get(i).getNombre().contains(word)){
                prod1.addBack(list.get(i));
                list.delete(i);
            }
        }
        
        return prod1;
    }
    
    
    
    /*
    public String makeKey(){
        char[] e = new char[10];
        for (int i = 0; i<10;i++){
            e[i] = (char)((int)(Math.random()*156 + 1));
        }
        String t = new String(e);
        return t;
    }*/ 
    
    public boolean Acceder(String nombre,String contrasena){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        
        System.out.println("confirmame");
        
        boolean result =false;
        for (int i = 0; i < users.tam; i++) {
            if(users.get(i).getUsername().equals(nombre)){
                if(users.get(i).itsPassword(contrasena)){
                    result=true;
                    Carrito carr= actualUser.getCarrito();
                    actualUser = users.get(i);
                    actualUser.setCarrito(carr);
                    break;
                }
            }
        }

        TFin = System.currentTimeMillis();
        LectoUpdater.getTime(TFin - TInicio,"Acceder a Cuenta");
        return result;
    }
    
    public boolean  vender(String id){
        DinamicArray<String> pablito = actualUser.productos;
        for (int i = 0; i < pablito.tam; i++) {
            if(pablito.get(i).equals(id)){
                return false;
            }
        }return true;
    }
    public void  vender(String nombre, double value){
        Producto objeto = new Producto(nombre, value, actualUser.username);
        prod.addBack(objeto);
        actualUser.productos.addBack(objeto.getId());
        LectoUpdater.anadirProducto(objeto, actualUser);
    }
    public Carrito sintetizar(String codigo, String carname){
        int n = (int)(codigo.length()/5);
        String[] separar = new String[n];
        int x = 5;
        Carrito car = new Carrito(carname);
        for (int i = 0; i<n ;i++){
            separar[i] = codigo.substring(i*5, (i+1)*5);
        }
        int c = 0;
        for(int i = 0; i<n; i++){
            for (int j = 0; j<prod.size();j++){
                if(prod.get(j).getId().equals(separar[i])){
                    car.agregar(prod.get(j));
                    c++;
                }
            }
        }
        
        return car;
    }

    /**
     * enlista los productos del usuario actual
     * @return productos del usuario actual
     */
    
    public DinamicArray<Producto> actualsProducts() {
        DinamicArray<Producto> productos =  new DinamicArray<>();
        
        for(int i = 0; i< actualUser.productos.tam;i++){
            System.out.println("hey hey hey hey");
            for(int j=0; j < prod.tam;j++){
                System.out.println(prod.get(j).getId() +" habia una "+ actualUser.productos.get(i));
                if(prod.get(j).getId().equals(actualUser.productos.get(i))){
                    productos.addBack(prod.get(j));
                    System.out.println("heyheyheyhey");
                    break;
                }
            }
        }
        System.out.println(productos.tam+ "probando"+actualUser.productos.tam);
        return productos;
    }
    
    /**
     * realiza una busqueda del usuario por medio del nombre, y devuelve su indice en lista, 
     * esta funcion tambien es util para saber si ese nombre existe
     * @param userName nombre buscado
     * @return index del usuario en lista
     */
    
    public int UserSearch(String userName){
        int index = -1;
        for (int i = 0; i < users.tam; i++) {
            if(users.get(i).getUsername().equals(userName));{
                index=i;
                break;
            }
        }
        return index;
    }
}
                                                                                                                                           