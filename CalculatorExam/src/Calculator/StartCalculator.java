package Calculator;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class StartCalculator extends JApplet{

	public StartCalculator(){
		getContentPane().add(new GUICalculator());
	}
	/**
	 * start method
	 * @param String[] args
	 */
	public static void main(String[] args) {
		GUICalculator start = new GUICalculator();
		JFrame frame = new JFrame();	

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(start);
		frame.setVisible(true);
		frame.pack();


	}

}

