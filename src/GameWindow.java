import javax.swing.JFrame;

public class GameWindow {
	InputManager input;
	private static int width;
	private static int height;
	private String title;
	JFrame window;
	GamePanel panel;

	public GameWindow(int w, int h, String title) {
		this.width = w;
		this.height = h;
		this.title = title;
		input = new InputManager();
		window = new JFrame(title);
		panel = new GamePanel();
		window.add(panel);
		window.addMouseListener(input);
		window.addMouseMotionListener(input);
		window.addKeyListener(input);

		// window.getContentPane().setPreferredSize(new Dimension(width,
		// height));
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public static void main(String[] args) {
		new GameWindow(500, 500, "Treasure Hunt");

	}
}
