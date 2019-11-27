/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 *
 * @author fanat
 */
public class LectoUpdater {
    
    public static void EliminarCuenta(Tienda tienda, int ex){
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        EliminarProductos(tienda,ex);
        Queue<String> Users = new Queue<>();
        File User = null;
        FileReader ReadUser = null;
        try {
           User = new File ("src/txt/Users"+ex+".txt");
           ReadUser= new FileReader (User);
           BufferedReader ReaderUser = new BufferedReader(ReadUser);
           
           String linea;

           while((linea=ReaderUser.readLine())!=null){
                String []  palabras = linea.split(Pattern.quote("|"));
                if(!palabras[0].equals(tienda.actualUser.getUsername())){
                    Users.enQueue(linea);
                }
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != ReadUser ){   
                 ReadUser.close();     
              }  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        FileWriter WUser = null;
        PrintWriter WriterUser = null;
        try
        {
            boolean delete = User.delete();
            if(delete){
                User.createNewFile();
            }
            
            WUser = new FileWriter(User);
            WriterUser = new PrintWriter(WUser);

            while(!Users.isEmpty()){
                WriterUser.println(Users.Peek());
                Users.deQueue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != WUser){
                   WUser.close();
                }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Eliminar Cuenta");
    }
    
    public static void getTime(long tiempo, String action){
        System.out.print("Para "+action+" ");
        if(tiempo<1000){
            System.out.println("el tiempo de ejecución en milisegundos: " + tiempo);
        }else{
            tiempo /= 1000.0;
            if(tiempo<60){
                System.out.println("el tiempo fue: "+ tiempo+ " segundos.");
            }else{
                int minutos=0;
                double segundos=0;
                long hour=0;
                while(tiempo>=3600){
                    hour++;
                    tiempo-=3600;
                }
                while(tiempo>=60){
                    minutos++;
                    tiempo-=60;
                }
                System.out.println("el tiempo fue: "+hour+" horas, "+minutos+" minutos, "+segundos+" segundos.");
            }
        }
    }
    
    public static int CrearCuenta(String nombre,String contrasena,String contrasena2,Tienda tienda,int ex){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        if(!contrasena.equals(contrasena2)){
            TFin = System.currentTimeMillis();
            getTime(TFin - TInicio,"Crear Cuenta");
            return -1;
        }
        int var=0;
        File word;
        FileReader Readword = null;
        try {
           word = new File ("src/txt/PWORD"+ex+".txt");
           Readword= new FileReader (word);
           BufferedReader ReaderWord = new BufferedReader(Readword);
           
           String linea;
           while((linea=ReaderWord.readLine())!=null){
                String []  palabras = linea.split(Pattern.quote("|"));
                if(palabras[0].equals(nombre)){
                    var=1;
                    break;
                }
           }
        }
        catch(IOException e){
            System.out.println(e);
        }finally{
           try{                    
              if( null != Readword ){   
                 Readword.close();     
              } 
           }catch (IOException e2){ 
              System.out.println(e2);
           }
        }
        if(var==1){
            TFin = System.currentTimeMillis();
            getTime(TFin - TInicio,"Crear Cuenta");
            return var;
        }
        FileWriter fichero1 = null;
        PrintWriter pw1;
        FileWriter fichero2 = null;
        PrintWriter pw2;
        try
        {
            fichero1 = new FileWriter("src/txt/PWORD"+ex+".txt",true);
            pw1 = new PrintWriter(fichero1);
            fichero2 = new FileWriter("src/txt/Users"+ex+".txt",true);
            pw2 = new PrintWriter(fichero2);
            pw1.println(nombre+"|"+contrasena);
            pw2.println(nombre+"| |0|");
                
            tienda.users.addBack(new Usuario(nombre));
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero1){
              fichero1.close();
           } 
           if (null != fichero2){
              fichero2.close();
           }
           }catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Crear Cuenta");
        return var;
    }
    
    public static DinamicArray<Producto> initProd(int ex){
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        DinamicArray<Producto> prod = new DinamicArray<>();
        
        File Products = null;
        FileReader ReadProd = null;
        try {
           Products = new File ("src/txt/Products"+ex+".txt");
           ReadProd= new FileReader (Products);
           BufferedReader ReaderProd = new BufferedReader(ReadProd);
           int i=0;
           String linea;
           while((linea=ReaderProd.readLine())!=null){
                String[]  palabras = linea.split(Pattern.quote("|"));
                prod.addBack(new Producto(palabras[0], palabras[1], palabras[2], Double.valueOf(palabras[3]), palabras[4]));
                i++;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != ReadProd ){   
                 ReadProd.close();     
              } 
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Iniciar Productos");
        return prod;
    }
    
    public static DinamicArray<Usuario> initUser(int ex, DinamicArray<Producto> productos){
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        DinamicArray<Usuario> users = new DinamicArray<>();
        
        File Users;
        FileReader ReadUsers = null;
        try {
           Users = new File ("src/txt/Users"+ex+".txt");
           ReadUsers= new FileReader (Users);
           BufferedReader ReaderUsers = new BufferedReader(ReadUsers);
           int us=0;
           String linea;
           while((linea=ReaderUsers.readLine())!=null){
                String[]  palabras = linea.split(Pattern.quote("|"));
                users.addBack(new Usuario(palabras[0], palabras[1],palabras[2]));
                DinamicArray<String> prod = new DinamicArray<>();
                for (int i = 0; i < Integer.valueOf(palabras[3]); i++) {
                    prod.addBack(palabras[3+i]);
                }
                users.get(us).setProductos(prod);
                us++;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != ReadUsers ){   
                 ReadUsers.close();     
              } 
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Iniciar Usuarios");
        return users;
    }

    private static void EliminarProductos(Tienda tienda,int ex) {
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        for (int i = tienda.actualUser.productos.tam-1; i>=0; i--) {
            for(int j =0 ; j<tienda.prod.tam;j++){
                if(tienda.prod.get(j).getId().equals(tienda.actualUser.productos.get(i))){
                    tienda.prod.delete(j);
                    break;
                }
            }
        }
        tienda.actualUser.productos = null;
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Eliminar Productos");
    }
    
    private static void sacarTProducto(String producto, Tienda tienda){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        int ubicacion=-1;
        for(int i=0; i< tienda.prod.size();i++){
            if(tienda.prod.get(i).getId().equals(producto)){
                ubicacion=i;
            }
        }
        if(ubicacion!=-1){
            tienda.prod.delete(ubicacion);
        }
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"sacar producto de la tienda");
    }
    
    private static void EliminarProducto(String Id,int ex){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        
        Queue<String> Product = new Queue<>();
        File Products = null;
        FileReader ReadProduct = null;
        try {
           Products = new File ("src/txt/Products"+ex+".txt");
           ReadProduct= new FileReader (Products);
           BufferedReader ReaderProd = new BufferedReader(ReadProduct);
           
           String linea;
           while((linea=ReaderProd.readLine())!=null){
                String []  palabras = linea.split(Pattern.quote("|"));
                if(!palabras[0].equals(Id)){
                    Product.enQueue(linea);
                }
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != ReadProduct ){   
                 ReadProduct.close();     
              }  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        FileWriter WProduct = null;
        PrintWriter WriterProd = null;
        try
        {
            boolean delete = Products.delete();
            if(delete){
                Products.createNewFile();
            }            
            WProduct = new FileWriter(Products);
            WriterProd = new PrintWriter(WProduct);

            while(!Product.isEmpty()){
                WriterProd.println(Product.Peek());
                Product.deQueue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != WProduct){
                   WProduct.close();
                }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"sacar producto de la tienda");
    }
    /*
    public static void EliminarProducto(Producto producto, Tienda tienda){
        
    }*/

    static void anadirProducto(Producto objeto, Usuario actualUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
