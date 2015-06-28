/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BrightDeath;

import javax.swing.JOptionPane;

/**
 *
 * @author nicno90
 */
public class MM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GV.name = JOptionPane.showInputDialog("User Name");
        BrightDeath.startGame(true);
        //http://docs.oracle.com/cd/E40938_01/doc.74/e40142/build_japps.htm#BABBDGIA
        //new MainMenue();
    }
}
