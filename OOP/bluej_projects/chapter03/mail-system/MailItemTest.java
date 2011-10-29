

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailItemTest.
 *
 * @author  Daniel Kvist
 * @version 1.0
 */
public class MailItemTest
{
    /**
     * Default constructor for test class MailItemTest
     */
    public MailItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAccessors()
    {
        MailItem mailItem1 = new MailItem("FROM", "TO", "SUBJECT", "BODY");
        assertEquals("FROM", mailItem1.getFrom());
        assertEquals("BODY", mailItem1.getMessage());
        assertEquals("SUBJECT", mailItem1.getSubject());
        assertEquals("TO", mailItem1.getTo());
    }
}

