
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Ease extends JPanel implements KeyListener, MouseListener {
    int res;
    int height;
    int width;
    int trueHeight;
    int trueWidth;
    boolean loop;
    Graphics2D g2d;
    Color red = Color.red;
    Color green = Color.green;
    Color blue = Color.blue;
    Color gray = Color.gray;
    Color white = Color.white;
    Color black = Color.black;
    Color cyan = Color.cyan;
    Color yellow = Color.yellow;
    public Ease(int width, int height, int res) throws InterruptedException {
        JFrame frame = new JFrame("Game");
        frame.add(this);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setVisible(true);
        frame.setSize(width,height + 22);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        this.height = height/res;
        this.width = width/res;
        this.trueHeight = height;
        this.trueWidth = width;
        this.res = res;
        this.loop = true;
        while(true) {
            Thread.sleep(100);
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        g2d = (Graphics2D)g;
        paint();
    }
    public void paint() {

    }
    public void resolution() {
        for(int i = 0; i < width; i++) {
            for(int o = 0; o < height; o++) {
                pixel(i,o,Color.getHSBColor((float) i / (float) width, (float) o / (float) height, (float) 1));
            }
        }
    }
    public void pixel(int x, int y, Color color) {
        if(loop) {
            if (x > width) {
                x %= width;
            } else if (x < 0) {
                x = width - (-x%width);
            }
            if (y > height) {
                y %= height;
            } else if (y < 0) {
                y = height - (-y%height);
            }
        }
        g2d.setColor(color);
        g2d.fillRect(x*res,y*res,res,res);
    }
    public void rect(int x, int y, int w, int h, Color color) {
        if(loop) {
            if (x > width) {
                x %= width;
            } else if (x < 0) {
                x = width + x;
            }
            if (y > height) {
                y %= height;
            } else if (y < 0) {
                y = height - (-y%height);
            }
            if (x + w > width) {
                rect(x - width, y, w, h, color);
            }
            if (y + h > height) {
                rect(x, y - height, w, h, color);
            }
        }
        g2d.setColor(color);
        g2d.fillRect(x*res, y*res, w*res, h*res);
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
