import java.awt.Color;
import java.awt.Graphics;

public class Platform {

    int width;
    int height;
    int x;
    int y;
    public Platform(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void handleCollision(Player player) {
        // Get Player's bounding box
        int playerX = (int) player.getX();
        int playerY = (int) player.getY();
        int playerWidth = player.getWidth();
        int playerHeight = player.getHeight();

        // Check if there's an overlap
        if (playerX < x + width &&
            playerX + playerWidth > x &&
            playerY < y + height &&
            playerY + playerHeight > y) {

            // Determine the smallest overlap direction
            int overlapLeft = (playerX + playerWidth) - x; // From left
            int overlapRight = (x + width) - playerX;     // From right
            int overlapTop = (playerY + playerHeight) - y; // From top
            int overlapBottom = (y + height) - playerY;    // From bottom

            // Resolve collision in the direction of the smallest overlap
            int smallestOverlap = Math.min(Math.min(overlapLeft, overlapRight),
                                           Math.min(overlapTop, overlapBottom));

            if (smallestOverlap == overlapTop) {
                // Resolve upward
                player.setY(y - playerHeight);
                player.setVelY(0);
                player.setVelX(Math.max(0, player.getVelX()-.01));
            } else if (smallestOverlap == overlapBottom) {
                // Resolve downward
                player.setY(y + height+1);
                player.setVelY(-1 * player.getVelY());
            } else if (smallestOverlap == overlapLeft) {
                // Resolve left
                player.setX(x - playerWidth);
                player.setVelX(0); // Stop horizontal motion
            } else if (smallestOverlap == overlapRight) {
                // Resolve right
                player.setX(x + width);
                player.setVelX(0);
            }
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLUE); // Set the color for the platform
        g.fillRect(x, y, width, height); // Draw the filled rectangle
    }



}
