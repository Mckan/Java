

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailServerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailServerTest
{
    private MailServer mailServer;
    private MailItem messEmptyFrom;
    private MailItem messEmptyTo;

    /**
     * Default constructor for test class MailServerTest
     */
    public MailServerTest()
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
        mailServer = new MailServer();
        messEmptyFrom = new MailItem("", "TO", "", "");
        messEmptyTo = new MailItem("FROM", "", "", "");
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
    public void testEmptyFrom()
    {
        mailServer.post(messEmptyFrom);
        assertEquals(0, mailServer.howManyMessages());
    }

    @Test
    public void testEmptyTo()
    {
        mailServer.post(messEmptyTo);
        assertEquals(0, mailServer.howManyMessages());
    }
}


