package graphics;

import java.awt.*;

/**
 * An interface made to combine the options of graphics.
 * Used with all drawing objects.
 *
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IDrawable
 */
public interface IDrawable {
    public final static String PICTURE_PATH = "assignment2_pictures";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public Color getColor();
}
