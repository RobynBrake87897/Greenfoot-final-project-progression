import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leaf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Donuts extends Actor
{
    private GreenfootImage donut0 = new GreenfootImage("donut0.png");
    private GreenfootImage donut1 = new GreenfootImage("donut1.png");
    private GreenfootImage donut2 = new GreenfootImage("donut2.png");
    private GreenfootImage donut3 = new GreenfootImage("donut3.png");
    /**
     * Act - do whatever the Leaf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public Donuts()
   {
        int randomImage = Greenfoot.getRandomNumber(3);
        if(randomImage == 0)
        {
            setImage("donut0.png");
        }
        else if(randomImage == 1)
        {
            setImage("donut1.png");
        }
        else if(randomImage == 2)
        {
            setImage("donut2.png");
        }
        else
        {
            setImage("donut3.png");
        }
   }
   public void act() 
   {
        // Add your action code here. 
        if(getX() > getWorld().getWidth() - 2)
        {
            getWorld().removeObject(this);
        }
   }    
}
