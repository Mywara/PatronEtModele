package layer.agents;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public abstract aspect ObserverProtocol {
	
	protected interface Subject { };
	protected interface Observer { };

	private HashMap<Subject, List<Observer>> perSubjectObservers;

	protected List<Observer> getObservers(Subject s) {

		if (perSubjectObservers == null)
			perSubjectObservers = new HashMap<Subject, List<Observer>>();

		List<Observer> observers = (List<Observer>) perSubjectObservers.get(s);

		if (observers == null) {
			observers = new LinkedList<Observer>();
			perSubjectObservers.put(s, observers);
		}

		return observers;
	}

	public void addObserver(Subject s, Observer o) {
		getObservers(s).add(o);
	}

	public void removeObserver(Subject s, Observer o) {
		getObservers(s).remove(o);
	}
}
