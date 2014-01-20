/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;



/**
 *
 * @author trpot5670
 */
abstract class Room extends Scene {
    int level;
    Player player;
    Block[] blocks;
    ArrayList<Block> drawBlocks;
    Block floor;
    private final int PERCENT_BAD;
    private final int LEVEL_CONSTANT = 5;
    public final int SPAWNTIME;
    private int blockNumber;
    private long lastSpawnTime;
    
    Room(int levelNumber){
        level = levelNumber;
        
        SPAWNTIME = 500; //TODO algorithm tweaking
        blocks = new Block[(LEVEL_CONSTANT * level)]; //tweaking here
        drawBlocks = new ArrayList();
        PERCENT_BAD = 70;
        
        initializeBlocks();
        lastSpawnTime = System.currentTimeMillis();
        blockNumber = 0;
        Point p = new Point(this.getWidth()/2, (this.getHeight()/10) + 20);
        player = new Player(p, 50,50,Color.BLACK, 10);
    }
    
    @Override
    public void gameLoop(){
        long timeDiff;
        timeDiff = System.currentTimeMillis() - lastSpawnTime;
        if(timeDiff >= SPAWNTIME){
            spawnBlock(blockNumber);
            blockNumber++;
            log("ran");
            lastSpawnTime = System.currentTimeMillis();
        }
        repaint();
        
    }
    
    private void initializeBlocks(){
        for(int i = 0; i < blocks.length; i++){
            int r = (int)(Math.random()*100); // random whether good or bad
            Point p = new Point((int)(Math.random() * 1000), 0);
            //blocks[i] = new NeutralBlock(new Point(0,500), 50, 1000, Color.WHITE, 10, true);
            if(r < PERCENT_BAD){
                blocks[i] = new EvilBlock(p, 50, 100, 1);//(xpos, ypos, height, width, speed) 
            } else {
                r = (int)(Math.random()*10); // random between the good blocks
                switch(r){
                    default:
                        blocks[i] = new HealthBlock(p, 50, 100, 1);//(xpos, ypos, height, width, speed) 
                        break;
                }
            }
        }
//        for(Block b : blocks){ //check initialization
//            log("" + b);
//        }
        floor = new NeutralBlock(new Point(0, 500), 50, 1000, Color.BLACK, 10, true); //x, y, height, width, color, speed, collision
    }
    
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (true) {  
            gameLoop(); //the game loop
            super.delay(lastTime); //delay, the game pause ("game tick" analogy) 
            lastTime = System.currentTimeMillis();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) { //all drawing done in paint method (DO NOT use "paint(Graphics g)")         
        super.paintComponent(g); // draws everything for the scene
        //stuff for the room
        floor.draw(g2d);
        player.draw(g2d);
        for(Block b:drawBlocks){
            b.draw(g2d);
        }
    }
    
    abstract void spawnBlock(int n);
}
