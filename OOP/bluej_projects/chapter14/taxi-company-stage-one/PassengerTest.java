/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class PassengerTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /**
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
	public void testCreation()
	{
		Location pickup = new Location(0, 0);
		Location destination = new Location(1, 2);
		Passenger passenger1 = new Passenger(pickup, destination);
		assertEquals(destination, passenger1.getDestination());
		assertEquals(pickup, passenger1.getPickupLocation());
	}
}
