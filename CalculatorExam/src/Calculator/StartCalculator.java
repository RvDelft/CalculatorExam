package Calculator;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StartCalculator extends JFrame{
	private GUICalculator start;
	/**
	 * start method
	 * @param String[] args
	 */
	public static void main(String[] args) {
		StartCalculator startCal = new StartCalculator();
		startCal.go();


	}
	/**
	 * method to make JFrame (run without Servlet)
	 */
	public void go(){
		start = new GUICalculator();
		this.setLayout(new BorderLayout());
		this.getContentPane().add(start.getMainPanel());
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

