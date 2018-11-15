
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
        //getImage().scale(50,50);
    }

    @Override
    public void act() {
        handleInput();
        Positie();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }
    public boolean onGround() {
        Actor under = getOneObjectAtOffset (0 , getImage().getHeight() / 2, Tile.class);
        return under != null;
    }
    public String Positie()
    {
        String mp = getX() + " " + getY();
        return mp;
        
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && onGround() == true)
        {
            velocityY = -14;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
