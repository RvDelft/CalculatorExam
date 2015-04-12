package Calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class MemoryButtons extends Buttons implements ActionListener{
	private Memory memory;
	
	/**
	 * received params are used as argumend for the super constructor
	 * 
	 * this buttons need a extra reference (to Memory) to save a number
	 * added a actionListener
	 * @param Engine engine
	 * @param Display display
	 * @param Memory memory
	 * @param String buttonValue
	 */
	public MemoryButtons(Engine engine, Display display, Memory memory, String buttonValue){
		super(engine, display, buttonValue);
		this.memory = memory;
		addActionListener(this);
	}
	/**
	 * actionListner for the memoryButtons
	 * MS is save the number in baseDouble
	 * MR is reload the number to baseDouble
	 * M+ is saved memory number + baseDouble
	 * MC is memory clear
	 * 
	 * after every click there is a check if the saved number is something else
	 * rather then 0.00. if is't a different number the border of MS is thick. if not
	 * there is no border
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(buttonValue == "MS"){
			this.memory.setMemory(this.engine.getBaseDouble());
		}else if(buttonValue == "MR"){
			this.engine.clearNewNumberBuffer();
			this.engine.addToNewNumberBuffer(Double.toString(this.memory.getMemory()));
			this.engine.addInputToDouble();
		}else if(buttonValue == "M+"){
			double memoryTEMP = this.memory.getMemory() + this.engine.getBaseDouble();
			this.memory.setMemory(memoryTEMP);
		}else{
			this.memory.setMemory(0.00);
		}
		
		if(this.memory.getMemory() != 0.00){
			this.memory.setSaveButtonBorder(true);
		}else{
			this.memory.setSaveButtonBorder(false);
		}

	}

}
