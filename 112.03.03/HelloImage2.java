import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HelloImage2 extends JFrame implements MouseListener {
  JLabel lbl;
  ImageIcon img;
  
  HelloImage2() {
    setTitle("HelloImage2");
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = getContentPane();
    img = new ImageIcon("cards/cover.png");
    lbl = new JLabel(img);
    lbl.addMouseListener(this);
    c.add(lbl);
    
    setSize(600, 400);
    setVisible(true);
  }
 
  public void mouseClicked(MouseEvent e) {}
    
  public void mouseEntered(MouseEvent e) {
    Random r = new Random();
    int x = r.nextInt(52);
    System.out.println(x);
    
    String s = "cards/" + Integer.toString(x) + ".png";
    lbl.setIcon(new ImageIcon(s));
    
  }
  public void mouseExited(MouseEvent e) {
    lbl.setIcon(img);
    
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  
  public static void main(String[] args) {
    new HelloImage2();
  }
}