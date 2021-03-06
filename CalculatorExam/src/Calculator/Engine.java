package Calculator;

import java.text.DecimalFormat;


public class Engine {

	private MathCalculation mathcalculation;
	private Display display;
	private double baseDouble = 0.00;
	private double secundairyDouble;
	private String usedMathToken;
	private boolean alReadyCalculated;
	private StringBuffer newNumberBuffer;
	private StringBuffer totalSumBuffer;
	private DecimalFormat df = new DecimalFormat("##.############");

	/**
	 * Constructor Engine takes no parameter
	 * set the reference of MathCalculation and Display
	 */
	public Engine(Display display){
		this.mathcalculation = new MathCalculation();
		this.display = display;
		this.newNumberBuffer = new StringBuffer();
		this.totalSumBuffer = new StringBuffer();
		this.usedMathToken = null;
	}
	/**
	 * getter method of baseDouble
	 * @return double baseDouble
	 */
	public double getBaseDouble(){
		return this.baseDouble;
	}
	/**
	 * setter method of baseDouble
	 * @param double numberValue
	 */
	public void setBaseDouble(double numberValue){
		this.baseDouble = numberValue;
	}
	/**
	 * getter method of secundairyDouble
	 * @return double secundairyDouble
	 */
	public double getSecundairyDouble(){
		return this.secundairyDouble;
	}
	/**
	 * setter method of secundairyDouble
	 * @param double numberValue
	 */
	public void setSecundairyDouble(double numberValue){
		this.secundairyDouble = numberValue;
	}
	/**
	 * getter method of usedMathToken
	 * @return String usedMathToken
	 */
	public String getUsedMathToken(){
		return this.usedMathToken;
	}
	/**
	 * setter method of usedMathToken
	 * @param String tokenValue
	 */
	public void setUsedMathToken(String tokenValue){
		this.usedMathToken = tokenValue;
	}
	/**
	 * getter method of alReadyCalculated
	 * @return boolean alReadyCalculated
	 */
	public boolean getAlReadyCalculated(){
		return this.alReadyCalculated;
	}
	/**
	 * setter method of alReadyCalculated
	 * @param String calculatedValue
	 */
	public void setAlReadyCalculated(boolean calculatedValue){
		this.alReadyCalculated = calculatedValue;
	}
	/**
	 * getter method of newNumberBuffer
	 * @return StringBuffer newNumberBuffer
	 */
	public StringBuffer getNewNumberBuffer(){
		return this.newNumberBuffer;
	}
	/**
	 * method to add number to newNumberBuffer 
	 * also build in option to make the number negative.
	 * @param String numberValue
	 */
	public void addToNewNumberBuffer(String numberValue){
		if(numberValue != "Backspace"){
			if(numberValue != "+/-"){
				this.newNumberBuffer.append(numberValue);
			}else{
				String numberTEMP = this.newNumberBuffer.toString();
				if(this.newNumberBuffer.charAt(0) != '-'){
					this.newNumberBuffer.delete(0, this.newNumberBuffer.length());
					this.newNumberBuffer.append("-");
					this.newNumberBuffer.append(numberTEMP);
				}else{
					this.newNumberBuffer.deleteCharAt(0);
				}	
			}
		}else{
			try{
				this.newNumberBuffer.deleteCharAt(this.newNumberBuffer.length()-1);
			}catch(Exception e){
				//do nothing
			}
		}

	}
	/**
	 * method to clear numberBuffer for a new round
	 */
	public void clearNewNumberBuffer(){
		this.newNumberBuffer.delete(0, this.newNumberBuffer.length());
	}
	/**
	 * getter method of totalSumBuffer
	 * @return StringBuffer totalSumBuffer
	 */
	public StringBuffer getTotalSumBuffer(){
		return this.totalSumBuffer;
	}
	/**
	 * method to add sum to totalSumBuffer
	 * @param String sumValue
	 */
	public void addToTotalSumBuffer(String sumValue){
		this.totalSumBuffer.append(sumValue);
	}
	/**
	 * method to add double (and round up decimals) to totalSumBuffer
	 * @param double sumValue
	 */
	public void addToTotalSumBuffer(double sumValue){
		this.totalSumBuffer.append(df.format(sumValue));
	}
	/**
	 * method to clear totalSumBuffer
	 */
	public void clearTotalSumBuffer(){
		this.totalSumBuffer.delete(0, this.totalSumBuffer.length());
	}
	/**
	 * calculate with the given numbers.
	 * use mathcalculation class
	 */
	public void doMath(){
		if(this.usedMathToken == "+"){
			this.baseDouble = this.mathcalculation.plus(this.baseDouble, this.secundairyDouble);
		}else if(this.usedMathToken == "-"){
			this.baseDouble = this.mathcalculation.minus(this.baseDouble,  this.secundairyDouble);
		}else if(this.usedMathToken == "*"){
			this.baseDouble = this.mathcalculation.multiply(this.baseDouble,  this.secundairyDouble);
		}else if(this.usedMathToken == "/"){
			this.baseDouble = this.mathcalculation.divide(this.baseDouble, this.secundairyDouble);
		}else if(this.usedMathToken == "√"){
			this.baseDouble = this.mathcalculation.sqrt(this.baseDouble);
		}else if(this.usedMathToken == "%"){
			this.baseDouble = this.mathcalculation.procentOf(this.baseDouble, this.secundairyDouble);
		}else if(this.usedMathToken == "1/x"){
			this.baseDouble = this.mathcalculation.oneDivideX(this.baseDouble);
		}
	}
	/**
	 * method to clear total sum or last number input
	 * if all = true: clear all
	 * else: last number
	 * @param boolean all
	 */
	public void clearSum(boolean all){
		if(all){
			this.clearNewNumberBuffer();
			this.setBaseDouble(0.00);
			this.setSecundairyDouble(0.00);
			this.display.setSecundairyDisplay(null);
			this.clearTotalSumBuffer();
		}
		this.clearNewNumberBuffer();
		this.display.setMainDisplay(0.00);
	}
	
	/**
	 * method to check if input has to be saved in baseDouble of secundairyDouble
	 */
	public void addInputToDouble(){
		if(this.getUsedMathToken() == null || this.getUsedMathToken() == "="){
			this.setBaseDouble(Double.parseDouble(this.newNumberBuffer.toString()));
			this.display.setMainDisplay(this.baseDouble);
		}else{
			this.setSecundairyDouble(Double.parseDouble(this.newNumberBuffer.toString()));
			this.display.setMainDisplay(this.secundairyDouble);
		}
	}
	
}
