package Calculator;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
public class Display {

	private JTextField mainDisplay;
	private JTextField secundairyDisplay;
	private DecimalFormat df = new DecimalFormat("##.############");
	
	/**
	 * installation both displays
	 */
	public Display(){
		Font mainFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		Font secundairyFont = new Font(Font.SANS_SERIF, Font.ITALIC, 15);
		this.mainDisplay = new JTextField();
		this.mainDisplay.setEditable(false);
		this.mainDisplay.setHorizontalAlignment(JTextField.RIGHT);
		this.mainDisplay.setFont(mainFont);
		this.mainDisplay.setPreferredSize(new Dimension(300, 40));
		this.mainDisplay.setBorder(null);
		this.mainDisplay.setVisible(true);
		this.secundairyDisplay = new JTextField();
		this.secundairyDisplay.setEditable(false);
		this.secundairyDisplay.setHorizontalAlignment(JTextField.RIGHT);
		this.secundairyDisplay.setFont(secundairyFont);
		this.secundairyDisplay.setPreferredSize(new Dimension(300, 30));
		this.secundairyDisplay.setBorder(null);
		this.secundairyDisplay.setVisible(true);
	}
	/**
	 * setter method of mainDisplay
	 * every number has to be round up
	 * @param String displayValue
	 */
	public void setMainDisplay(double displayValue){
		this.mainDisplay.setText(df.format(displayValue));
	}
	/**
	 * getter method of mainDisplay
	 * @return JTextField mainDisplay
	 */
	public JTextField getMainDisplay(){
		return this.mainDisplay;
	}
	/**
	 * setter method of secundairyDisplay
	 * @param String displayValue
	 */
	public void setSecundairyDisplay(String displayValue){
		this.secundairyDisplay.setText(displayValue);
	}
	/**
	 * because in the secundairy display there are also string values i've made
	 * a extra method to round the given double up
	 * @param double displayValue
	 */
	public void setSecundairyDisplayd(double displayValue){
		this.secundairyDisplay.setText(df.format(displayValue));
	}
	/**
	 * getter method of secundairyDisplay
	 * @return JTextField secundairyDisplay
	 */
	public JTextField getSecundairyDisplay(){
		return this.secundairyDisplay;
	}
}
