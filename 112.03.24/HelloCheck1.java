import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloCheck1 implements ActionListener {
  JFrame f;
  Container c;
  JCheckBox cb1, cb2, cb3;
  
  HelloCheck1() {
    f = new JFrame("HelloCheck1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    c = f.getContentPane();
    c.setBackground(Color.BLACK);
    cb1 = new JCheckBox("red");
    cb1.addActionListener(this);
    c.add(cb1);
    cb2 = new JCheckBox("green");
    cb2.addActionListener(this);
    c.add(cb2);
    cb3 = new JCheckBox("blue");
    cb3.addActionListener(this);
    c.add(cb3);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    int r = 0, g = 0, b = 0;
    if (cb1.isSelected())
      r = 255; 
    if (cb2.isSelected())
      g = 255;
    if (cb3.isSelected())
      b = 255;
    c.setBackground(new Color(r,g,b));
  }
  
  public static void main(String[] args) {
    new HelloCheck1();
  }
}