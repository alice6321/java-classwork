import java.awt.*;
import javax.swing.*;
public class HelloSwing1 {
  HelloSwing1(){
    JFrame f = new JFrame("HelloSwing1");
    f.setLayout(new FlowLayout());  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    ImageIcon img = new  ImageIcon("kitty.gif");
    JLabel lab = new JLabel(img);
    c.add(lab);
    
    f.setSize(600,400);
    f.setVisible(true);
  }
  public static void main(String[] args){
    new HelloSwing1();
  }
}                                             