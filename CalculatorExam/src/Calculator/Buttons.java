package Calculator;

import java.awt.*;
import javax.swing.*;

public class Buttons extends JButton{

	private Engine engine;
	public Buttons (Engine engine, String buttonValue){
		super(buttonValue);
		this.engine = engine;
		this.setPreferredSize(new Dimension(50,40));
	}
}