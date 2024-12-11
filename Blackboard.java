
import java.beans.PropertyChangeSupport;

public class Blackboard extends PropertyChangeSupport {
	private int	engagement;

	private Blackboard() {
		super(new Object());
		engagement = 0;
	}

	public void setEngagement(int i) {
		engagement = i;
		firePropertyChange("Engagement", null, i);
	}
	
	public int getEngagement() {
		return engagement;
	}
	
}