import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.Color.blue;
import static java.awt.Color.gray;
import static java.awt.event.KeyEvent.*;

//THIS ENTIRE CLASS IS AN EXAMPLE OF HOW THIS PACKAGE WILL BE USED
class Example extends Ease {
    Player p;
    int x;
    int y;

    public Example(int width, int height, int res, int refreshRate) throws InterruptedException {
        super(width, height, res, refreshRate);
        p = new Player(6,6,2,10,gray);
        x = 0;
        y = 0;
    }
    public static void main(String[] args) throws InterruptedException {
        Example e = new Example(400,400, 2,100);
    }
    public void paint() {
        stopBox(x+50,y+50,30,30,blue);
        rect((width-p.width)/2,(height-p.height)/2,p.width,p.height,p.color);
        move();
    }
    public void move() {
        if(p.move[0] && !p.stop[0]) {
            y+= p.speed;
        }
        if(p.move[1] && !p.stop[1]) {
            y-= p.speed;
        }
        if(p.move[2] && !p.stop[2]) {
            x+= p.speed;
        }
        if(p.move[3] && !p.stop[3]) {
            x-= p.speed;
        }
    }
    public void stopBox(int x,int y,int w,int h,Color color) {
        boolean bottom = (height-p.height)/2 <= y+h && (height-p.height)/2 >= y;
        boolean left = (width+p.width)/2 >= x && (width+p.width)/2 <= x+w;
        boolean right = (width-p.width)/2 <= x+w && (width-p.width)/2 >= x;
        boolean top = (height+p.height)/2 >= y && (height+p.height)/2 <= y+h;
        rect(x,y,w,h,color);
        if(right && (bottom || top)) {
            p.stop[2] = true;
            this.x-=((x+w)-(width-p.width)/2);
        } else {
            p.stop[2] = false;
        }
        if(bottom && (left || right)) {
            p.stop[0] = true;
            this.y-=((y+h)-(height-p.height)/2);
        } else {
            p.stop[0] = false;
        }
        if(left && (bottom || top)) {
            p.stop[3] = true;
            this.x+=((width+p.width)/2 - x);
        } else {
            p.stop[3] = false;
        }
        if(top && (left || right)) {
            p.stop[1] = true;
            this.y+=((height+p.height)/2 - y);
        } else {
            p.stop[1] = false;
        }
    }
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            p.move[0] = true;
        }
        if(e.getKeyChar() == 'a') {
            p.move[2] = true;
        }
        if(e.getKeyChar() == 's') {
            p.move[1] = true;
        }
        if(e.getKeyChar() == 'd') {
            p.move[3] = true;
        }
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            p.move[0] = true;
        }
        if(e.getKeyChar() == 'a') {
            p.move[2] = true;
        }
        if(e.getKeyChar() == 's') {
            p.move[1] = true;
        }
        if(e.getKeyChar() == 'd') {
            p.move[3] = true;
        }
    }
    public void keyReleased(KeyEvent e) {

        if(e.getKeyChar() == 'w') {
            p.move[0] = false;
        }
        if(e.getKeyChar() == 'a') {
            p.move[2] = false;
        }
        if(e.getKeyChar() == 's') {
            p.move[1] = false;
        }
        if(e.getKeyChar() == 'd') {
            p.move[3] = false;
        }
    }
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse " + e.getButton() + " was pressed at, (" + e.getX() + "," + e.getY() + ")");
    }
}
