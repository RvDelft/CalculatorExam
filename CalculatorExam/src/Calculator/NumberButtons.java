package Calculator;

import java.awt.event.*;

public class NumberButtons extends Buttons implements ActionListener{
	
	public NumberButtons (Engine engine, String buttonValue){
		super(engine, buttonValue);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Run all actions for the NumberButtons
		
	}

}