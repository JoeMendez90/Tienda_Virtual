package tienda_virtual;

import java.util.*;

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
    public DinamicArray<Producto> Buscar(String search){
        DinamicArray<Producto> prod1 = new DinamicArray<>();
        if(search.equals("")){
            return prod;
        }
        for(int i=prod.tam-1; i>=0;i--){
            if(prod.get(i).getNombre().contains(search)){
                prod1.addFront(prod.get(i));
            }else if(prod.get(i).getSeller().contains(search)){
                prod1.addBack(prod.get(i));
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
    public boolean  vender(String id){
        DinamicArray<String> pablito = actualUser.productos.DisplayQueue();
        for (int i = 0; i < pablito.tam; i++) {
            if(pablito.get(i).equals(id)){
                return false;
            }
        }return true;
    }
    public void  vender(String nombre, double value){
        Producto objeto = new Producto(nombre, value, actualUser.username);
        prod.addBack(objeto);
        actualUser.productos.enQueue(objeto.getId());
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
}
                                                                                                                                           