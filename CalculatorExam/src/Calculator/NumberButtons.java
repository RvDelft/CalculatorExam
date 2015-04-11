package Calculator;

import java.awt.event.*;

public class NumberButtons extends Buttons implements ActionListener{
	/**
	 * constructor of NumberButtons.
	 * takes 3 parameters and give them to super constructor (Buttons)
	 * also referens to the actionlistener
	 * @param Engine engine
	 * @param Display display
	 * @param String buttonValue
	 */
	public NumberButtons (Engine engine, Display display, String buttonValue){
		super(engine, display, buttonValue);
		addActionListener(this);
	}
	/**
	 * Add input to baseDouble if usedMathtoken is null (meens this is the begining of the sum)
	 * else add the input to secundairyDouble.
	 * also print number in mainDisplay.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.engine.getNewNumberBuffer().toString() == "" && buttonValue == "+/-"){
			this.engine.addToNewNumberBuffer(Double.toString(this.engine.getBaseDouble()));
		}
		this.engine.addToNewNumberBuffer(buttonValue);
		if(this.engine.getAlReadyCalculated()){
			this.display.setSecundairyDisplay(null);
			this.engine.setAlReadyCalculated(false);
		}
		if(this.engine.getUsedMathToken() == null || this.engine.getUsedMathToken() == "="){
			this.engine.setBaseDouble(Double.parseDouble(this.engine.getNewNumberBuffer().toString()));
			this.display.setMainDisplay(Double.toString(this.engine.getBaseDouble()));
		}else{
			this.engine.setSecundairyDouble(Double.parseDouble(this.engine.getNewNumberBuffer().toString()));
			this.display.setMainDisplay(Double.toString(this.engine.getSecundairyDouble()));
		}
		
		
	}

}