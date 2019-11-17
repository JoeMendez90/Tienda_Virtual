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
    public void buscarProducto(){
        System.out.println("elija el método de búsqueda: ");
        System.out.println("Ver todos los productos -- 1 \t Buscar por nombre -- 2 \t Buscar por valor -- 3 \t Menú Principal -- 4");
        int n = s.nextInt();
        if (n==1) verTodos();
        if (n==2) buscarNombre();
        if (n==3) buscarValor();
        if (n==4) mainMenu();
    }
    public void verTodos(){
        System.out.println("Index   |   Name    |   Value   ");
        for (int i = 0; i < prod.size() ; i++){
            System.out.println(Integer.toString(i) + "\t\t"+ prod.get(i).getNombre() + "\t\t"+String.valueOf(prod.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)");
        String resp = s.next();
        if (resp.equalsIgnoreCase("s")) addCarrito();
        if (resp.equalsIgnoreCase("n")) System.out.println("Buscar otro producto -- 1 \t Ir al menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) mainMenu();
    }
    public void buscarNombre(){
        System.out.println("¿Que buscas?");
        String str = s.next();
        int count = 0;
        PDinamicArray resultados = new PDinamicArray();
        for (int i = 0; i <prod.size(); i++){
            String n = prod.get(i).getNombre();
            int res = n.indexOf(str);
            if (res != -1){
                resultados.addFront(prod.get(i));
                count++;
            }
        }
        System.out.println("Se encontraron "+Integer.toString(count)+" resultados de búsqueda");
        System.out.println("Index   |   Name    |   Value   ");
        for (int i = 0; i<resultados.size();i++){
            System.out.println(Integer.toString(i)+"\t\t"+resultados.get(i).getNombre()+"\t\t"+String.valueOf(resultados.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)");
        String resp = s.next();
        if (resp.equalsIgnoreCase("s")) addCarrito();
        if (resp.equalsIgnoreCase("n")) System.out.println("Buscar otro producto -- 1 \t Ir al menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) mainMenu();
    }
    public void buscarValor(){
        System.out.println("¿Que buscas?");
        double lukas = s.nextDouble();
        int count = 0;
        PDinamicArray resultados = new PDinamicArray();
        for (int i = 0; i < prod.size(); i++){
            double cost = prod.get(i).getValor();
            if (lukas == cost){
                resultados.addBack(prod.get(i));
                count++;
            }
        }
        System.out.println("Se encontraron "+Integer.toString(count)+" resultados de búsqueda");
        System.out.println("Index   |   Name    |   Value   ");
        for (int i = 0; i<resultados.size();i++){
            System.out.println(Integer.toString(i)+"\t\t"+resultados.get(i).getNombre()+"\t\t"+String.valueOf(resultados.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)");
        String resp = s.next();
        if (resp.equalsIgnoreCase("s")) addCarrito();
        if (resp.equalsIgnoreCase("n")) System.out.println("Buscar otro producto -- 1 \t Ir al menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) mainMenu();
    }
    
    public void addCarrito(){
        /*
        System.out.print("Ingrese el nombre del producto a añadir");
        String p = s.next();
        for (int i = 0; i<prod.size();i++){
            if (p.equalsIgnoreCase(prod.get(i).getNombre())){
                user.aCarrito(prod.get(i));
            }
        }
        System.out.println("Ver mi Carrito -- 1 \t Ir a Búsquedas -- 2 \t Ir a menú principal -- 3");
        int n = s.nextInt();
        if (n==1) miCarrito();
        if (n==2) buscarProducto();
        if (n==3) mainMenu();
        */
    }
    public void miCarrito(){
        /*
        Stack<Producto> replica = user.carrito;
        while(!replica.isEmpty()){
            System.out.println(replica.Peek().key.getNombre()+"\t"+String.valueOf(replica.Peek().key.getValor()) );
            replica.Pop();
        }
        user.carrito.DisplayStack();
         System.out.println("Ir a Búsquedas -- 1 \t Ir a menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) mainMenu();
        */
    }
    public void mainMenu(){
        System.out.println("Buscar Producto -- 1");
        System.out.println("Ver mi Carrito -- 2");
        System.out.println("Salir -- 0");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) miCarrito();
        if (n==0) System.exit(0);
    }/*
    public String makeKey(){
        char[] e = new char[10];
        for (int i = 0; i<10;i++){
            e[i] = (char)((int)(Math.random()*156 + 1));
        }
        String t = new String(e);
        return t;
    }*/ 
    public boolean  vender(String nombre){
        DinamicArray<Producto> pablito = actualUser.productos.DisplayQueue();
        for (int i = 0; i < pablito.tam; i++) {
            if(pablito.get(i).getNombre().equals(nombre)){
                return false;
            }
        }return true;
    }
    public void  vender(String nombre, double value){
        Producto objeto = new Producto(nombre, value, actualUser.username);
        prod.addBack(objeto);
        actualUser.productos.enQueue(objeto);
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
                                                                                                                                           