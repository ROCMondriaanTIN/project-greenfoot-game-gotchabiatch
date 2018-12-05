import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Mover
{
    int Teller;
    static int Nummer;
    private int Nummer2;
    public Platform()
    {
        getImage().mirrorVertically();
       
    }
    
    public void act() 
    {
        PLbewegen();
        for(Mover mover: getIntersectingObjects(Mover.class)) {
            if(mover != null){
                mover.velocityX = velocityX;
                mover.velocityY = velocityY;
            }
        }
        applyVelocity();
    }    
    
    public void PLbewegen()
    {
        if(Teller == 0)
        {
            //setLocation(getX()-2,getY()+4);
            velocityX = 2;
            velocityY = -2;
        }
        //naar boven
        
         if(Teller == 100)
        {
            velocityX = 0;
            velocityY = 0;   
        }
        //wacht
        if(Teller == 100)
        {
            //setLocation(getX()+2,getY()-4 );
            velocityX = -2;
            velocityY = 2;
        }
        // naar beneden
       
        if(Teller == 156)
        {
            velocityX = 0;
            velocityY = 0;   
        }
        //wacht
        if(Teller >= 400) {
            Teller = 0;
            return;
        }
        Teller ++;
       
    }

}
