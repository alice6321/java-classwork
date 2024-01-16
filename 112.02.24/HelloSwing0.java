import java.awt.*;
import javax.swing.*;
public class HelloSwing0 {
  public static void main(String[] args){
    JFrame f = new JFrame("HelloSwing0");
    f.setLayout(new FlowLayout());  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    JLabel lab = new JLabel("HelloSwing0");
    c.add(lab);
    f.setSize(600,400);
    f.setVisible(true);
  }
}                                             