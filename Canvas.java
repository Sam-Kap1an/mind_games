import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canvas extends JPanel implements KeyListener, ActionListener {

    Player player;
    List<Platform> platforms;
    private Physics pe;
    private long prevTime;
    private boolean hasKeyBeenPressed = false;
    private double jumpStrength = 0;

    public Canvas() {
		setBackground(Color.BLACK);
        this.player = new Player();
        this.platforms = new ArrayList<Platform>();
        for (int i = 0; i < 6; i ++) {
            this.platforms.add(new Platform(i*125, 500, 35, 5));
            // this.platforms.add(new Platform(i*125+75, 475, 35, 5));
        }
         //this.platforms.add(new Platform(300, 20, 5, 400));
        
        this.pe = new Physics(this.player, this.platforms);
        Timer timer = new Timer(1000 / 30, this);
        timer.start();
        

	}
	
	@Override
	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.pe.updatePhysics();
            player.draw(g);
            for (Platform p : this.platforms) {
                p.draw(g);
            }
            g.setColor(Color.WHITE);

            getJumpStrength();
            player.drawArrow(g, (long) (this.jumpStrength * 3000));



            g.setColor(Color.BLUE);
            g.fillRect(625, 500, 35, 5);
            repaint();
	}


    @Override
    public void keyTyped(KeyEvent e) {

        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            player.setVelX(0);
            player.setVelY(0);
            player.setX(20);
            player.setY(300);
        }
        if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (hasKeyBeenPressed == false)) {
            this.prevTime = System.currentTimeMillis();
            hasKeyBeenPressed = true;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setVelX(-.05);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setVelX(.05);
        }
       
    }

    private void getJumpStrength() {
        int engagement = Blackboard.getInstance().getEngagement();
        this.jumpStrength = engagement/200.0;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            hasKeyBeenPressed = false;
            if (player.getVelX() == 0) {
                long currentTime =  System.currentTimeMillis();
//                double hyp = Math.pow((currentTime-this.prevTime),1.5)/250000.0;
                double hyp = this.jumpStrength;
                player.setVelX(hyp * .55);
                player.setVelY(hyp * -.85);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setVelX(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setVelX(0);
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
