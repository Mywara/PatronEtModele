package layer.sensors;

import java.rmi.RemoteException;
import java.util.Random;
import layer.agents.Agent;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class TemperatureSensorImpl implements Sensor {

	private int id;
	private String name;
	private String measureUnit;
	private double value;
	private Agent agent;
	
	
	public TemperatureSensorImpl(int id, String name, String measureUnit, Agent ag) {
		super();
		this.id = id;
		this.name = name;
		this.measureUnit = measureUnit;
		this.agent = ag;
	}
	
	//GETTERS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMeasureUnit() {
		return measureUnit;
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
		this.measureUnit = measureUnit;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void run(){
		SensorJFrame sJFrame = null;
		try {
			sJFrame = new SensorJFrame(this,"images/thermometre.jpg");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		while(true){
			this.generateValue();
			sJFrame.setValueEcran(String.valueOf(this.getValue())+" "+this.getMeasureUnit());
			try {
			    Thread.sleep(5000);
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
