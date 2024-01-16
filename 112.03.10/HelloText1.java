import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloText1 implements ActionListener {
  JFrame f;
  JLabel lab;
  JTextField txt;
  
  HelloText1() {
    f = new JFrame("HelloText1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    lab = new JLabel("Enter your guess");
    c.add(lab);
    txt = new JTextField(10);
    txt.addActionListener(this);
    c.add(txt);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(f, txt.getText());
  }
  
  public static void main(String[] args) {
    new HelloText1();
  }
}