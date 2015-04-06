package Calculator;

public class Engine {

	private MathCalculation mathcalculation;
	private Display display;
	private Memory memory;
	private double baseDouble;
	private double secundairyDouble;
	private String usedMathToken;
	private boolean alReadyCalculated;
	private StringBuffer newNumberBuffer;
	private StringBuffer totalSumBuffer;

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
	 * @param String numberValue
	 */
	public void addToNewNumberBuffer(String numberValue){
		this.newNumberBuffer.append(numberValue);
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
	 * method to clear totalSumBuffer
	 */
	public void clearTotalSumBuffer(){
		this.totalSumBuffer.delete(0, this.totalSumBuffer.length());
	}
}
