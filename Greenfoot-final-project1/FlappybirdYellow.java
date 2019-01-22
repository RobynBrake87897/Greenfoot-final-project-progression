import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappybirdYellow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappybirdYellow extends Bird
{
    public String downKey;
    public String upKey;
    /**
     * Act - do whatever the FlappybirdBlue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     *
     **/
    public FlappybirdYellow(World w)
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
}    
