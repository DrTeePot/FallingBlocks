/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import javax.swing.JFrame;

/**
 *
 * @author trpot5670
 */
public class Main extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlFrame frame = new ControlFrame();   
    }
    
    private static void log(String s){
        System.out.println(s);
    }
}
