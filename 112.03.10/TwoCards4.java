import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TwoCards4 extends MouseAdapter {
  JFrame f;
  int n[ ];
  JLabel lab[ ];
  ImageIcon img[ [ ];
  TwoCards4() {
    JFrame f = new JFrame("TwoCards4");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    lab[0] = new JLabel(new ImageIcon("scissor.png")
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