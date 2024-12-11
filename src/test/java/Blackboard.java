import java.awt.*;
import java.beans.PropertyChangeSupport;

public class Blackboard extends PropertyChangeSupport {
	private int	engagement;
	private static Blackboard instance;

	private Blackboard() {
		super(new Object());
		engagement = 0;
	}

	public static Blackboard getInstance() {
		if (instance == null) {
			instance = new Blackboard();
		}
		return instance;
	}

	public void setEngagement(int i) {
		engagement = i;
		firePropertyChange("Engagement", null, i);
	}
	
	public int getEngagement() {
		return engagement;
	}
	
}