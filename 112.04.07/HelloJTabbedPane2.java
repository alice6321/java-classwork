import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HelloJTabbedPane2 implements ActionListener {
  JButton b1, b2;
  JTabbedPane tp;
  HelloJTabbedPane2() {
    JFrame f = new JFrame("HelloJTabbedPane2");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    b1 = new JButton("Enable");
    b2 = new JButton("Disable");
    JPanel p1 = new JPanel();
    b1.addActionListener(this);
    p1.add(b1);
    JPanel p2 = new JPanel();
    b2.addActionListener(this);
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
    new HelloJTabbedPane2();
  }
}