import java.awt.*;
import javax.swing.*;

public class HelloImage1 extends JFrame {
  HelloImage1() {
    setTitle("HelloImage1");
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = getContentPane();
    ImageIcon img = new ImageIcon("cards/cover.png");
    JLabel lbl = new JLabel(img);
    c.add(lbl);
    
    setSize(600, 400);
    setVisible(true);
  }

  public static void main(String[] args) {
    new HelloImage1();
  }
}