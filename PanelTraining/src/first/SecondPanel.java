package first;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondPanel extends JPanel {
	private final int WIDTH = 300, HEIGHT = 500;
	private JTextField t1;

	public SecondPanel() {
		t1 = new JTextField("Welcome");
		add(t1);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.gray);
	}

}
