/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;


/**
 *
 * @author trpot5670
 */
abstract class Block {
    private Point position;
    private Dimension dimensions; //TODO add constructor and declare blocks using dimensions
    
    private int speed;
    
    private Color colour;
    private boolean visible;
    
    private int addDamage;
    private int addHeal; 
    private boolean doesCollide; 
    
    
    /**
     * Constructor: creates an instance of a block.
     * TODO: potentially make this abstract
     * @param h, w, c, s - the height width colour and speed of the block 
     *      in pixels, pixels, 256 colour code, and pixels/tick
     */
    Block(Point p, int h, int w, Color c, int s){
        position = new Point(p);
        dimensions = new Dimension(w, h);
        colour = c;
        log(""+c);
        speed = s;
        doesCollide = true;
        visible = true;
    }
    
    Block(Point p, Dimension d, Color c, int s){
        position = new Point(p);
        dimensions = new Dimension(d);
        colour = c;
        log(""+c);
        speed = s;
    }
    
    Block(){
        dimensions.setSize(50,50);
        colour = Color.BLACK;
        speed = 20;
        doesCollide = true;
        visible = true;
    }
    //TODO add defualt versions of the Block constructor
    //<editor-fold desc="Setter methods">
    /**
     * Sets the height of the block in pixels
     * @param h - the amount of y space the block takes up in pixels
     */
    public void setHeight(int h){
        dimensions.setSize(dimensions.width, h);
    }
    
    /**
     * Sets the width of the block in pixels
     * @param w - the amount of x space the block takes up in pixels
     */
    public void setWidth(int w){
        dimensions.setSize(w, dimensions.height);
    }
    /**
     * Sets the colour of the block as an integer
     * @param c - the integer representing colour
     */
    public void setColour(Color c){
        colour = c;
    }
    
    /**
     * Sets the speed of the block in pixels per game tick
     * @param s 
     */
    public void setSpeed(int s){
        speed = s;
    }
    
    public void setCollision(boolean o){
        doesCollide = o;
    }
    //</editor-fold>
    
    //<editor-fold desc="Getter methods">
    
    /**
     * Returns the position of a block to the client code
     * pre: none
     * post: the position of the block is returned
     * @return height - the position in pixels from the origin at the top left
     */
    public Point getPosition(){
        return(position);
    }
    
    /**
     * Returns the height of a block to the client code
     * pre: none
     * post: the height of the block is returned (the amount of y space in pixels)
     * @return height - the amount of y space the block takes up in pixels
     */
    public int getHeight(){
        return (int)dimensions.getHeight();
    }
    
    /**
     * Returns the width of a block to the client code
     * pre: none
     * post: the width variable is returned
     * @return width - the amount of x space the block takes up in pixels
     */
    public int getWidth(){
        return (int)dimensions.getWidth();
    }
    
    /**
     * Returns the dimensions of a block to the client code
     * pre: none
     * post: the dimensions variable is returned
     * @return width - the amount of x and y space the block takes up in pixels
     */
    public Dimension getDimensions(){
        return dimensions;
    }
    
    /**
     * Returns the colour of the block to the client code
     * pre: none
     * post: the colour of the block is returned
     * @return colour - the colour of the block as a Color object
     */
    public Color getColour(){
        return colour;
    }
    
    /**
     * Returns the falling speed of the block to the client code
     * pre: none
     * post: the speed of the block is returned in pixels per game tick
     * @return speed - the falling speed in pixels per tick
     */
    public int getSpeed(){
        return speed;
    }
    
    /**
     * Returns the damage the block will deal to a player to the client code
     * pre: none
     * post: the damage of the block is returned
     * @return addDamage - the damage of the block as an integer
     */
    public int getDamage(){
        return(addDamage);
    }
    
    /**
     * Returns the health the block will add to a player to the client code
     * pre: none
     * post: the health addition of the block is returned
     * @return addHeal - the heal of the block as an integer
     */
    public int getHeal(){
        return(addHeal);
    }
    
    /**
     * Returns whether a block is solid to the client code
     * pre: none
     * post: the collision of the block is returned
     * @return doesCollide - boolean
     */
    public boolean performsCollision(){
        return(doesCollide);
    }
    //</editor-fold>
    
    public void off(){
        visible = false;
    }
    
    public void on(){
        visible = true;
    }
    
    public boolean isVisible(){
        return(visible);
    }
    
    public void move(){
        position.move(position.x, position.y + speed);
    }
    
    abstract void colliding(Block b);
    
    public void draw(Graphics2D g){
        if(this.isVisible()){
            g.setColor(colour);
            g.fillRect(position.x, position.y, this.getWidth(), this.getHeight());
        }
    }
    
    @Override
    public String toString(){
        return("position: " + position + " | speed: " + speed);
    }
    
    void log(String s){
        System.out.println(s);
    }
}
