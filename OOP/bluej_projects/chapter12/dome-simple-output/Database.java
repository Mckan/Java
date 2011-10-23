import java.util.ArrayList;
import java.io.*;

/**
 * The database class provides a facility to store CD and video 
 * objects. A list of all CDs and videos can be printed to the
 * terminal.
 * 
 * This version write the data to disk in a simple format.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Database
{
    private ArrayList<Item> items;

    /**
     * Construct an empty Database.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Add an item to the database.
     * @param theItem The item to be added.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }

    /**
     * Print a list of all currently stored CDs and videos to the
     * text terminal.
     */
    public void list()
    {
        for(Item item : items)
        {
            item.print();
        }
    }
    
    /**
     * Write the basic details of all items to the given file.
     * @param filename Where to save the details.
     */
    public void writeBasicDetails(String filename)
    {
        try {
            FileWriter writer = new FileWriter(filename);
            for(Item item : items) {
                writer.write(item.basicDetails());
                writer.write('\n');
            }
            writer.close();
        }
        catch(IOException e) {
            System.err.println("Failed to save to " + filename);
        }
    }
}
