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

	public Engine(){
		this.mathcalculation = new MathCalculation();
		this.display = new Display();
	}
	
	public double getBaseDouble(){
		return this.baseDouble;
	}
	public void setBaseDouble(double numberValue){
		this.baseDouble = numberValue;
	}
	public double getSecundairyDouble(){
		return this.secundairyDouble;
	}
	public void setSecundairyDouble(double numberValue){
		this.secundairyDouble = numberValue;
	}
	public String getUsedMathToken(){
		return this.usedMathToken;
	}
	public void setUsedMathToken(String tokenValue){
		this.usedMathToken = tokenValue;
	}
	public boolean getAlreadyCalculated(){
		return this.alReadyCalculated;
	}
	public void setAlreadyCalculated(boolean calculatedValue){
		this.alReadyCalculated = calculatedValue;
	}
	public StringBuffer getNewNumberBuffer(){
		return this.newNumberBuffer;
	}
	public void addToNewNumberBuffer(String numberValue){
		this.newNumberBuffer.append(numberValue);
	}
	public void clearNewNumberBuffer(){
		this.newNumberBuffer.delete(0, this.newNumberBuffer.length());
	}
	public StringBuffer getTotalSumBuffer(){
		return this.totalSumBuffer;
	}
	public void addToTotalSumBuffer(String sumValue){
		this.totalSumBuffer.append(sumValue);
	}
	public void clearTotalSumBuffer(){
		this.totalSumBuffer.delete(0, this.totalSumBuffer.length());
	}
}
