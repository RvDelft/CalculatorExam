package Calculator;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
public class GUICalculator extends JFrame{

	private Engine engine;
	private Display display;
	private JPanel buttonPanel;
	private JPanel numberButtonPanel;
	private JPanel displayPanel;
	private FunctionButtons[] functionButtons;
	private NumberButtons[] numberButtons;
	
	/**
	 * Constructor GUICalculator
	 * install references to display, engine, buttonPanel, displayPanel and numberButtons[].
	 * 
	 * make buttons by using the setButtonsToButtonPanel Method
	 * add display to displayPanel
	 * make mainFrame an show it.
	 */
	public GUICalculator(){
		this.display = new Display();
		this.engine = new Engine(this.display);
		this.buttonPanel = new JPanel();
		this.numberButtonPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.functionButtons = new FunctionButtons[8];
		this.numberButtons = new NumberButtons[12];
		
		this.setNumberButtonsToNumberButtonPanel();

		this.setMainFrame();
	}
	/**
	 * method to make array of numberButtons.
	 * the function buttons ´.´ and ´+/-´  are added to this array.
	 * because this functions have influence on the new number rather than the sum 
	 * also the buttons are added to the buttonPanel
	 */
	public void setNumberButtonsToNumberButtonPanel(){
		String[] numberOptions = {".","+/-"};
		for(int i = 0; i < this.numberButtons.length; i++){
			if(i < 10){
				this.numberButtons[i] = new NumberButtons(this.engine, this.display, Integer.toString(i));
				this.numberButtonPanel.add(this.numberButtons[i]);
			}
		}
		
		this.numberButtons[10] = new NumberButtons(this.engine, this.display, numberOptions[0]);
		this.numberButtonPanel.add(this.numberButtons[10]);
		this.numberButtons[11] = new NumberButtons(this.engine, this.display, numberOptions[1]);
		this.numberButtonPanel.add(this.numberButtons[11]);
		this.numberButtonPanel.setPreferredSize(new Dimension(250 ,300));
		this.numberButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * getter method of ButtonPanel
	 * @return JPanel buttonPanel
	 */
	public JPanel getNumberButtonPanel(){
		return this.numberButtonPanel;
	}
	/**
	 * add displays (main and secundairy) to displayPanel
	 */
	public void setDisplayPanel(){
		this.displayPanel.setPreferredSize(new Dimension(250, 90));
		this.displayPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.displayPanel.add(this.display.getSecundairyDisplay());
		this.displayPanel.add(this.display.getMainDisplay());
	}
	/**
	 * getter method of displayPanel
	 * @return JPanel displaypanel
	 */
	public JPanel getDisplayPanel(){
		return this.displayPanel;
	}
	
	public void setButtonPanel(){
		this.buttonPanel.add(this.getNumberButtonPanel());
		this.buttonPanel.setPreferredSize(new Dimension(200,300));
	}
	public JPanel getButtonPanel(){
		return this.buttonPanel;
	}
	/**
	 * method to install the mainFrame.
	 * add the panels
	 */
	public void setMainFrame(){
		this.setDisplayPanel();
		this.setButtonPanel();
		this.getContentPane().add(BorderLayout.NORTH, this.getDisplayPanel());
		this.getContentPane().add(BorderLayout.CENTER, this.getButtonPanel());
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
