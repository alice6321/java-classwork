import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloRadio1 implements ActionListener {
  JFrame f;
  JRadioButton rb1, rb2, rb3;
  ButtonGroup bg;
  
  HelloRadio1() {
    f = new JFrame("HelloRadio1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    rb1 = new JRadioButton("scissor");
    rb1.addActionListener(this);
    c.add(rb1);
    rb2 = new JRadioButton("rock");
    rb2.addActionListener(this);
    c.add(rb2);
    rb3 = new JRadioButton("paper");
    rb3.addActionListener(this);
    c.add(rb3);
    
    bg = new ButtonGroup();
    bg.add(rb1);
    bg.add(rb2);
    bg.add(rb3);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (rb1.isSelected())
      JOptionPane.showMessageDialog(f,"scissor");
    if (rb2.isSelected())
      JOptionPane.showMessageDialog(f,"rock");
    if (rb3.isSelected())
      JOptionPane.showMessageDialog(f,"paper");
    bg.clearSelection();
  }
  
  public static void main(String[] args) {
    new HelloRadio1();
  }
}