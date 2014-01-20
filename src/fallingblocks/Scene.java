/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author trpot5670
 */
abstract class Scene extends JPanel implements Runnable{
    private final int GAMETICK = 200;
    
    Graphics2D g2d;
    private Thread movement;
    
    
    Scene(){
        setBackground(Color.WHITE);
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        //Make this thread
        movement = new Thread(this);
        movement.start();
    }
    
    public void delay(long lastTime){
        long timeDiff, sleep;
        timeDiff = System.currentTimeMillis() - lastTime;
        sleep = GAMETICK - timeDiff;
        if(sleep <= 0){
            sleep = 2;
        }
        try{
            Thread.sleep(sleep);
        } catch (Exception e){
            System.err.println("interrupted: " + e);
        }
        
    }
    
    abstract void gameLoop();
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d = (Graphics2D) g; //extends old graphics object (gives access to all desired functionality)
        
        g2d.setColor(Color.black); //paint colour
    }
    
    @Override
    public abstract void run();

    void log(String s){
        System.out.println(s);
    }
}
