package layer.agents;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class CardioAgentImpl implements Agent {

	private int standardValue;
	private int threshold;
	private int data;
	private String name;
	private String measureUnit;
	
	public CardioAgentImpl(String name, int stdValue, int threshold, String measureU) {
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

	@Override
	public void collectData(Object data) {
		this.data = (int) data;
		
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
