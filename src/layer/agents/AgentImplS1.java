package layer.agents;

import java.util.Date;
import layer.sensors.data.DataDouble;
/**
 * 
 * @author Hamid Mcheick
 *
 */

public class AgentImplS1 implements Agent {

	private double standardValue;
	private double threshold;
	private DataDouble data;
	private String name;
	
	public AgentImplS1(String name, double stdValue, double threshold) {
		this.name = name;
		this.standardValue = stdValue;
		this.threshold = threshold;
	}

	public void forwardData() {
		
	}

	@Override
	public boolean isDataAbnormal() {
		double maxValue = this.standardValue + this.threshold;
		double minValue = this.standardValue - this.threshold;
		
		if((this.data.getValue()> maxValue) || (this.data.getValue() < minValue)){
			return true;
		}
		
		return false;
	}

	@Override
	public void collectData(Object data) {
		this.data = (DataDouble) data;
		
		if(isDataAbnormal()){
			this.forwardData();
		}
		
		//log des data dans le fichier XML
	}

	@Override
	public Object getData() {
		return this.data;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
