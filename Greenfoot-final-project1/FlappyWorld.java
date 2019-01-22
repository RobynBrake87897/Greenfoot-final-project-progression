import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    private String flappy;
     
    private String birdColour;
    
    private Menu flappysColoursMenu;
    
    private boolean flappysColoursMenuAdded;
    
    private Bird birdColours[];
    
    private Scoreboard score;
    
    public boolean startGame = false;
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 400x400 cells with a cell size of 1x1 pixels.
        super(420, 420, 1);  
         
        birdColour = new String ("FlappybirdYellow");
         
        birdColours = new Bird[] {new FlappybirdYellow(this), new FlappybirdGreen(this), new FlappybirdRed(this), new FlappybirdBlue(this)};
        
        flappysColoursMenuAdded = false;
        
        addObject(new Bird(), getHeight()-220, getWidth() - 100);
        
        addObject(new Scoreboard(),75,20);
    }
    public void act()
    {
        
        boolean flappySkinsMenuAdded = true; 
           
        flappysColoursMenu = new Menu("birdColours", "FlappybirdYellow\nFlappybirdGreen\nFlappybirdRed\nFlappybirdBlue", 24, Color.BLACK, Color.WHITE, new SwitchBirdCommands());
        
        addObject(flappysColoursMenu, getWidth() - 150, getHeight() -400);
        
        showText("press space to start",320,370);
        for( int i = 0; i < birdColours.length; i++)
        {
            if(i == 0)
            {
                addObject(birdColours[i], birdColours[i].getImage().getWidth()/2, getHeight() -birdColours[i].getImage().getHeight()/2);
            }
            else
            {
                birdColours[i].getImage().setTransparency(0);
                   
                addObject(birdColours[i], 0, getHeight() - birdColours[i].getImage().getHeight()/2);
            }
        }
        if(Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Donuts(), Greenfoot.getRandomNumber(0), 420);
        }
    }
    public void getBirdColour() 
    {
        Bird currentBirdColour;
            
        if(flappy.equalsIgnoreCase("FlappyBirdYellow"))
        {
            currentBirdColour = birdColours[0];
        }
        else if(flappy.equalsIgnoreCase("FlappyBirdGreen"))
        {
            currentBirdColour = birdColours[1];
        }
        else if(flappy.equalsIgnoreCase("FlappybirdRed"))
        {
            currentBirdColour = birdColours[2];
        }
        else
        {
            currentBirdColour = birdColours[3];
        }
    }
    private void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            startGame = true;
            showText("",320,370);
        }
    }
    public Bird getNewOneBirdColour(int index)
    {
        return birdColours[index];
    }
    public void update()
    {
        score.addToScore();
    }
    public void changeBirdColour( String bird)
    {
        
    }
    public Bird getOneNewBird(int index)
    {
        return birdColours[index];
    }
    public boolean getStarted()
    {
        return startGame;
    }
}


