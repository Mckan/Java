
/**
 * This is the gameengine which controls the gameplay
 * 
 * @author Daniel Kvist
 * @version 1.0
 */
public class GameEngine
{
    private Sticks sticks;
    private ComputerPlayer computerPlayer; 
    private HumanPlayer humanPlayer; 
    private UserInterface ui;
    
    /**
     * Constructor of the game engine that
     * sets up and connects the different parts
     */
    public GameEngine()
    {
        sticks = new Sticks();
        ui = new UserInterface();
        computerPlayer = new ComputerPlayer(sticks);
        humanPlayer = new HumanPlayer(sticks, ui);
    }
    
    /**
     * Runs the game and checks for winner
     */
    public int runGame()
    {
        while(1 == 1)
        {
            ui.sticksLeftMsg(sticks.sticksLeft());
            if(humanPlayer.move() == 0)
            {
                ui.playerWinMsg();
                //sticks.neswGame();
                break;
            }
            else if(computerPlayer.move() == 0)
            {
                ui.computerWinMsg();
                //sticks.newGame();
                break;
            }
        }
        return 0;
    }
}
