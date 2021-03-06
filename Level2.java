import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level2 extends World {

    private CollisionEngine ce;

    /**
     * Constructor for objects of class Level2.
     *
     */
    public Level2() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");

        int[][] map = {
{-1,-1,-1,-1,-1,-1,-1,259,259,259,259,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,259,224,224,224,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,81,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,259,226,226,226,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,311,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,259,259,259,226,226,226,259,259,259,225,225,225,225,-1,-1,225,225,225,225,225,-1,-1,225,225,225,225,225,-1,-1,259,259,259,259,259,259,259,259,259,259,259,259,259,105,-1,-1},
{-1,-1,-1,-1,259,-1,-1,-1,226,226,226,-1,53,53,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,-1,-1},
{-1,-1,-1,259,-1,-1,-1,-1,226,226,226,-1,53,53,53,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,282,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,-1},
{-1,-1,259,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259},
{-1,259,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,259,-1,-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,-1,-1,-1,-1,-1,259,259,259,259,259,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,176,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,259},
{259,-1,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,259,-1},
{259,282,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,259,301,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,175,259,224,-1},
{224,259,-1,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,53,-1,301,175,175,175,175,175,175,175,175,175,175,175,175,259,259,175,175,175,175,175,175,175,175,175,175,175,259,-1,226,-1},
{226,53,259,-1,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,53,-1,-1,301,175,175,175,175,175,175,175,175,175,175,301,53,-1,259,175,175,175,175,175,175,175,175,175,259,-1,-1,226,-1},
{226,53,-1,259,-1,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,53,-1,-1,53,301,175,175,175,175,175,175,175,175,301,-1,53,-1,-1,259,175,175,175,175,175,175,175,259,-1,-1,-1,226,-1},
{226,53,-1,-1,259,-1,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,53,-1,-1,53,53,301,175,175,175,175,175,175,301,-1,-1,53,-1,-1,53,259,259,259,259,259,259,259,53,-1,-1,-1,226,-1},
{226,53,-1,-1,224,259,-1,-1,226,226,226,-1,53,53,53,53,-1,-1,53,-1,-1,53,53,-1,301,175,175,175,175,301,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,259,259,259,259,259,-1,53,53,53,309,-1,-1,53,-1,-1,53,53,-1,53,301,175,175,301,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,-1,53,-1,53,-1,53,53,53,309,53,-1,-1,53,-1,-1,53,53,-1,53,-1,301,301,-1,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,-1,53,-1,53,-1,53,53,309,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,-1,53,-1,53,-1,53,309,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,-1,53,-1,53,-1,309,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,226,-1,-1,53,-1,309,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,226,-1},
{226,53,-1,-1,53,-1,-1,309,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,309,-1,-1,53,-1,-1,53,-1,53,-1,-1,53,-1,-1,309,-1,-1,-1,226,-1},
{226,53,-1,-1,53,-1,-1,53,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,53,-1,-1,-1,-1,-1,309,-1,-1,309,-1,53,-1,-1,309,-1,-1,-1,-1,-1,-1,226,-1},
{-1,53,-1,-1,53,-1,-1,53,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1},
{-1,309,-1,-1,53,-1,-1,53,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1},
{-1,-1,-1,-1,309,-1,-1,53,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1},
{-1,-1,-1,-1,-1,-1,-1,309,-1,53,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,221,282,-1,221,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,309,-1,53,53,53,-1,53,-1,-1,53,-1,-1,53,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,259,176,176,176},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,53,53,-1,53,-1,-1,53,-1,-1,53,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,175,259,175,175,175},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,53,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,175,259,259,175,175,175},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,-1,53,-1,-1,53,-1,-1,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,221,-1,-1,-1,-1,175,259,259,259,175,175,175},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,-1,-1,53,-1,-1,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,175,175,175},
{258,258,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,309,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,175,175,175},
{259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,175,175,175},
{259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,258,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,259,173,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,258,221,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,259,259,259,-1,-1,-1,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,259,258,-1,-1,-1,-1,-1,-1,-1,-1,-1,259,259,259,259,259,259,282,-1,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,259,259,-1,-1,-1,222,223,-1,-1,218,259,259,259,259,259,259,259,259,-1,-1,-1,-1,-1,175,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,259,259,176,176,176,176,176,176,176,176,259,259,259,259,259,259,259,259,259,176,176,176,175,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},
{259,259,259,259,259,259,259,259,259,259,175,175,175,175,175,175,175,175,259,259,259,259,259,259,259,259,259,175,175,175,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,259,175,175,175},

        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 10, 10);
        addObject(hero, 47,2170);
       // addObject(new Enemy(), 1170, 410);
        //addObject(new Platform(), 361, 5570);
        addObject(new HUD(), 0, 0);
        addObject(new HeroCoin1(),800 ,130);
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        prepare();
        // display de possistion
        
    }

    @Override
    public void act() {
        ce.update();
        
        
    }
    public void prepare()
    {
        PlayAgain1 playAgain1 = new PlayAgain1();
        addObject (playAgain1, 40, 40);
    }
        
}
