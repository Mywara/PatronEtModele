package layer.applications;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import layer.agents.Agent;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class AndroidApplicationImpl implements Application {

	public String name;

	public AndroidApplicationImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void afficher(String s) {
		System.out.println(s);
	}

	@Override
	public void getNotifications(Agent ag) {
	
	}

	@Override
	public void run() {
		
	}

}
