package Calculator;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public class GUICalculator{

	private Engine engine;
	private Display display;
	private Memory memory;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JPanel numberButtonPanel;
	private JPanel functionButtonPanel;
	private JPanel displayPanel;
	private JPanel optionButtonPanel;
	private JPanel memoryButtonPanel;
	private FunctionButtons[] functionButtons;
	private NumberButtons[] numberButtons;
	private OptionButtons[] optionButtons;

	
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
		this.memory = new Memory();
		this.mainPanel = new JPanel(new BorderLayout());
		this.buttonPanel = new JPanel(new BorderLayout());
		this.numberButtonPanel = new JPanel();
		this.functionButtonPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.optionButtonPanel = new JPanel();
		this.memoryButtonPanel = new JPanel();
		this.functionButtons = new FunctionButtons[8];
		this.numberButtons = new NumberButtons[12];
		this.optionButtons = new OptionButtons[3];

		this.setNumberButtonPanel();
		this.setFunctionButtonsPanel();
		this.setOptionButtonsPanel();
		this.setMemoryButtonPanel();
		this.setDisplayPanel();
		this.setButtonPanel();
		this.setMainPanel();
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
	 * the required values are all stored in the functionValue array and directly 
	 * added to the functionButtonPanel
	 */
	private void setFunctionButtonsPanel(){
		String[] functionValues = {"+","-","*","/","√","%","1/x","="};
		for(int i = 0; i < this.functionButtons.length; i++){
			this.functionButtons[i] = new FunctionButtons(this.engine, this.display, functionValues[i]);
			this.functionButtonPanel.add(this.functionButtons[i]);	
		}
		this.functionButtonPanel.setPreferredSize(new Dimension(150, 200));
		this.functionButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * put all the optionButtons in an array.
	 * the required values are all stored in the functionValue array and directly 
	 * added to the functionButtonPanel
	 */
	public void setOptionButtonsPanel(){
		String[] optionValue = {"Backspace", "C", "CE"};
		for(int i = 0; i < this.optionButtons.length; i++){
			this.optionButtons[i] = new OptionButtons(this.engine, this.display, optionValue[i]);
			this.optionButtonPanel.add(this.optionButtons[i]);
		}
		this.optionButtonPanel.setPreferredSize(new Dimension(300, 50));
		this.optionButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * put all the memoryButtons in an array.
	 * the required values are all stored in the functionValue array and directly 
	 * added to the functionButtonPanel
	 */
	public void setMemoryButtonPanel(){
		String[] memoryValue = {"MC","MS","MR","M+"};
		for(int i = 0; i < this.memory.getMemoryButtons().length; i++){
			this.memory.getMemoryButtons()[i] = new MemoryButtons(this.engine, this.display, this.memory, memoryValue[i]);
			this.memoryButtonPanel.add(this.memory.getMemoryButtons()[i]);
		}
		this.memoryButtonPanel.setPreferredSize(new Dimension(80, 200));
		this.memoryButtonPanel.setLayout(new FlowLayout());
	}
	/**
	 * add displays (main and secundairy) to displayPanel
	 */
	private void setDisplayPanel(){
		this.displayPanel.setPreferredSize(new Dimension(250, 90));
		this.displayPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.displayPanel.setBorder(new LineBorder(new Color(0,0,0), 1));
		this.displayPanel.setLayout(new BorderLayout());
		this.displayPanel.add(this.display.getSecundairyDisplay(), BorderLayout.NORTH);
		this.displayPanel.add(this.display.getMainDisplay(), BorderLayout.SOUTH);
	}

	/**
	 * add all buttonPanels sorted in one panel
	 * added panels: numberButtonPanel, functionButtonPanel, optionButtonPanel
	 * and memoryButtonPanel
	 */
	private void setButtonPanel(){
		this.buttonPanel.add(this.memoryButtonPanel, BorderLayout.WEST);
		this.buttonPanel.add(this.optionButtonPanel, BorderLayout.NORTH);
		this.buttonPanel.add(this.numberButtonPanel ,BorderLayout.CENTER);
		this.buttonPanel.add(this.functionButtonPanel, BorderLayout.EAST);
	}

	/**
	 * method to install the mainFrame.
	 * add the panels
	 */
	private void setMainPanel(){
		this.mainPanel.setLayout(new BorderLayout());
		this.mainPanel.add(BorderLayout.NORTH, this.displayPanel);
		this.mainPanel.add(BorderLayout.CENTER, this.buttonPanel);
		this.mainPanel.setVisible(true);
	}
	/**
	 * getter method for mainPanel;
	 * @return JPanel mainPanel
	 */
	public JPanel getMainPanel(){
		return mainPanel;
	}
}
