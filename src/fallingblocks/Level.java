/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

/**
 *
 * @author trpot5670
 */
public class Level extends Room{
    Level(int level){
        super(level);
    }

    @Override
    void spawnBlock(int n){
        super.drawBlocks.add(blocks[n]);
    }
}
