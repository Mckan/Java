import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;

/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    private List<MailItem> items;
    // A mapping of the mailboxes to the list
    private HashMap<String, List<MailItem>> mailBoxes;

    /**
     * Construct a mail server.
     */
    public MailServer()
    {
        items = new ArrayList<MailItem>();
        mailBoxes = new HashMap<String, List<MailItem>>();
    }
    
    /**
     * Create a mailbox for a single user
     * @param  the name of the new user
     * @return 1 if the creation succeeded
     *         0 if a mailbox with that name already existed
     */
    public int createMailbox(String user)
    {
        // If the user doesn't already have a mailbox, create it
        if(!mailBoxes.containsKey(user))
        {
            mailBoxes.put(user, items);
            return 1;
        }
        return 0;
    }
    
    /**
     * Create mailboxes for users
     * @param  an array containing the names of the new users
     * @return the number of successfully created mailboxes,
     *         this number will be less than the number of
     *         specified users if some mailboxes already existed
     */
    public int createMailbox(String[] users)
    {
        int count = 0;
        for(String user : users)
        {
            // If the user doesn't already have a mailbox, create it
            if(!mailBoxes.containsKey(user))
            {
                mailBoxes.put(user, items);
                count++;
            }
        }
        return count;
    }
    
    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
        Iterator<MailItem> it = items.iterator();
        while(it.hasNext()) 
        {
            MailItem item = it.next();
            if(item.getTo().equals(who)) 
            {
                it.remove();
                return item;
            }
        }
        return null;
    }
    
    /**
     * Retrieves the mailbox for a user
     *
     * @param   who the owner of the requested mailbox
     * @return  the mailbox belonging to who,
     *          null if it does not exist
     */
    private List<MailItem> getMailbox(String who)
    {
        /*List<MailItem> mailBox = mailboxes.get(who);
        if(mailBox != null)
        {
            return mailBox;
        }
        return null;*/
        return mailBoxes.get(who);
    }

    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
        int count = 0;
        for(MailItem item : items) 
        {
            if(item.getTo().equals(who)) 
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Return the number of messages on the server
     * @return number of messages on the server
     */
    public int howManyMessages()
    {
        return items.size();
    }

    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {
        // Check to make sure message is valid
        if(isValidMessage(item))
        {
            items.add(item);
        }

    }
    
    /**
     * Checks the to and from fields to see if they are empty
     * @param item The mail item to be checked
     * @return True if the to and from fields are filled in
     */
    private boolean isValidMessage(MailItem item)
    {
        if(item.getTo().isEmpty() || item.getFrom().isEmpty())
        {
            return false;
        }
        return true;
    }
}
