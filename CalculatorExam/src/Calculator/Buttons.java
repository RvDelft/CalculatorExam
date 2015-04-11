package Calculator;

import java.awt.*;
import javax.swing.*;

public class Buttons extends JButton{

	protected Engine engine;
	protected Display display;
	protected String buttonValue;
	/**
	 * Constructor of Buttons takes 2 parameters
	 * buttonValue is the value in the button
	 * The Engine referense is saved here for further use in all the buttons
	 * the preferredSize is also set
	 * @param Engine engine
	 * @param String buttonValue
	 */
	public Buttons (Engine engine, Display display, String buttonValue){
		super(buttonValue);
		this.engine = engine;
		this.display = display;
		this.buttonValue = buttonValue;
		this.setPreferredSize(new Dimension(70,40));
	}
}