import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	TreasureHunt hunt;
	GameAddOn addon;
	int TreasureState = 0;
	int gameaddon = 1;
	int SurferGame = 2;
	int currentState = TreasureState;

	public void paintComponent(Graphics g) {
		if (currentState == TreasureState) {
			hunt.draw(g);
		} else if (currentState == gameaddon) {
			addon.draw(g);
		}
	}

	public GamePanel() {
		super();
		hunt = new TreasureHunt(this);
		addon = new GameAddOn(this);
		timer = new Timer(1000 / 60, this);
		timer.start();

	}

	public void update() {
		if (currentState == TreasureState) {
			hunt.update();
		}
	}

	public void ChangeState() {
		if (currentState == 2) {
			currentState = 0;
		} else {
			currentState++;
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		update();
	}
}
