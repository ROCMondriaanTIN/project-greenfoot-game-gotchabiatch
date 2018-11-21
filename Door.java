import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Tile
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Door(String image, int width, int heigth) {
        super(image, width, heigth);
     
            Actor Keys = getOneIntersectingObject(Keys.class);
            if(isTouching(Keys.class))
            {
                setImage("door_openMid");
            }
        
        
    }    
    
    
    
}
