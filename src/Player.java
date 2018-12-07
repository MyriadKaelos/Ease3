import java.awt.*;

public class Player {
    int width;
    int height;
    int speed;
    int shotSpeed;
    boolean[] stop;
    boolean[] move;
    Color color;
    public Player(int width, int height, int speed, int shotSpeed, Color color) {
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.shotSpeed = shotSpeed;
        this.color = color;
        this.move = new boolean[]{false,false,false,false};
        this.stop = new boolean[]{false,false,false,false};
    }
}
