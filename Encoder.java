import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Encoder implements PropertyChangeListener{

	private int engagement;
	private String jump_hight;


	public Encoder() {
		this.jump_hight = "";
	}


	public String getJump_hight() {
		return this.jump_hight;
	}

	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("jump_hight".equals(evt.getPropertyName())) {
            jump_hight = (int) evt.getNewValue();
			setJump_hight(Integer.toString((int) jump_hight.getEngagement()));
        }
    }

	private void setJump_hight(String h) {
		this.jump_hight = h;
	}

}