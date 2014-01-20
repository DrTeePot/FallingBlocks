/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author trpot5670
 */
public class ControlFrame extends JFrame{
    private int levelNumber = 1;
    private int score;
    private final static int LEVELMAX = 10;
    
    ControlFrame(){        
        //build the window        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Falling Blocks");
        this.setContentPane(levelController());
        
        
        setResizable(false);
        setVisible(true);
    }

    private JPanel levelController() {
        Room currentRoom;
        if(levelNumber < LEVELMAX){
            if(levelNumber%5 == 0){ //every 5 levels make a bonus room
                currentRoom = new BonusRoom();
                log("bonus: " + levelNumber);
            }else{
                currentRoom = new Level(levelNumber);
                log("level: " + levelNumber);
            }
            incrimentRoom();        
        } else {
             //TODO winning screen
            currentRoom = new BonusRoom();
        }
        return(currentRoom);
        
    }
    
    public void incrimentRoom(){
        levelNumber++;
    }
    
    private static void log(String s){
        System.out.println(s);
    }
}
