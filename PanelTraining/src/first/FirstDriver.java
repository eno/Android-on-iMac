package first;

import javax.swing.JFrame;

public class FirstDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Testing FirstPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SecondPanel sp = new SecondPanel();
		FirstPanel fp = new FirstPanel();
		frame.getContentPane().add(sp);
		// frame.getContentPane().add(new FirstPanel());
		sp.add(fp);
		// sp.add(new SecondPanel());
		fp.add(new ThirdPanel());

		frame.pack();
		frame.setVisible(true);
	}

}
