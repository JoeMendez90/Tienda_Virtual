/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *  esta clase es un JDialog que sirve para confirmar si va a realizar o no determinada accion
 * @author Team
 */
public class JSure extends JDialog {
    
    private JPanel contentPane;
    public boolean sure;
    
    
    public JSure(JFrame principal,boolean mode){
        super(principal,mode);
        CreateDialog();
    }
    
public JSure() {		
        CreateDialog();
    }
    private void CreateDialog() {
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sure=false;
            setBounds(100, 100, 200, 250);
            setLocationRelativeTo(null);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblVirtualShop = new JLabel();
            lblVirtualShop.setBounds(25, 10, 150, 50);
            lblVirtualShop.setIcon(Principal.createIcon("/Images/Logotipo.png", 150, 50));
            contentPane.add(lblVirtualShop);
            JLabel sures = new JLabel("esta usted seguro?");
            sures.setBounds(40, 40, 424, 82);
            contentPane.add(sures);

            JButton btnNewButton = new JButton("Aceptar");
            btnNewButton.setBounds(40, 100, 100, 40);

            btnNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sure=true;
                    dispose();
                }
            });

            contentPane.add(btnNewButton);
            JButton btnNewButton2 = new JButton("Cancelar");
            btnNewButton2.setBounds(40, 150, 100, 40);

            btnNewButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sure=false;
                    dispose();
                }
            });

            contentPane.add(btnNewButton2);
    }

}
