package Calculator;

public class MathCalculation {
	/**
	 * Sum: baseDouble + secundairyDouble
	 * @param double baseDouble
	 * @param double secundairyDouble
	 * @return double baseDouble
	 */
	public double plus(double baseDouble, double secundairyDouble){
		baseDouble = baseDouble + secundairyDouble;
		return baseDouble;
	}
	/**
	 * Sum: baseDouble - secundairyDouble
	 * @param double baseDouble
	 * @param double secundairyDouble
	 * @return double baseDouble
	 */
	public double minus(double baseDouble, double secundairyDouble){
		baseDouble = baseDouble - secundairyDouble;
		return baseDouble;
	}
	/**
	 * Sum: baseDouble * secundairyDouble
	 * @param double baseDouble
	 * @param double secundairyDouble
	 * @return double baseDouble
	 */
	public double multiply(double baseDouble, double secundairyDouble){
		baseDouble = baseDouble * secundairyDouble;
		return baseDouble;
	}
	/**
	 * Sum: baseDouble / secundairyDouble
	 * @param double baseDouble
	 * @param double secundairyDouble
	 * @return double baseDouble
	 */
	public double divide(double baseDouble, double secundairyDouble){
		baseDouble = baseDouble / secundairyDouble;
		return baseDouble;
	}
	/**
	 * Sum: square root of baseDouble
	 * @param double baseDouble
	 * @return double baseDouble
	 */
	public double sqrt(double baseDouble){
		baseDouble = Math.sqrt(baseDouble);
		return baseDouble;
	}
	/**
	 * Sum: precent / 100
	 * baseDouble * percent
	 * @param double baseDouble
	 * @param double secundairyDouble
	 * @return double baseDouble
	 */
	public double procentOf(double baseDouble, double precent){
		precent = precent / 100;
		baseDouble = baseDouble * precent;
		return baseDouble;
	}
	/**
	 * Sum: 1 / baseDouble 
	 * @param double baseDouble
	 * @return double baseDouble
	 */
	public double oneDivideX(double baseDouble){
		baseDouble = 1/baseDouble;
		return baseDouble;
	}
}
