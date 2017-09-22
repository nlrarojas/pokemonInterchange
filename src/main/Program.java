package main;

import util.IConstants;
import view.PrincipalWindow;

/**
 *
 * @author Nelson
 */
public class Program implements IConstants{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalWindow().setVisible(true);                
            }
        });
    }
}
