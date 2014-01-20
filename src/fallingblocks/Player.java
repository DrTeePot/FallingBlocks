/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author trpot5670
 */
public class Player extends Block{
    
    Player(Point p, int h, int w, Color c, int s){
        super(p, h, w, Color.BLUE, s);
    }
    
    @Override
    public void colliding(Block b){
        if(b.isVisible()){
            if(b.performsCollision()){
                //TODO bounce?
            }
            if(b.getDamage() > 0){

            }
            if(b.getHeal() > 0){

            }
            b.off();
        }
    }
    
//    @Override
//    public void draw(Graphics2D g){
//        if(this.isVisible()){
//            g.fillRect(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
//        }
//    }
}
