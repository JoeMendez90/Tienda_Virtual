package tienda_virtual;

import java.io.*;
import javax.swing.JOptionPane;
public class Archivo {
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr;
    public void Crear(String nombre){
        File f = new File(nombre);
    }
    public Archivo(){
        
    }
    
    public void Escribir(String a, String algo){
        try {
            w = new FileWriter(a,true);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
            wr.write(algo);
            wr.close();
            bw.close(); 
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, F. " + e.getMessage());
        }
        
    }
}
