import java.awt.*;
import javax.swing.JFrame;

public class DisplayImage extends Canvas {

    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("C:\\Users\\mitzi\\OneDrive\\Documents\\CSC 120\\library-heist\\gameover.png");
        g.drawImage(i,0,0,this);
    }

    public static void main(String[] args) {
        DisplayImage img = new DisplayImage();
        JFrame f = new JFrame();
        f.add(img);
        f.setSize(384,480);
        f.setVisible(true);
    }

}