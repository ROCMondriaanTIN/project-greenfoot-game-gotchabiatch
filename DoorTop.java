
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 302323979
 */
public class DoorTop extends Tile {
   
    public DoorTop(String image, int width, int heigth) {
        super(image, width, heigth);
    }    
    
    public void act ()
{
    List <Hero> hero = getWorld().getObjects(Hero.class);
     
        
      if (hero.get(0).key)
        {
            setImage("door_openTop.png");
            
        }
        
    }
}

