import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    private Textbox titleBar;
    private Textbox menuItems;
    private MenuCommands menuCommands;
    private Color mainFG;
    private Color mainBG;
    private int titleHeight;
    private int menuHeight;
    private int fontSize = 24;
    private boolean visible = false;

    public Menu(String title, String items, int size, Color mfg, Color mbg, MenuCommands commands)
    {
        mainFG = mfg;
        mainBG = mbg;
        fontSize = size; 
        menuCommands = commands;
        titleBar = new Textbox(title, fontSize, true, mainFG, mainBG);
        menuItems = new Textbox(items, fontSize, true, mainFG, mainBG);
    }
    protected void addedToWorld(World w)
    {
        w.addObject(titleBar, this.getX(), this.getY());
        titleHeight = titleBar.getImage().getHeight(); 
        menuHeight = menuItems.getImage().getHeight();
    }
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here. 
        handleMouse();
    }    
    private void handleMouse()
    {
        int menuIndex;
        MouseInfo mouse;
        
        FlappyWorld world = ((FlappyWorld)getWorld());
        int distance;
        
        if(Greenfoot.mouseClicked(titleBar))
        {
            if(visible == false)
            {
                getWorld().addObject(menuItems, this.getX(), this.getY() + (titleHeight +menuHeight) / 2);
            }
            else
            {
                getWorld().removeObject(menuItems);
            }
            visible = !visible;
        }
        if(Greenfoot.mouseClicked(menuItems))
        {
            mouse = Greenfoot.getMouseInfo();
            menuIndex = ((mouse.getY() - menuItems.getY() + menuHeight / 2) - 1) / fontSize;
            visible = !visible;
            getWorld().removeObject(menuItems);
        }
    }
}
