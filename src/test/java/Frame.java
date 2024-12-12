import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame {
    
	public Frame() {
		setLayout(new GridLayout(1, 1));
        

		Canvas d = new Canvas();
		Blackboard.getInstance().addPropertyChangeListener(d);

		this.add(d);
        this.addKeyListener(d);

	}


	
}
