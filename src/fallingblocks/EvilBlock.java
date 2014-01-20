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
public class EvilBlock extends Block{
    EvilBlock(Point p, int h, int w, int s){
        super(p, h, w, Color.RED, s);
    }
    
    @Override
    void colliding(Block b){
        
    }
}
