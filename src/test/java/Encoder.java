import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Encoder implements PropertyChangeListener{

	private double jumpStrength;


	public Encoder() {
		this.jumpStrength = 0;
	}


	public double getJumpStrength() {
		return this.jumpStrength;
	}

	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("Engagement".equals(evt.getPropertyName())) {
			this.jumpStrength = ((int) evt.getNewValue())/200.0;
		}
    }

	private void setJumpStrength(double jumpStrength) {
		this.jumpStrength = jumpStrength;
	}

}