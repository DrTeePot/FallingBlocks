/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author trpot5670
 */
public class NeutralBlock extends Block {
    /**
     * Creates a block that only collides or does nothing
     * @param h - the height of the block in pixels
     * @param w - the width of the block in pixels
     * @param c - the color of the block as a Color object
     * @param s - the speed of the block in pixels per second
     * @param o - whether or not the object performs collision, boolean
     */
    NeutralBlock(Point p, int h, int w, Color c, int s, boolean o){
        super(p, h, w, Color.BLACK, 1);
        this.setCollision(o);
        
    }
    
    @Override
    void colliding(Block b){
        
    }
}
