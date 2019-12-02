package Tienda;
import tienda_virtual.ReturnAction;
import tienda_virtual.Stack;
import tienda_virtual.Tienda;
import tienda_virtual.Producto;
import tienda_virtual.DinamicArray;
import java.awt.*;
import javax.swing.*;
import tienda_virtual.LectoUpdater;

public class MenuProductos extends JFrame{
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    String hey = "1234";
                                    String[] palabras = hey.split(" ");
                                    
                                    for (int i = 0; i < palabras.length; i++) {
                                        System.out.print(palabras[i]+" | ");
                                    }
					MenuProductos frame = new MenuProductos(LectoUpdater.initProd(10000));
                                        frame.setVisible(true);
                                        JSure sure = new JSure(frame, true);
                                        sure.setVisible(true);
                                        System.out.println(sure.sure);
                                        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public MenuProductos(DinamicArray<Producto> p){
        setBounds(0,0,500,500);
        iniciar(p);
    }
    private void iniciar(DinamicArray<Producto> p){
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
       
        JScrollPane barra = new JScrollPane();
        this.getContentPane().add(barra);
        //panel.add(barra);
        barra.setBackground(Color.BLACK);
        //barra.add(panel);
        //this.getContentPane().add(barra);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        int j = 0;
        for (int i = 0; i<p.size(); i++){
            JLabel etiqueta = new JLabel(p.get(i).getNombre()+"\t"+ (p.get(i).getValor()+"")+ "\t" + p.get(i).getDesc()+ "\t" );
           
            etiqueta.setBounds(100,j,100,100);
            etiqueta.setForeground(Color.WHITE);
            //barra.add(etiqueta);
            panel.add(etiqueta);
            j+=20;
        }
    }
}
