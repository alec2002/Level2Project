import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class TreasureHunt {
	BufferedImage map;
	GamePanel pan;

	public TreasureHunt(GamePanel panel) {
		pan = panel;
		try {
			map = ImageIO.read(this.getClass().getResourceAsStream("treasure.jpeg"));
		} catch (Exception e) {
			System.err.println("There was an error loading your image.");
		}
		JOptionPane.showMessageDialog(null, "YAAAARGGGG, we are going on a treasure hunt skipper");
		JOptionPane.showMessageDialog(null, "OK lad, find the place that marks me booty");
	}

	public void update() {
		if (InputManager.GetMouseX() > 200 & InputManager.GetMouseX() < 210 && InputManager.GetMouseY() > 285
				&& InputManager.GetMouseY() > 295 & InputManager.GetMouseY() < 335) {
			JOptionPane.showMessageDialog(null, "Good Job, Now find thy docking device on here map");
			playSound("waves.wav");

		}
		if (InputManager.GetMouseX() > 375 & InputManager.GetMouseX() < 390 && InputManager.GetMouseY() > 140
				& InputManager.GetMouseY() < 160) {
			playSound("dddd.wav");
			JOptionPane
					.showMessageDialog(
							null,
							"Oh no, the ghost of Black Beard has appeared, remember the combination then click the correct combination or feel his wrath");
			playSound("drama.wav");
			pan.ChangeState();
		}
	}

	public void draw(Graphics g) {
		g.drawImage(map, 0, 0, GameWindow.getWidth(), GameWindow.getHeight(), null);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
