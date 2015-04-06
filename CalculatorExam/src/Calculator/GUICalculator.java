package Calculator;

import java.awt.geom.Dimension2D;

import javax.swing.*;
import java.awt.*;
public class GUICalculator extends JFrame{

	private Engine engine;
	private JPanel buttonPanel;
	
	private NumberButtons[] numberButtons;
	public GUICalculator(){
		this.engine = new Engine();
		this.buttonPanel = new JPanel();
		this.numberButtons = new NumberButtons[10];
		this.setButtonsToButtonPanel();
		this.getContentPane().add(this.getButtonPanel());
		this.setVisible(true);
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setButtonsToButtonPanel(){
		for(int i = 0; i < this.numberButtons.length; i++){
			this.numberButtons[i] = new NumberButtons(this.engine, Integer.toString(i));
			this.buttonPanel.add(this.numberButtons[i]);
		}
	}
	public JPanel getButtonPanel(){
		return this.buttonPanel;
	}
}
