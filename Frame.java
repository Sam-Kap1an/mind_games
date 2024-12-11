import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame {
    
	public Frame() {
		setJMenuBar(createMenuBar());
		setLayout(new GridLayout(1, 1));
        

		Canvas d = new Canvas();
		this.add(d);
        this.addKeyListener(d);

	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem start = new JMenuItem("Start client");
		JMenuItem stop = new JMenuItem("Stop client");
		menu.add(start);
		menu.add(stop);
		menuBar.add(menu);
		return menuBar;
	}

	
}
