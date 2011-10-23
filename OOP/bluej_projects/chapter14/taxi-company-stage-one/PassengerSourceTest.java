/**
 * The test class PassengerSourceTest.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
import java.util.List;

public class PassengerSourceTest extends junit.framework.TestCase
{
    private PassengerSource source;
    
    /**
     * Default constructor for test class PassengerSourceTest
     */
    public PassengerSourceTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        TaxiCompany company = new TaxiCompany();
        source = new PassengerSource(company);
        Location taxiLocation = new Location(0, 0);
        Taxi taxi = new Taxi(company, taxiLocation);
        List<Vehicle> vehicles = company.getVehicles();
        vehicles.add(taxi);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
        source = null;
    }

    /**
     * Test for successful pickup of a passenger.
     */
    public void testPickup()
    {
        assertEquals(true, source.requestPickup());
    }
}
