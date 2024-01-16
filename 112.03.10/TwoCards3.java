import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;

public class TwoCards3 extends MouseAdapter {
  JFrame f;
  int n[];
  JLabel lab[];
  int card1, card2, count = 0;

  TwoCards3() {
    f = new JFrame("TwoCards3");
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
    
    count = 0;
    lab = new JLabel[52];
    for (int i = 0; i < 52; i++) {
      lab[i] = new JLabel(new ImageIcon("cards/cover.png"));
      lab[i].addMouseListener(this);
      c.add(lab[i]);
    }
    
    f.setSize(1020, 480);
    f.setVisible(true);
  }
  public void mouseClicked(MouseEvent e) {
    for (int i = 0; i < 52; i++) {
      if (e.getSource() == lab[i]) {
        String s = "cards/" + Integer.toString(n[i]) + ".png";
        lab[i].setIcon(new ImageIcon(s));
        if (count % 2 == 0) {
          card1 = i;
          count++;
        } else {
          card2 = i;
          if (card1 == card2) {
            JOptionPane.showMessageDialog(f, "Error");
            continue;
          }
          if (n[card1] % 13 == n[card2] % 13) {
            JOptionPane.showMessageDialog(f, "Good job!");
          } else {
            JOptionPane.showMessageDialog(f, "Try Again!");
            lab[card1].setIcon(new ImageIcon("cards/cover.png"));
            lab[card2].setIcon(new ImageIcon("cards/cover.png"));
          }
          count++;
        };
        break;
      };
    };
  }

  public static void main(String args[]) {
    new TwoCards3();
  }
}