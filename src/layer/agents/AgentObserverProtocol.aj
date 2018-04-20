package layer.agents;
import java.util.*;
import layer.applications.*;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public aspect AgentObserverProtocol extends ObserverProtocol {
	
	declare parents: Agent implements Subject;
	declare parents: Application implements Observer;

	protected pointcut subjectChange(Subject s):
		(call (void Agent.forwardData())) && target(s);

	protected void updateObserver(Subject s, Observer o) {
		((Application) o).afficher(((Application) o).getName() + " : " + ((Agent) s).getName() + " : " + ((Agent) s).getData());
		((Application) o).getNotifications((Agent) s);
	}

	after(Subject s): subjectChange(s) {

		Iterator<Observer> iter = getObservers(s).iterator();
		while (iter.hasNext()) {
			updateObserver(s, ((Observer) iter.next()));
		}
	}
}
