import java.awt.Color;
import java.awt.Graphics;

public class BouncePlatform extends Platform {

    public BouncePlatform(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void handleCollision(Player player) {
        int playerX = (int) player.getX();
        int playerY = (int) player.getY();
        int playerWidth = player.getWidth();
        int playerHeight = player.getHeight();

        if (playerX < x + width &&
            playerX + playerWidth > x &&
            playerY < y + height &&
            playerY + playerHeight > y) {

            int overlapTop = (playerY + playerHeight) - y;
            int overlapBottom = (y + height) - playerY;

            if (overlapTop < overlapBottom) {
                player.setY(y - playerHeight);
                player.setVelY(-Math.abs(player.getVelY()) * 1.5); 
            } else {
                player.setY(y + height + 1);
                player.setVelY(0);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); 
        g.fillRect(x, y, width, height);
    }
}