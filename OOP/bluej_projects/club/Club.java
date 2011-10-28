import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Store details of club memberships.
 * 
 * @author Daniel Kvist
 * @version 1.0
 */

public class Club
{
    // A LinkedList to hold the members
    private LinkedList<Membership> membersLinkedList;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        membersLinkedList = new LinkedList<Membership>(); 
    }
    
    /**
     * Return the email addresses of all the club members.
     * @return A comma separated string of email addresses.
     */
    public String getEmailAdresses()
    {
       // An iterator for the list
       Iterator<Membership> iterator = membersLinkedList.iterator();
       // A stringbufer to build the return string
       StringBuffer sb = new StringBuffer(256);
        
        // Loop through the list and add the email adresses to a buffer
        while(iterator.hasNext())
        {
            // Create a temp member
            Membership tempMember = iterator.next();
            // Append to the list
            sb.append(tempMember.getEmail() + ",");
        }
        
        return sb.toString();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        // An iterator for the list
        Iterator<Membership> iterator = membersLinkedList.iterator();
        boolean memberExists = false;

        // Loop through the list and look for an existing e-mail
        while(iterator.hasNext())
        {
            // Create a temp member
            Membership tempMember = iterator.next();
            if(tempMember.getEmail().equalsIgnoreCase(member.getEmail()))
            {
                memberExists = true;
            }
        }
        // Add member if e-mail is not registered
        if(!memberExists)
        {
            membersLinkedList.add(member);
        }
        else
        {
            System.out.println("Member already exists");
        }
        
    }
    
    /**
     * Return how many members joined in the given month.
     * @param month The month we are interested in.
     * @param year The year of the Membership.
     * @return How many members joined in the given month.
     */
    public int joinedInMonth(int month, int year)
    {
       // An iterator for the list
       Iterator<Membership> iterator = membersLinkedList.iterator();
       
       int numberOfMembers = 0;
                
        // Check month validity
        if(month < 1 || month > 12) 
        {
            System.out.println("Error: The month you supplied is not valid");
            return 0;
        }
        
        // Loop through the list and look for an existing e-mail
        while(iterator.hasNext())
        {
            // Create a temp member
            Membership tempMember = iterator.next();
            
            tempMember = iterator.next();
            if(tempMember.getMonth() == month && tempMember.getYear() == year)
            {
                numberOfMembers++;
            }
        }
        
        return numberOfMembers;
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return membersLinkedList.size();
    }
    
    /**
     * Remove from the club's collection all members who joined
     * in the given month, and return them stored in a separate
     * collection object.
     * @param month The month of the Membership.
     * @param year The year of the Membership.
     */
    public ArrayList<Membership> purge(int month,int year)
    {
       // An iterator for the list
       Iterator<Membership> iterator = membersLinkedList.iterator();
       // An arraylist to hold the purged members
       ArrayList<Membership> purgedMembersArrayList = new ArrayList<Membership>();
       
        // Check month validity
        if(month < 1 || month > 12) 
        {
            System.out.println("Error: The month you supplied is not valid");
            return null;
        }
        
        // Loop through and purge while building the return list
        while(iterator.hasNext())
        {
            // Create a temp member
            Membership tempMember = iterator.next();
            
            // If the member matches the args, remove them from the
            // underlying collection and add them to the arraylist
            if(tempMember.getMonth() == month && tempMember.getYear() == year)
            {
                purgedMembersArrayList.add(tempMember);
                iterator.remove();
            }
        }
        
        return purgedMembersArrayList;
        
    }
    
    /**
      * Search for a member with a given email address. 
      * 
      * @return A matching membership object if found, 
      * null otherwise.
      */
    public Membership search(String email)
    {
        // An iterator for the list
        Iterator<Membership> iterator = membersLinkedList.iterator();
 
        // Loop through the list and look for an existing e-mail
        while(iterator.hasNext())
        {
            Membership tempMember = iterator.next();
            if(tempMember.getEmail().equalsIgnoreCase(email))
            {
                return tempMember;
            }
        }
        
        return null;
    }
}
