import java.util.List;

public class Physics{

    private final double GRAVITY = -0.00015;

    public Physics() {

    }

    public void updatePhysics(Player player, List<Platform> platforms) {
        double accX = 0;
        double accY = -1 * GRAVITY;
        player.setVelY(player.getVelY()+accY);
        player.setVelX(player.getVelX()+accX);
        if (player.getY() > 550) {
            player.setVelX(0);
            player.setVelY(0);
            player.setX(20);
            player.setY(300);
        } 
        for (Platform p : platforms) {
            p.handleCollision(player);
        }
        
        player.setX(player.getX()+player.getVelX());
        player.setY(player.getY()+player.getVelY());
    }

    
}
