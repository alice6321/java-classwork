import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloEvent implements ActionListener {
  JFrame f;
  JButton b;
  HelloEvent(){
    f = new JFrame("HelloEvent");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    b = new JButton("HelloEvent");
    b.addActionListener(this);
    c.add(b);
    f.setSize(600,400);
    f.setVisible(true);
  }
  public void actionPerformed(ActionEvent e){
    JOptionPane.showMessageDialog(f,"HelloEvent");
  }
  public static void main(String[] args){
    new HelloEvent();
  }
}