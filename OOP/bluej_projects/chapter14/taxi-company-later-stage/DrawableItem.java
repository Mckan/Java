import java.awt.Image;
    
/**
 * An item that is able to return an image of itself.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */

public interface DrawableItem extends Item
{
    public Image getImage();
}
