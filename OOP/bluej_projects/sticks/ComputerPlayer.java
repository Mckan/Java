/**
 * This is the computerplayer AI
 * 
 * @author Daniel Kvist
 * @version 1.0
 */
public class ComputerPlayer
{
    private Sticks sticks;
    
    /**
     * Constructor
     * @param a reference to the sticks
     */
    public ComputerPlayer(Sticks sticks) 
    {
        this.sticks = sticks;
    }
    
    /**
     * Makes the move for the computerplayer
     */
    public int move()
    {
        int num;
        //TODO create AI
        if(sticks.sticksLeft() == 4 || sticks.sticksLeft() == 1)
        {
            num = 1;
        }
        else
        {
            num = 2;
        }
        sticks.take(num);
        return sticks.sticksLeft();
    }
}
