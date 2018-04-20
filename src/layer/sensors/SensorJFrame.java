package layer.sensors;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class SensorJFrame {
	
	private JFrame ecran;
	private JLabel dataValue;
	private Sensor sensor;

	public SensorJFrame(Sensor s, String background) throws RemoteException {
		this.sensor = s;
		this.construireEcran(background);
		this.ecran.setTitle("Capteur: "+ this.sensor.getName());
	}

	private void construireEcran(String background) throws RemoteException {
		this.ecran = new JFrame();
		ecran.setSize(300, 200);
		
		ecran.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				SensorJFrame.this.terminer();
			}
		});
		// Le panneau central
		JPanel panneauCentral = new JPanel(new BorderLayout());
		ecran.add(panneauCentral);
		
		ImageIcon icon = new ImageIcon(background);
		this.dataValue = new JLabel("",JLabel.CENTER);
		JLabel logo = new JLabel("",icon,JLabel.CENTER);
		panneauCentral.add(this.dataValue, BorderLayout.CENTER);
		panneauCentral.add(logo, BorderLayout.NORTH);
		
		ecran.setVisible(true);
	}


	public void setValueEcran(String value) {
		this.dataValue.setText(value);
	}

	private void terminer() {

		this.ecran.dispose();
		System.exit(0);
	}
}
