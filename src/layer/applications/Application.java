package layer.applications;

import layer.agents.Agent;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public interface Application extends Runnable {
	
	public String getName();
	public void afficher(String s);
	public void getNotifications(Agent ag);

}
