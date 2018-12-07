import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Door5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door5 extends Tile
{
    /**
     * Act - do whatever the Door5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Door5(String image, int width, int heigth) {
        super(image, width, heigth);
        
        
      
         
    
    
    
}

public void act ()
{
    List <Hero> hero = getWorld().getObjects(Hero.class);
     
        
      if (hero.get(0).keys == 2)
        {
            setImage("door_openMid.png");
            
        }
        
    }
}
