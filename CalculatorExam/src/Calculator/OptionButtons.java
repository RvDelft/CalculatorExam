package Calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionButtons extends Buttons implements ActionListener{

	public OptionButtons(Engine engine, Display display, String buttonValue){
		super(engine, display, buttonValue);
		if(buttonValue == "Backspace"){
			this.setPreferredSize(new Dimension(140, 40));
		}
		addActionListener(this);
	}
	
	
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
