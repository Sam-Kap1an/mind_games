import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private double x;
    private double y;
    private final int PLAYER_WIDTH = 20;
    private final int PLAYER_HEIGHT = 20;
    private double velX;
    private double velY;



    public Player() {
        this.x = 0;
        this.y = 300;
        this.velX = 0;
        this.velY = 0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) this.x, (int) this.y, this.PLAYER_WIDTH, this.PLAYER_HEIGHT);

    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return PLAYER_WIDTH;
    }
    public int getHeight() {
        return PLAYER_HEIGHT;
    }

    public void drawArrow(Graphics g, long l) {
        int x1 = (int) (this.x+PLAYER_WIDTH/2.0);
        int y1 = (int) (this.y+PLAYER_HEIGHT/2.0);
        double scalar = Math.pow(l, 1.5)/750.0;
        g.drawLine(x1, y1, (int) (x1 + scalar), (int) (y1-scalar*1.2));
    }

}
