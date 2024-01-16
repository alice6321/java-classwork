import java.awt.*;       
import javax.swing.*;

public class HelloImage1 extends JFrame {
  HelloImage1() {
    setTitle("HelloImage1");
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ClassLoader cl=this.getClass().getClassLoader(); 
    Icon img=new ImageIcon(cl.getResource("cards/cover.png")); 
    JButton b1=new JButton(img);
  
    
    setSize(600, 400);
    setVisible(true);
  }

  public static void main(String[] args) {
    new HelloImage1();
  }
}