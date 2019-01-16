
import greenfoot.*;
import java.*;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private final GreenfootImage RMidle= new GreenfootImage("p123.png");
    private final GreenfootImage RMjump= new GreenfootImage("p1_jump.png");
    private final GreenfootImage RMwalk1= new GreenfootImage("p1_walk01.png");
    private final GreenfootImage RMwalk2= new GreenfootImage("p1_walk02.png");
    private final GreenfootImage RMwalk3= new GreenfootImage("p1_walk03.png");
    private final GreenfootImage RMwalk4= new GreenfootImage("p1_walk04.png");
    private final GreenfootImage RMwalk5= new GreenfootImage("p1_walk05.png");
    private final GreenfootImage RMwalk6= new GreenfootImage("p1_walk06.png");
    private final GreenfootImage RMwalk7= new GreenfootImage("p1_walk07.png");
    private final GreenfootImage RMwalk8= new GreenfootImage("p1_walk08.png");
    private final GreenfootImage RMwalk9= new GreenfootImage("p1_walk09.png");
    private final GreenfootImage RMwalk10= new GreenfootImage("p1_walk10.png");
    private final GreenfootImage RMwalk11= new GreenfootImage("p1_walk11.png");
 
    private final GreenfootImage LMidle = new GreenfootImage("p123inv.png");
    private final GreenfootImage LMjump = new GreenfootImage(RMjump);
    private final GreenfootImage LMwalk1 = new GreenfootImage("p1_walk01inv.png");
    private final GreenfootImage LMwalk2 = new GreenfootImage("p1_walk02inv.png");
    private final GreenfootImage LMwalk3 = new GreenfootImage("p1_walk03inv.png");
    private final GreenfootImage LMwalk4 = new GreenfootImage("p1_walk04inv.png");
    private final GreenfootImage LMwalk5 = new GreenfootImage("p1_walk05inv.png");
    private final GreenfootImage LMwalk6 = new GreenfootImage("p1_walk06inv.png");
    private final GreenfootImage LMwalk7 = new GreenfootImage("p1_walk07inv.png");
    private final GreenfootImage LMwalk8 = new GreenfootImage("p1_walk08inv.png");
    private final GreenfootImage LMwalk9 = new GreenfootImage("p1_walk09inv.png");
    private final GreenfootImage LMwalk10 = new GreenfootImage("p1_walk10inv.png");
    private final GreenfootImage LMwalk11 = new GreenfootImage("p1_walk11inv.png");
 
    private int speed = 3;
    private int frame;
    private boolean lopen;
    private boolean Kijkenrechts;
    private boolean isKeyPressed;
    
    static int sterren = 0;
    public int gems = 0;
    public int keys = 0;
    public boolean isDood = false;
   
    public boolean isTouchingMovingPlatform = false;
    
    int waardeCoin = 1;
    int Charactercoin1 = 0;
    int Charactercoin2 = 0;
    
    public int Level = 1;
    
    

    public  boolean key = false;
    public boolean door = false;
    public boolean openDeur1 = false;
    private int springY;
    private int walkL = -10;
    private int walkR = 10;
  
    public Hero() {
        super();
        
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p123.png");
        
        setImage(RMidle);
        lopen = false;
        Kijkenrechts = true;
 
        RMidle.scale(70,100);
        RMjump.scale(70,100);
        RMwalk1.scale(70,100);
        RMwalk2.scale(70,100);
        RMwalk3.scale(70,100);
        RMwalk4.scale(70,100);
        RMwalk5.scale(70,100);
        RMwalk6.scale(70,100);
        RMwalk7.scale(70,100);
        RMwalk8.scale(70,100);
        RMwalk9.scale(70,100);
        RMwalk10.scale(70,100);
        RMwalk11.scale(70,100);
 
        LMidle.scale(70,100);
        LMjump.scale(70,100);
        LMwalk1.scale(70,100);
        LMwalk2.scale(70,100);
        LMwalk3.scale(70,100);
        LMwalk4.scale(70,100);
        LMwalk5.scale(70,100);
        LMwalk6.scale(70,100);
        LMwalk7.scale(70,100);
        LMwalk8.scale(70,100);
        LMwalk9.scale(70,100);
        LMwalk10.scale(70,100);
        LMwalk11.scale(70,100);
    }
    
    

    

    @Override
    public void act() {
        handleInput();
        
        {
        checkKeys();
        //onGround();
        }
        //getWorld().showText(getX() + "," + getY(),500,50);
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        
        
        sterren();
        diamanten();
        
        
        
        
        
        
        
        
        

        

        
        for (Actor enemy : getIntersectingObjects(Death.class)) {
            if (enemy != null) {
                
                Greenfoot.setWorld(new GameOver());
                break;
            }
        }
        for ( Actor heroCoin1 : getIntersectingObjects(HeroCoin1.class)){
        
            if (heroCoin1 != null) {
            waardeCoin = 2;
            removeTouching(HeroCoin1.class);
            }
        }
        for ( Actor heroCoin2 : getIntersectingObjects(HeroCoin2.class)){
        
            if (heroCoin2 != null) {
            waardeCoin = 3;
            removeTouching(HeroCoin2.class);
            }
        }
        for ( Actor deur1 : getIntersectingObjects(Door.class)){
            if (deur1 != null && keys == 1) {
            openDeur1 = true;
            setLocation(5757, 4210);
            }
        }
        for ( Actor deur2 : getIntersectingObjects(Door2.class)){
            if (deur2 != null && keys == 1) {
            Level = 0;
            Greenfoot.setWorld(new LevelSelect());
            }
        }
        for ( Actor deur3 : getIntersectingObjects(Door3.class)){
            if (deur3 != null ) {
            Level = 1;
            Greenfoot.setWorld(new Level1());
            }
        
        }
        for ( Actor deur4 : getIntersectingObjects(Door4.class)){
            if (deur4 != null && sterren >= 2) {
            Level = 2;
            Greenfoot.setWorld(new Level2());
            }
        
        }
        for ( Actor deur5 : getIntersectingObjects(Door5.class)){
            if (deur5 != null && sterren >= 4) {
            Level = 3;
            Greenfoot.setWorld(new Level3());
            }
        
        }
        for ( Actor sleutels : getIntersectingObjects(Keys.class)){
            if(isTouching(Keys.class)){
             removeTouching(Keys.class);
             keys = keys +1;
            }
            
        }
        for ( Actor Gem : getIntersectingObjects(Gem.class)){
            if(isTouching(Gem.class)){
             removeTouching(Gem.class);
             gems = gems +1;
            }
            
        }
        for ( Actor Sterren : getIntersectingObjects(Ster.class)){
            if(isTouching(Ster.class)){
             removeTouching(Ster.class);
             sterren ++;
            }
            
        }
}
    
    
        
        public int sterren ()
        {
            return sterren;
        }
        
        public int diamanten()

       {
           return gems;
        }
 
    
            public void checkKeys()
    {
        isKeyPressed = false;
        if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a"))
        {
            stoplopen();
            isKeyPressed = true;
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            animateRight();
            setLocation (getX()+speed, getY());
            isKeyPressed = true;
        }
        else if (Greenfoot.isKeyDown("a"))
        {
            animateLeft();
            setLocation (getX()-speed, getY());
            isKeyPressed = true;
        }
        if (!(isKeyPressed))
        {
            stoplopen();
        }
    }
    
    
    public boolean onGround()
    {
        Actor under = getOneObjectAtOffset (0, getHeight ()/2, Tile.class);
        Tile tile = (Tile) under;
        return tile != null && tile.isSolid == true; 
    }
    
    
    
    
    
    public void handleInput() {
        if(waardeCoin == 1)
        {
            springY = -20;
            walkL = -5;
            walkR = 5;
        }
        else if(waardeCoin == 2)
        {
            springY = -22;
            walkL = -5;
            walkR = 5;
        }
        else if(waardeCoin == 3)
        {
            springY= -22;
            walkL = -5;
            walkR = 5;
        }
        
    
        
        if ((Greenfoot.isKeyDown("w") && onGround() == true ) || (Greenfoot.isKeyDown("w") && isTouching(JumpTile.class)))  {
            Greenfoot.playSound("Jump_-_Sound_Effect-6Q9t8ucAc2M.wav");
            velocityY = springY;
        }
        if (Greenfoot.isKeyDown("a")) {
            velocityX = walkL;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = walkR;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
 
    public void animateJump(){
        setImage("p"+waardeCoin+"_jump.png");
    }
    public void animateDuck(){
        setImage("p"+waardeCoin+"_duck.png");
    }
        
    public void animateRight()
    {
        
    
        if(frame == 1)
        {
        setImage("p"+waardeCoin+"_walk01.png");
        }
        else if(frame == 2)
        {
        setImage("p"+waardeCoin+"_walk02.png");
        }
       else if(frame == 3)
        {
        setImage("p"+waardeCoin+"_walk03.png");
        }
        else if(frame == 4)
        {
        setImage("p"+waardeCoin+"_walk04.png");
        }
        else if(frame == 5)
        {
        setImage("p"+waardeCoin+"_walk05.png");
        }
        else if(frame == 6)
        {
        setImage("p"+waardeCoin+"_walk06.png");
        }
       else if(frame == 7)
        {
        setImage("p"+waardeCoin+"_walk07.png");
        }
        else if(frame == 8)
        {
        setImage("p"+waardeCoin+"_walk08.png");
        }
        else if(frame == 9)
        {
        setImage("p"+waardeCoin+"_walk09.png");
    {
       
        frame = 1;
        return;
        }

      
        }
        frame ++;
    }
        
        public void animateLeft()
        {
            if(frame == 1)
        {
        setImage("p"+waardeCoin+"_walk01inv.png");
        }
        else if(frame == 2)
        {
        setImage("p"+waardeCoin+"_walk02inv.png");
        }
       else if(frame == 3)
        {
        setImage("p"+waardeCoin+"_walk03inv.png");
        }
        else if(frame == 4)
        {
        setImage("p"+waardeCoin+"_walk04inv.png");
        }
        else if(frame == 5)
        {
        setImage("p"+waardeCoin+"_walk05inv.png");
        }
        else if(frame == 6)
        {
        setImage("p"+waardeCoin+"_walk06inv.png");
        }
       else if(frame == 7)
        {
        setImage("p"+waardeCoin+"_walk07inv.png");
        }
        else if(frame == 8)
        {
        setImage("p"+waardeCoin+"_walk08inv.png");
        }
        else if(frame == 9)
        {
        setImage("p"+waardeCoin+"_walk09inv.png");
    
        
     
        frame = 1;
        return;
        }
        frame ++;
        }
 
    public void stoplopen()
    {
        lopen = false;
        if (Kijkenrechts)
            lopen = false;
        else
            lopen = false;
        }
        
        
        
        
        
        
         

public boolean getOpenDeur()
     {
         return openDeur1;
        }
        
    
    
    public void respawn()
    {
        Greenfoot.setWorld(new LevelSelect());
    }
    
    
    }
    
