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
    
    public static boolean Acceder(String nombre,String contrasena,Tienda tienda,int ex){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        
        boolean result =false;
        
        FileReader fr = null;
        BufferedReader br;
        
         
         
         try
        {
            fr = new FileReader(new File("src/txt/PWORD"+ex+".txt"));
            br = new BufferedReader(fr);
            
            String linea;
            while((linea=br.readLine())!=null){
                String []  palabras = linea.split(Pattern.quote("|"));
                if(palabras[0].equals(nombre)){
                    if(palabras[1].equals(contrasena)){
                        result=true;
                        Carrito carr= tienda.actualUser.getCarrito();
                        int a=-1;
                        for (int i = 0; i < tienda.users.tam; i++) {
                            
                        }
                        
                        //tienda.actualUser= ;
                            
                    }

                   // tienda.actualUser.setProductos(product);

                }
            }

            /*
                try{
                    ar = new File(ruta);
                    fr = new FileReader(ar);
                    br = new BufferedReader(fr);

                    while (br.readLine() != null){
                        text = text + br.readLine();
                    }
                } catch (Exception error){
                    error.printStackTrace();
                }finally{
                    try{                    
                        if(null != fr){   
                            fr.close();     
                        }                  
                    }catch (Exception otro_error){ 
                        otro_error.printStackTrace();
                    }
                }
                boolean t = false;
                int ini = 0;
                int end = 0;
                String base = "";
                for (int i = 0; i<texto.length()-a.length();i+=a.length()){
                    if(texto.substring(i,i+a.length()).equals(a)){
                        for (int j = i+1; j<texto.length()-b.length();j++){
                            if (texto.substring(j,j+b.length()).equals(b)){
                                t = true;
                                break;
                            }
                        }
                    }
                }
            */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fr)
              fr.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        String linea = nombre+"|"+nombre+"|0|";
        String[] dats = linea.split(Pattern.quote("|"));
        Carrito carr = tienda.actualUser.getCarrito();
        tienda.actualUser = new Usuario(dats[0], dats[1], carr);
        for(int i=0; i<Integer.valueOf(dats[2]);i++){
            /*tienda.prod.
            tienda.actualUser.getProductos().enQueue(new Pro);*/
        }
        //tienda.actualUser.
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Crear Cuenta");
        return true;
    }
    
    public static void EliminarCuenta(Tienda tienda, int ex){
        long TInicio, TFin;
        TInicio = System.currentTimeMillis();
        EliminarProductos(tienda,ex);
        Queue<String> Users = new Queue<>();
        Queue<String> Pword = new Queue<>();
        File User = null;
        FileReader ReadUser = null;
        File word = null;
        FileReader Readword = null;
        try {
           User = new File ("src/txt/Users"+ex+".txt");
           word = new File ("src/txt/PWORD"+ex+".txt");
           ReadUser= new FileReader (User);
           Readword= new FileReader (word);
           BufferedReader ReaderUser = new BufferedReader(ReadUser);
           BufferedReader ReaderWord = new BufferedReader(Readword);
           
           String linea;
           while((linea=ReaderWord.readLine())!=null){
                String []  palabras = linea.split(Pattern.quote("|"));
                if(!palabras[0].equals(tienda.actualUser.getUsername())){
                    Pword.enQueue(linea);
                }
           }
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
              if( null != Readword ){   
                 Readword.close();     
              } 
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        FileWriter WUser = null;
        PrintWriter WriterUser = null;
        FileWriter WWord = null;
        PrintWriter WriterWord = null;
        try
        {
            boolean delete = User.delete();
            if(delete){
                User.createNewFile();
            }
            boolean delete2 = word.delete();
            if(delete2){
                word.createNewFile();
            }
            
            WUser = new FileWriter(User);
            WriterUser = new PrintWriter(WUser);
            WWord = new FileWriter(word);
            WriterWord = new PrintWriter(WWord);

            while(!Users.isEmpty()){
                WriterUser.println(Users.Peek());
                Users.deQueue();
            }
            while(!Pword.isEmpty()){
                WriterWord.println(Pword.Peek());
                Pword.deQueue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != WUser){
                   WUser.close();
                }
                
                if (null != WWord){
                   WWord.close();
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
    
    public static int CrearCuenta(String nombre,String contrasena,String contrasena2,int ex){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        if(!contrasena.equals(contrasena2)){
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
        if(var!=1){
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
        return 1;
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
           
           String linea;
           while((linea=ReaderProd.readLine())!=null){
                String[]  palabras = linea.split(Pattern.quote("|"));
                prod.addBack(new Producto(palabras[0], palabras[1], palabras[2], Double.valueOf(palabras[3]), palabras[4]));
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
                users.addBack(new Usuario(palabras[0], palabras[1]));
                Queue<Producto> prod = new Queue<>();
                for (int i = 0; i < Integer.valueOf(palabras[2]); i++) {
                  for(int j=0 ; j < productos.tam; j++){
                      if(productos.get(j).getId().equals(palabras[3+i])){
                          prod.enQueue(productos.get(j));
                          break;
                      }
                  }
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

    
    public static void main(String[] args)
    {
        /*
        File oldfile = new File("src/txt/prueba65.txt");
        File newfile = new File("src/txt/prueba.txt");
        if (newfile.renameTo(oldfile)) {
            System.out.println("archivo renombrado");
        } else {
            System.out.println("error");
        }*/
    
        /*Queue<String> hey = new Queue<>();
        hey.enQueue("nombre");
        hey.enQueue("nombre");
        boolean set = false;
        
        System.out.println("Listo");
        
        
        /*
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/txt/prueba.txt",true);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i+"0");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }*/
    }

    private static void EliminarProductos(Tienda tienda,int ex) {
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        while(!tienda.actualUser.getProductos().isEmpty()){
            Producto eliminable = tienda.actualUser.getProductos().Peek();
            tienda.actualUser.getProductos().deQueue();
            sacarTProducto(eliminable, tienda);
            EliminarProducto(eliminable.getNombre(),ex);
        }
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"Eliminar Productos");
    }
    
    private static void sacarTProducto(Producto producto, Tienda tienda){
        long TInicio, TFin; 
        TInicio = System.currentTimeMillis();
        int ubicacion=-1;
        for(int i=0; i< tienda.prod.size();i++){
            if(tienda.prod.get(i).equals(producto)){
                ubicacion=i;
            }
        }
        if(ubicacion!=-1){
            tienda.prod.delete(ubicacion);
        }
        TFin = System.currentTimeMillis();
        getTime(TFin - TInicio,"sacar producto de la tienda");
    }
    
    private static void EliminarProducto(String producto,int ex){
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
                if(!palabras[0].equals(producto)){
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
