package layer.applications;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class ApplicationJFrame {
	
	private JFrame ecran;
	private Application app;
	protected JTextArea textArea;
	private final static String newline = "\n";

	public ApplicationJFrame(Application app) throws RemoteException {
		this.app = app;
		this.construireEcran();
		this.ecran.setTitle("Application: "+ this.app.getName());
	}

	private void construireEcran() throws RemoteException {
		this.ecran = new JFrame();
		ecran.setSize(300, 200);
		
		ecran.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ApplicationJFrame.this.terminer();
			}
		});
		// Le panneau central
		JPanel panneauCentral = new JPanel(new BorderLayout());
		ecran.add(panneauCentral);		
		textArea = new JTextArea(5, 15);
        textArea.setEditable(false);
        textArea.setVisible(true);
        panneauCentral.add(this.textArea, BorderLayout.CENTER);
		
		ecran.setVisible(true);
	}
	
	private void terminer() {

		this.ecran.dispose();
		System.exit(0);
	}

	public void setNotificationEcran(String notif) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
        textArea.append(dateFormat.format(date)+" - "+notif + newline);
        textArea.setCaretPosition(textArea.getDocument().getLength());
		
	}
	
	
}
