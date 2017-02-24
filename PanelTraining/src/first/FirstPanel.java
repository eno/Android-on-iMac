package first;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstPanel extends JPanel {
	// cascading
	private final int WIDTH = 300, HEIGHT = 500;
	private JTextField t1;

	public FirstPanel() {
		t1 = new JTextField("Hello");
		add(t1);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.orange);
	}

}
