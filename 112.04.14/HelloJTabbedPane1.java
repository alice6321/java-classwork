import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJTabbedPane1 implements ActionListener {
  JButton b1, b2;
  JTabbedPane tp;
  
  HelloJTabbedPane1() {
    JFrame f = new JFrame("HelloJTabbedPane1");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    b1 = new JButton("Enable");
    b1.addActionListener(this);
    JPanel p1 = new JPanel();
    p1.add(b1);
    
    b2 = new JButton("Disable");
    b2.addActionListener(this);
    JPanel p2 = new JPanel();
    p2.add(b2);
    
    tp = new JTabbedPane();
    tp.addTab("Login", p1);
    tp.addTab("Game", p2);
    tp.setEnabledAt(1, false);
    
    c.add(tp, BorderLayout.CENTER);
    f.setSize(400, 300);
    f.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      tp.setEnabledAt(1, true);
      tp.setSelectedIndex(1);
    }
    if (e.getSource() == b2) {
      tp.setSelectedIndex(0);
      tp.setEnabledAt(1, false);
    }
  }
  public static void main(String args[]) {
    new HelloJTabbedPane1();
  }
}