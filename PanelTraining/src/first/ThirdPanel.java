package first;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ThirdPanel extends JPanel {
	private final int WIDTH = 300, HEIGHT = 200;
	private JTextArea t1;

	public ThirdPanel() {
		t1 = new JTextArea(
				"Hello\nHello\nHello\nHello\nHello\nHello\nHello\nHello\nHello\n");
		add(t1);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.pink);
	}
}
