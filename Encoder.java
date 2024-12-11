import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Encoder implements PropertyChangeListener{

	private int engagement;
	private int jump_height;


	public Encoder() {
		this.jump_height = 0;
	}


	public int getJump_height() {
		return this.jump_height;
	}

	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("jump_height".equals(evt.getPropertyName())) {
            jump_height = (int) evt.getNewValue();
			setJump_height(jump_height);
        }
    }

	private void setJump_height(int h) {
		this.jump_height = h;
	}

}