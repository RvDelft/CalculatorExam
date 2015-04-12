package Calculator;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class Memory {

	private double memoryDouble;
	private MemoryButtons[] memoryButtons;
	public Memory(){
		this.memoryButtons = new MemoryButtons[4];
	}
	/**
	 * getter method of memoryButtons
	 * @return MemoryButtons memoryButtons
	 */
	public MemoryButtons[] getMemoryButtons(){
		return this.memoryButtons;
	}
	/**
	 * the change for the border has to be here
	 * Now i can use a reference to this method to change the border. 
	 * @param boolean on
	 */
	public void setSaveButtonBorder(boolean on){
		if(on){
			this.memoryButtons[1].setBorder(new LineBorder(new Color(0,0,0), 2));
		}else{
			this.memoryButtons[1].setBorder(null);
		}
	}
	/**
	 * setter method memoryDouble
	 * @param Double memory
	 */
	public void setMemory(double memory){
		this.memoryDouble = memory;
	}
	/**
	 * getter method memoryDouble
	 * @return double memoryDouble;
	 */
	public double getMemory(){
		return this.memoryDouble;
	}
}
