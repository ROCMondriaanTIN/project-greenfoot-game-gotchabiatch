import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroCoin1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroCoin1 extends Mover
{
    /**
     * Act - do whatever the HeroCoin1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 public void act() 
    {
        for (Actor Charactercoin1 : getIntersectingObjects(Hero.class)){
            if(Charactercoin1 != null) {
            getWorld().removeObject(this);
            break;
    }    
    
}
applyVelocity();
}
}


