/**
 * This is the class that handles the sticks.
 * 
 * @author Daniel Kvist
 * @version 1.0
 */
public class Sticks
{
    private int maxNoOfSticks;
    private int sticksLeft;
    
    /**
     * Constructor initializes to 21 sticks
     */
    public Sticks()
    {
        this(21);
    }
    
    /**
     * Constructor initializes to number of sticks
     * @param int number of sticks
     */
    public Sticks(int n)
    {
        sticksLeft = maxNoOfSticks = n;
    }
    
    /**
     * Starts a new game
     */
    public void newGame()
    {
        sticksLeft = maxNoOfSticks;
    }
    
   /**
    * Returns how many sticks there are left
    * @return int of sticks left
    */
    public int sticksLeft()
    {
        return sticksLeft;
    }
    
    /**
     * Takes 1 or 2 sticks from the pile of sticks
     * @return int amount of sticks left or -1
     */
    public int take(int n)
    {
        if((n == 1) || (n == 2))
        {
            sticksLeft = sticksLeft - n;
            if(sticksLeft >= 0)
            {
                return sticksLeft;
            }
            else
            {
                return -1;
            }
        }
        else 
        {
            return -1;
        }
        
    }
}
