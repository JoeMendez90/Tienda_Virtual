import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Tienda{
    PDinamicArray prod;
    Archivo m;
    Usuario user;
    Scanner s;
    
    public Tienda(){
        s = new Scanner(System.in);
        m = new Archivo();
        login();
        genLista();
        mainMenu();
        s.close();
    }
    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Se iniciará sesión una vez creada su cuenta");
        System.out.println("Crear Cuenta ---- 1");
        int n = s.nextInt();
        switch(n){
            case 1:
                System.out.print("Username: ");
                String name = s.next();
                System.out.print("Password: ");
                String clave = s.next();
                m.Escribir("UserData.txt", name + "\t" + clave + "\n");
                user = new Usuario(name, clave);
                break;
        }
    }
    public void genLista(){
        System.out.print(user.getUsername()+", ingresa la cantidad de productos a mostrar?: ");
        int n = s.nextInt();
        System.out.println("Desplegando " + Integer.toString(n) + " productos");
        prod = new PDinamicArray();
        for (int i = 0; i<n; i++){
            Producto ucto = new Producto(Integer.toString(i), i*100);
            prod.add(ucto);
        }
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
        for (int i = 0; i < prod.getSize() ; i++){
            System.out.println(Integer.toString(i) + "\t\t"+ prod.get(i).getNombre() + "\t\t"+String.valueOf(prod.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)")
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
        for (int i = 0; i <prod.getSize(); i++){
            String n = prod.get(i).getNombre();
            int res = n.indexOf(str);
            if (res != -1){
                resultados.add(prod.get(i));
                count++;
            }
        }
        System.out.println("Se encontraron "+Integer.toString(count)+" resultados de búsqueda");
        System.out.println("Index   |   Name    |   Value   ");
        for (int i = 0; i<resultados.getSize();i++){
            System.out.println(Integer.toString(i)+"\t\t"+resultados.get(i).getNombre()+"\t\t"+String.valueOf(resultados.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)")
        String resp = s.next();
        if (resp.equalsIgnoreCase("s")) addCarrito();
        if (resp.equalsIgnoreCase("n")) System.out.println("Buscar otro producto -- 1 \t Ir al menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) maiMenu();
    }
    public void buscarValor(){
        System.out.println("¿Que buscas?");
        double lukas = s.nextDouble();
        int count = 0;
        PDinamicArray resultados = new PDinamicArray();
        for (int i = 0; i < prod.getSize(); i++){
            double cost = prod.get(i).getValor();
            if (lukas == cost){
                resultados.add(prod.get(i));
                count++;
            }
        }
        System.out.println("Se encontraron "+Integer.toString(count)+" resultados de búsqueda");
        System.out.println("Index   |   Name    |   Value   ");
        for (int i = 0; i<resultados.getSize();i++){
            System.out.println(Integer.toString(i)+"\t\t"+resultados.get(i).getNombre()+"\t\t"+String.valueOf(resultados.get(i).getValor()));
        }
        System.out.print("¿Quiere añadir algo al carrito? (s/n)")
        String resp = s.next();
        if (resp.equalsIgnoreCase("s")) addCarrito();
        if (resp.equalsIgnoreCase("n")) System.out.println("Buscar otro producto -- 1 \t Ir al menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) maiMenu();
    }
    public void addCarrito(){
        System.out.print("Ingrese el nombre del producto a añadir");
        String p = s.next();
        for (int i = 0; i<prod.getSize();i++){
            if (p.equalsIgnoreCase(prod.get(i).getNombre())){
                user.aCarrito(prod.get(i));
            }
        }
        System.out.println("Ver mi Carrito -- 1 \t Ir a Búsquedas -- 2 \t Ir a menú principal -- 3");
        int n = s.nextInt();
        if (n==1) miCarrito();
        if (n==2) buscarProducto();
        if (n==3) mainMenu();
    }
    public void miCarrito(){
        
        Stack<Producto> replica = user.carrito;
        while(!replica.isEmpty()){
            System.out.println(replica.Peek().getNombre()+"\t"+String.valueOf(replica.Peek().getValor()) );
            replica.Pop();
        }
        user.carrito.DisplayStack();
         System.out.println("Ir a Búsquedas -- 1 \t Ir a menú principal -- 2");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) mainMenu();
    }
    public void mainMenu(){
        System.out.println("Buscar Producto -- 1");
        System.out.println("Ver mi Carrito -- 2");
        System.out.println("Salir -- 0");
        int n = s.nextInt();
        if (n==1) buscarProducto();
        if (n==2) miCarrito();
        if (n==0) System.exit(0);
    }
}
                                                                                                                                           