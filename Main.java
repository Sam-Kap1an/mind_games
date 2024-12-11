import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
		frame.setTitle("Mind Control Platformer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
