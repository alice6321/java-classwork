import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HelloEvent2 implements MouseListener {
  JLabel lbl ;

  HelloEvent2() {
    JFrame f = new JFrame("HelloEvent2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane(); 
    ImageIcon img = new ImageIcon("cards/cover.png");
    lbl = new JLabel(img);
    lbl.addMouseListener(this);
    c.add(lbl);
    
    f.setSize(600,400); // f.pack();
    f.setVisible(true);
  }
  
  public void mouseClicked(MouseEvent e) {
    Random r = new Random();
    int x = r.nextInt(52);
    System.out.println(x);
    
    String s = "cards/" + Integer.toString(x) + ".png";
    lbl.setIcon(new ImageIcon(s));
  }
  
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  
  public static void main(String[] args) {
    new HelloEvent2();
  }
}     