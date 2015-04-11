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
	private JPanel functionButtonPanel;
	private JPanel displayPanel;
	private FunctionButtons[] functionButtons;
	private NumberButtons[] numberButtons;
	
	/**
	 * Constructor GUICalculator
	 * install references to display, engine, buttonPanel, displayPanel, functionbuttons[] and numberButtons[].
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
		this.functionButtonPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.functionButtons = new FunctionButtons[8];
		this.numberButtons = new NumberButtons[12];
		
		this.setNumberButtonPanel();
		this.setFunctionButtonspanel();
		this.setDisplayPanel();
		this.setButtonPanel();
		this.setMainFrame();
	}
	/**
	 * method to make array of numberButtons.
	 * the function buttons ´.´ and ´+/-´  are added to this array.
	 * because this functions have influence on the new number rather than the sum 
	 * also the buttons are added to the buttonPanel
	 */
	private void setNumberButtonPanel(){
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
		this.numberButtonPanel.setPreferredSize(new Dimension(250 ,200));
		this.numberButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * put all the functionButtons in an array.
	 * the required values are all stored in the functionValue array.
	 * when al of the values are looped into a button the FunctionButtons are added to a Panel
	 */
	private void setFunctionButtonspanel(){
		String[] functionValues = {"+","-","*","/","√","%","1/x","="};
		for(int i = 0; i < this.functionButtons.length; i++){
			this.functionButtons[i] = new FunctionButtons(this.engine, this.display, functionValues[i]);
			this.functionButtonPanel.add(this.functionButtons[i]);	
		}
		this.functionButtonPanel.setPreferredSize(new Dimension(150, 200));
		this.functionButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * add displays (main and secundairy) to displayPanel
	 */
	private void setDisplayPanel(){
		this.displayPanel.setPreferredSize(new Dimension(250, 90));
		this.displayPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.displayPanel.add(this.display.getSecundairyDisplay());
		this.displayPanel.add(this.display.getMainDisplay());
	}

	/**
	 * add all buttonPanels in own panel
	 * added panels: numberButtonPanel and functionButtonPanel
	 */
	private void setButtonPanel(){
		this.buttonPanel.add(this.numberButtonPanel);
		this.buttonPanel.add(this.functionButtonPanel);
		this.buttonPanel.setPreferredSize(new Dimension(200,300));
	}

	/**
	 * method to install the mainFrame.
	 * add the panels
	 */
	private void setMainFrame(){
		this.getContentPane().add(BorderLayout.NORTH, this.displayPanel);
		this.getContentPane().add(BorderLayout.CENTER, this.buttonPanel);
		this.setVisible(true);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
