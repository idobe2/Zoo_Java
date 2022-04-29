package graphics;

import java.awt.*;

public interface IDrawable {
    public final static String PICTURE_PATH = "assignment2_pictures";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public Color getColor();
}
