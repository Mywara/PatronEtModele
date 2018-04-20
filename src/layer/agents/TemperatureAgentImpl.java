package layer.agents;


public class TemperatureAgentImpl implements Agent {

	private double standardValue;
	private double threshold;
	private double data;
	private String measureUnit;
	private String name;
	
	public TemperatureAgentImpl(String name, double stdValue, double threshold, String measureU) {
		this.name = name;
		this.standardValue = stdValue;
		this.threshold = threshold;
		this.measureUnit = measureU;
	}

	public void forwardData() {}

	@Override
	public boolean isDataAbnormal() {
		double maxValue = this.standardValue + this.threshold;
		double minValue = this.standardValue - this.threshold;
		
		if((this.data> maxValue) || (this.data < minValue)){
			return true;
		}
		
		return false;
	}
	/**
	 * 
	 * @author Hamid Mcheick
	 *
	 */
	@Override
	public void collectData(Object data) {
		this.data = (double) data;
		
		if(isDataAbnormal()){
			this.forwardData();
		}
	}

	@Override
	public Object getData() {
		return String.valueOf(this.data)+" "+this.measureUnit;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
