/**
 * Communicates with player and takes stick for the player
 * 
 * @author Daniel Kvist
 * @version 1.0
 */
public class HumanPlayer
{
    private Sticks sticks;
    private UserInterface ui;
    
    public HumanPlayer(Sticks sticks, UserInterface ui)
    {
        this.sticks = sticks;
        this.ui = ui;
    }
    
    public int move()
    {
        int num;
        
        while(1 == 1)
        {
            ui.howManySticksMsg();
            num = ui.nextInt();
            if(num == 1 || num == 2)
            {
                sticks.take(num);
                break;
            }
            else
            {
                ui.illegalMoveMsg();
            }
        }
        return sticks.sticksLeft();
    }
}