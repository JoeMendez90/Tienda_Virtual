package tienda_virtual;

import Tienda.Principal;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import java.io.*;

public class Main {

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
 