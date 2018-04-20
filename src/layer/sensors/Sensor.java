package layer.sensors;

import layer.agents.Agent;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public interface Sensor extends Runnable{

	public void sendDataToMyAgent();
	public void generateValue();
	public void setAgent(Agent agent);
	public String getName();
}
