/**
 * Write a description of class SwitchBirdComands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwitchBirdCommands implements MenuCommands
{
    /**
     * Constructor for objects of class SwitchBirdComands
     */
    public void execute(int idx, Bird c)
    {
        if(c instanceof Bird)
        {
            c.switchBird(idx+1);
        }
        else if(c instanceof FlappybirdYellow || c instanceof FlappybirdGreen)
        {
            if(idx == 1)
            {
               c.switchBird(idx+1);
            }
            else
            {
                c.switchBird(idx);
            }
        }
        else
        {
            c.switchBird(idx);
        }
    }
}
