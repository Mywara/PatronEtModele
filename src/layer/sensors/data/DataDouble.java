package layer.sensors.data;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class DataDouble {

	private double value;
	private String measureUnit;
	
	public DataDouble(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	public DataDouble(String measureUnit, double value) {
		this.measureUnit = measureUnit;
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String toString() {
		return value + " " + measureUnit;
	}
}
