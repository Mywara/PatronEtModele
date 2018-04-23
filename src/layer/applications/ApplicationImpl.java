package layer.applications;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
		
	}
	public void sendData(String s) {
		StartConnection(s);
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
	
	public static void StartConnection(String data) {
		// System.out.println("Start server");
	    try {
	       ServerSocket srvr = new ServerSocket(1234);
	       Socket skt = srvr.accept();
	     //  System.out.print("Server has connected!\n");
	       PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
	      // System.out.print("Sending string: '" + data + "'\n");
	       out.print(data);
	       out.close();
	       skt.close();
	       srvr.close();
	    }
	    catch(Exception e) {
	       System.out.print("Whoops! It didn't work!\n");
	    }
	}
	
}
