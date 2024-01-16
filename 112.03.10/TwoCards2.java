import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TwoCards2 extends MouseAdapter {
  int n[ ];
  JLabel lab[ ];

  TwoCards2() {
    JFrame f = new JFrame("TwoCards2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    n = new int[52];
    for (int i = 0; i < 52; i++) {
      n[i] = i;
    }
    Random r = new Random();
    for (int i = 0; i < 52; i++) {
      int x = r.nextInt(52);
      int t = n[i];
      n[i] = n[x];
      n[x] = t;
    } 
    lab = new JLabel[52];
    for (int i = 0; i < 52; i++) {
      String s = "cards/cover.png";
      lab[i] = new JLabel(new ImageIcon(s));
      lab[i].addMouseListener(this);
      c.add(lab[i]);
    } 
    f.setSize(1200,480); 
    f.setVisible(true);
  }
  
  public void mouseClicked(MouseEvent e) {
    for (int i = 0; i < 52; i++) {
      if (e.getSource() == lab[i]) {
        String s = "cards/" + Integer.toString(n[i]) + ".png";
        lab[i].setIcon(new ImageIcon(s));
        break; 
      }
    }     
  }
  
  public static void main(String args[]) {
    new TwoCards2();
  }
}   