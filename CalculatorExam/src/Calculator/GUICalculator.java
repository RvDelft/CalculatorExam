package Calculator;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
public class GUICalculator extends JFrame{

	private Engine engine;
	private Display display;
	private JPanel buttonPanel;
	private JPanel displayPanel;
	
	private NumberButtons[] numberButtons;
	
	/**
	 * Constructor GUICalculator
	 * istall references to display, engine, buttonPanel, displayPanel and numberButtons[].
	 * 
	 * make buttons by using the setButtonsToButtonPanel Method
	 * add display to displayPanel
	 * make mainFrame an show it.
	 */
	public GUICalculator(){
		this.display = new Display();
		this.engine = new Engine(this.display);
		this.buttonPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.numberButtons = new NumberButtons[10];
		
		this.setButtonsToButtonPanel();
		this.setDisplayPanel();
		this.setMainFrame();
	}
	/**
	 * method to make array of numberButtons.
	 * also the buttons are added to the buttonPanel
	 */
	public void setButtonsToButtonPanel(){
		for(int i = 0; i < this.numberButtons.length; i++){
			this.numberButtons[i] = new NumberButtons(this.engine, this.display, Integer.toString(i));
			this.buttonPanel.add(this.numberButtons[i]);
		}
	}
	/**
	 * getter method of ButtonPanel
	 * @return JPanel buttonPanel
	 */
	public JPanel getButtonPanel(){
		return this.buttonPanel;
	}
	/**
	 * add displays (main and secundairy) to displayPanel
	 */
	public void setDisplayPanel(){
		this.displayPanel.setPreferredSize(new Dimension(300, 90));
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
	/**
	 * method to install the mainFrame.
	 * add the panels
	 */
	public void setMainFrame(){

		this.getContentPane().add(BorderLayout.NORTH, this.getDisplayPanel());
		this.getContentPane().add(BorderLayout.CENTER, this.getButtonPanel());
		this.setVisible(true);
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
