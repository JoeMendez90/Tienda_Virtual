package tienda_virtual;

import Tienda.Principal;
import java.awt.EventQueue;

public class Main {

    /**
    * Launch the application.
    */
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    int ex = 10000;
                    Tienda tienda = new Tienda(ex);
                    Principal frame = new Principal(tienda, ex);
                    frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
}
 