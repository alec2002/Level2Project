import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameAddOn {
	BufferedImage map;
	GamePanel pan;

	public GameAddOn(GamePanel panel) {
		pan = panel;
		try {
			map = ImageIO.read(this.getClass().getResourceAsStream("jelly.jpeg"));
		} catch (Exception e) {
			System.err.println("There was an error loading your image.");
		}

	}

	public void draw(Graphics g) {
		g.drawImage(map, 0, 0, GameWindow.getWidth(), GameWindow.getHeight(), null);
	}
}
