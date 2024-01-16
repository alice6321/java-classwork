import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloEvent1 implements ActionListener {
  JFrame f ;

  HelloEvent1() {
    f = new JFrame("HelloEvent1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane(); 
    JButton b = new JButton("Click");
    c.add(b);
    b.addActionListener(this);
    
    f.setSize(600,400); // f.pack();
    f.setVisible(true); 
  }
  
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(f, "Hello World");
  }
  
  public static void main(String[] args) {
    new HelloEvent1();
  }
}     