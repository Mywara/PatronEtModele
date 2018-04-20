package layer.sensors;

import java.util.Random;

import layer.agents.Agent;
import layer.sensors.data.DataDouble;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class Sensor1Impl implements Sensor {

	private int id;
	private String name;
	
	private DataDouble value;
	private Agent agent;
	
	
	public Sensor1Impl(int id, String name, String measureUnit) {
		super();
		this.id = id;
		this.name = name;
		this.value = new DataDouble(measureUnit);
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	public Agent getAgent() {
		return agent;
	}
	
	//SETTERS
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMeasureUnit(String measureUnit) {
		this.value.setMeasureUnit(measureUnit);
	}
	public void setValue(double value) {
		this.value.setValue(value);
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
		this.run();
	}

	public void run(){
		
		while(true){
			this.generateValue();
			
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	@Override
	public void sendDataToMyAgent() {
		this.agent.collectData((Object)this.value);
	}

	@Override
	public void generateValue() {
		Random random = new Random();
		double max = 42;
		double min = 34;
		double range = max - min;
	    double scaled = random.nextDouble() * range;
		double r = scaled + min;
		this.setValue(r);
		this.sendDataToMyAgent();
	}
}
