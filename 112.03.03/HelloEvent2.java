import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class HelloEvent2 implements ActionListener { 
  JFrame f;
  JButton b;
  
  HelloEvent2(){
    f = new JFrame("HelloEvent2");
    f.setLayout(new FlowLayout());  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    
    b = new JButton("Click");
    b.addActionListener(this);
    c.add(b);
    
    f.setSize(600,400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e){
    String name = JOptionPane.showInputDialog(f, "Enter your name");
    String number = JOptionPane.showInputDialog(f, "Enter your number");
    JOptionPane.showMessageDialog(f,"Hello ! "+"\n"+" My Name is "+name+"\n"+"My Number is "+number);
  }
  
  public static void main(String[] args){
    new HelloEvent2(); 
  }
}  