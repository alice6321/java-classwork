import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class HelloRadio2 implements ActionListener {
  JFrame f;
  JRadioButton rb1, rb2, rb3;
  Random r;
  
  HelloRadio2() {
    f = new JFrame("HelloRadio2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    rb1 = new JRadioButton(new ImageIcon("scissor.jpg"));
    rb1.addActionListener(this);
    c.add(rb1);
    rb2 = new JRadioButton(new ImageIcon("rock.jpg"));
    c.add(rb2);
    rb2.addActionListener(this);
    rb3 = new JRadioButton(new ImageIcon("paper.jpg"));
    c.add(rb3);
    rb3.addActionListener(this);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    r = new Random();
    int x = r.nextInt(3);
    
    JLabel lab = new JLabel();
    if (x == 0)
      lab.setIcon(new ImageIcon("scissor.jpg"));
    if (x == 1)
      lab.setIcon(new ImageIcon("rock.jpg"));
    if (x == 2)
      lab.setIcon(new ImageIcon("paper.jpg"));
      
    int y = 0;
    if (e.getSource() == rb1)
      y = 0;
    if (e.getSource() == rb2)
      y = 1;
    if (e.getSource() == rb3)
      y = 2;
      
    String title = "Computer";
    
    if (x == y)
      lab.setText("Draw");
    else if ((x == 0 && y == 2) || (x == 1 && y == 0) || (x == 2 && y == 1))
      lab.setText("You lose");
    else
      lab.setText("You win");
      
    JOptionPane.showMessageDialog(f, lab, title, JOptionPane.INFORMATION_MESSAGE);
  }
  
  public static void main(String[] args) {
    new HelloRadio2();
  }
}