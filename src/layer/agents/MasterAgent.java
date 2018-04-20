package layer.agents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import layer.applications.*;
import layer.sensors.Sensor;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class MasterAgent {
	private ArrayList<Sensor> sensorsList;
	private ArrayList<Application> applicationsList;
	private AgentObserverProtocol protocol;
	private Map<Agent, Application> agApMap;

	public MasterAgent() {		
		protocol = layer.agents.AgentObserverProtocol.aspectOf();
	}

	public void setSensorsList(ArrayList<Sensor> sensorsList) {
		this.sensorsList = sensorsList;
	}
	
	public void setApplicationsList(ArrayList<Application> appList) {
		this.applicationsList = appList;
	}

	public void setAgApMap(Map<Agent, Application> map) {
		this.agApMap = map;
	}
	
	public void start() {
		Set agents = this.agApMap.keySet();
		Iterator itMap = agents.iterator();
		while (itMap.hasNext()){
		   Agent ag = (Agent) itMap.next(); 
		   Application ap = this.agApMap.get(ag);
		   this.protocol.addObserver(ag,ap);
		}
		
		Iterator<Sensor> itS = this.sensorsList.iterator(); 
		while (itS.hasNext()) {
		       Sensor s = itS.next();
		       (new Thread(s)).start();
		}
		
		Iterator<Application> itA = this.applicationsList.iterator(); 
		while (itA.hasNext()) {
		       Application app = itA.next();
		       (new Thread(app)).start();
		}
	}
	
	
	
}
