package Calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionButtons extends Buttons implements ActionListener{
	/**
	 * received params are used as argumend for the super constructor
	 * added a actionListener
	 * @param Engine engine
	 * @param Display display
	 * @param String buttonValue
	 */
	public OptionButtons(Engine engine, Display display, String buttonValue){
		super(engine, display, buttonValue);
		if(buttonValue == "Backspace"){
			this.setPreferredSize(new Dimension(140, 40));
		}
		addActionListener(this);
	}
	
	/**
	 * every optionButton has a different function. 
	 * backspace is for deleting the last input
	 * C is for deleting the hole number in numberBuffer
	 * CE is for deleting everything to start all over.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(buttonValue == "Backspace"){
			this.engine.addToNewNumberBuffer(buttonValue);
			this.engine.addInputToDouble();
		}else if(buttonValue == "C"){
			this.engine.clearSum(false);
		}else{
			this.engine.clearSum(true);
		}
		
	}
}
