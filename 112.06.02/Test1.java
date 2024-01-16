import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
public class Test1 {
  Test1(){
    JFrame f=new JFrame("Test1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c=f.getContentPane();
    JLabel l=new JLabel("Hello");
    c.add(l);
    f.setSize(400,300);
    f.setVisible(true);
  }
  public static void main(String args[]){
    new Test1();
  }
}
