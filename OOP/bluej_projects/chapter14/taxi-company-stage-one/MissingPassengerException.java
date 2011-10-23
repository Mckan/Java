
/**
 * Indicate that there was no passenger at a pickup point.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MissingPassengerException extends RuntimeException
{
    private Vehicle vehicle;
    /**
     * Constructor for objects of class MissingPassengerException.
     * @param vehicle The vehicle expecting a passenger.
     */
    public MissingPassengerException(Vehicle vehicle)
    {
        super("Missing passenger at pickup location.");
    }

    /**
     * @return The vehicle for which there was no passenger.
     */
    public Vehicle getVehicle()
    {
        return vehicle;
    }
}
