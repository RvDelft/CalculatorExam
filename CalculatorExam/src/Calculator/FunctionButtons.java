package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionButtons extends Buttons implements ActionListener{
	/**
	 * received params are used as argumend for the super constructor
	 * added a actionListener
	 * @param Engine engine
	 * @param Display display
	 * @param String buttonValue
	 */
	public FunctionButtons(Engine engine, Display display, String buttonValue){
		super(engine, display, buttonValue);
		addActionListener(this);
	}
	
	/**
	 * actionPerformed Method
	 * check if user has give a second number so we can calculated a sum
	 * also check if user as clicked on ´=´ and want to go on with the given answer
	 * the buttons '1/x' and '√' has to give directly an answer 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.engine.setAlReadyCalculated(false);
		if(this.engine.getSecundairyDouble() != 0.00){
			this.engine.doMath();
		}
		this.engine.setUsedMathToken(this.buttonValue);
		if(this.buttonValue == "√"){
			this.engine.addToTotalSumBuffer(buttonValue + this.engine.getNewNumberBuffer());
			this.engine.doMath();
		}else if(this.buttonValue == "1/x"){
			if(this.engine.getUsedMathToken() == "1/x"){
				this.engine.clearTotalSumBuffer();
				this.engine.addToTotalSumBuffer("1/");
				this.engine.addToTotalSumBuffer(this.engine.getBaseDouble());
			}else{
				this.engine.addToTotalSumBuffer("1/" + this.engine.getNewNumberBuffer());
			}
			this.engine.doMath();
		}else{
			this.engine.addToTotalSumBuffer(this.engine.getNewNumberBuffer() + buttonValue);

		}
		this.display.setSecundairyDisplay(this.engine.getTotalSumBuffer().toString());
		if(buttonValue == "=" || buttonValue == "√" || buttonValue == "1/x"){
			this.display.setMainDisplay(this.engine.getBaseDouble());
			this.engine.setAlReadyCalculated(true);
			this.engine.clearTotalSumBuffer();
			this.engine.addToTotalSumBuffer(Double.toString(this.engine.getBaseDouble()));
			this.engine.setSecundairyDouble(0.00);
		}else{
			this.display.setMainDisplay(0.00);

		}
		this.engine.clearNewNumberBuffer();
		
		
	}
	

}
