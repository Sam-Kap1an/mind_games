import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Physics{
    private Player player;
    private List<Platform> platforms;
    private final double GRAVITY = -0.00015;

    public Physics(Player p, List<Platform> ps) {
        this.player = p;
        this.platforms = ps;
    }

    public void updatePhysics() {
        double accX = 0;
        double accY = -1 * GRAVITY;
        this.player.setVelY(this.player.getVelY()+accY);
        this.player.setVelX(this.player.getVelX()+accX);
        if (this.player.getY() > 550) {
            player.setVelX(0);
            player.setVelY(0);
            player.setX(20);
            player.setY(300);
        } 
        for (Platform p : this.platforms) {
            p.handleCollision(player);
        }
        
        this.player.setX(this.player.getX()+this.player.getVelX());
        this.player.setY(this.player.getY()+this.player.getVelY());
    }

    
}
