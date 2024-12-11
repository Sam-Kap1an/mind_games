import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Encoder implements PropertyChangeListener{

	private int engagement;
	private String jump_height;


	public Encoder() {
		this.jump_height = "";
	}


	public String getJump_height() {
		return this.jump_height;
	}

	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("jump_height".equals(evt.getPropertyName())) {
            jump_height = (int) evt.getNewValue();
			setJump_height(Integer.toString((int) jump_height.getEngagement()));
        }
    }

	private void setJump_height(String h) {
		this.jump_height = h;
	}

}