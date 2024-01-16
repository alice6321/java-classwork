import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class HelloEvent3 extends MouseAdapter {
  JLabel lbl ;

  HelloEvent3() {
    JFrame f = new JFrame("HelloEvent3");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane(); 
    ImageIcon img = new ImageIcon("cards/cover.png");
    lbl = new JLabel(img);
    c.add(lbl);
    lbl.addMouseListener(this);
    
    f.setSize(600,400); // f.pack();
    f.setVisible(true);
  }
  
  public void mouseClicked(MouseEvent e) {
    Random r = new Random();
    int c = r.nextInt(52); 
    String s = "cards/" + Integer.toString(c) + ".png";
    lbl.setIcon(new ImageIcon(s));
  }
  
  public void mouseEntered(MouseEvent e) {
  lbl.setIcon(new ImageIcon("cards/cover.png"));
  }
  
  public static void main(String[] args) {
    new HelloEvent3();
  }
}     