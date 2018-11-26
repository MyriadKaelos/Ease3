import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;

//THIS ENTIRE CLASS IS AN EXAMPLE OF HOW THIS PACKAGE WILL BE USED
class Example extends Ease {
    int x = 0;
    int y = 0;
    public Example(int width, int height, int res) throws InterruptedException {
        super(width, height, res);
    }
    public static void main(String[] args) throws InterruptedException {
        Example e = new Example(400,400, 4);
    }
    public void paint() {
        rect(x,y,50,50,black);
        character(10,10);
    }
    public void background(int x, int y) {

    }
    public void character(int x, int y) {
        rect((width-x)/2,(height-y)/2,x,y,Color.getHSBColor(0,0,(float) 0.3));
    }
    public void keyPressed(KeyEvent e) {
//        System.out.println("'" + e.getKeyChar() + "' was pressed.");
        if(e.getKeyChar() == 'w') {
            y++;
        }
        if(e.getKeyChar() == 'a') {
            x++;
        }
        if(e.getKeyChar() == 's') {
            y--;
        }
        if(e.getKeyChar() == 'd') {
            x--;
        }

    }
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse " + e.getButton() + " was pressed at, (" + e.getX() + "," + e.getY() + ")");
    }
}
