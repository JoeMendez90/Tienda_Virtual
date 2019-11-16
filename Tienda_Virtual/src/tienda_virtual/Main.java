package tienda_virtual;

import java.util.Scanner;
import javax.swing.JFrame;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // Tienda tienda = new Tienda();
       Archivo ar = new Archivo();
       System.out.println("holis");
       String tex = ar.Copy("C:\\Diego\\Programación\\TiendaVirtual\\TiendaVirtual\\Tienda_Virtual\\Tienda_Virtual\\src\\tienda_virtual\\Prueba.txt");
       System.out.println(tex);
       System.out.println();
       System.out.println(ar.Verificar(tex, "DIEGO", "BULLAHELLO"));
       System.out.println(ar.Verificar(tex, "BULLAHELLO", "w w"));
        
        scan.close();
        
    }
    
}
 