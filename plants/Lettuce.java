package plants;

import graphics.IDrawable;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	public void loadImages(String nm) {    // Read image file
		try {
			img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/lettuce.png"));
		} catch (IOException ex) {
			System.out.println("Cannot load image");
		}
	}
}
