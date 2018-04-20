package layer.applications;

import java.rmi.RemoteException;

import layer.agents.Agent;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class ApplicationImpl implements Application {
	
	public String name;
	private ApplicationJFrame appJFrame;
	//ajout
	public String s = "initialisation";
	
	
	public ApplicationImpl(String name) {
		this.name = name;
		appJFrame = null;
		try {
			appJFrame = new ApplicationJFrame(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return this.name;
	}

	public void afficher(String s) {
		System.out.println(s);
		//ajout
		this.s = s;
	}
	
	//ajout
	public String getS() {
		return s;
	}

	@Override
	public void getNotifications(Agent ag) {
		appJFrame.setNotificationEcran(String.valueOf(ag.getName()+" : "+ag.getData()));
	}

	@Override
	public void run() {
		
	}
	
}
