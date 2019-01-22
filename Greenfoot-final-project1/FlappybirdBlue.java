import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappybirdBlue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappybirdBlue extends Bird
{
    public String upKey;
    public String downKey;
    
    /**
     * Act - do whatever the FlappybirdBlue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FlappybirdBlue(World w)
    {
        super();
        getImage().scale(50, 55);
    }
    public void act() 
    {
        checkKeyPress();
    }    
    private void checkKeyPress()
    {
        upKey = "w";
        downKey = "s";
        if(Greenfoot.isKeyDown(upKey))
        {
            setLocation(getX(), getY() - 4);
        }
        if(Greenfoot.isKeyDown(downKey))
        {
            setLocation(getX(), getY() + 4);
        }
        if(isTouching(Donuts.class)== true)
        {
            removeTouching(Donuts.class);
            ((FlappyWorld)getWorld()).update();
        }
    }
    public void switchBird(int idx)
    {
        FlappyWorld birdWorld  = ((FlappyWorld)getWorld());
        Bird switchBird = birdWorld.getOneNewBird(idx);
        while(getX() > 0)
        {
            setLocation(getWorld().getHeight()/2, getWorld().getWidth() - 100);
            Greenfoot.delay(2);
        }
        getImage().setTransparency(0);
        if(idx == 1)
        {
            birdWorld.changeBirdColour("FlappybirdYellow");
        }
        else
        {
            birdWorld.changeBirdColour("FlappybirdGreen");
            switchBird.switchedIn();
        }
    }
    public void switchedIn()
    {
        getImage().setTransparency(255);
        while(getX() < getImage().getWidth()/2)
        {
            setLocation(getX()+5, getY());
            Greenfoot.delay(2);
        }
    }
}
