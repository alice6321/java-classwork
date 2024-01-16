import javax.swing.*;
import java.awt.*;

public class HelloSwing {
  HelloSwing(){
    JFrame f = new JFrame("HelloSwing");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = f.getContentPane();
    JLabel lab = new JLabel("HelloSwing");
    c.add(lab);
    f.setSize(600,400);
    f.setVisible(true);
  }
  
  public static void main(String[] args){
    new HelloSwing();
  }
}