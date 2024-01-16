import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloText2 implements ActionListener {
  JFrame f;
  JLabel lab;
  JTextField txt;
  JTextArea ta;
  String msg = "";
  
  HelloText2() {
    f = new JFrame("HelloText2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    lab = new JLabel("Enter your guess");
    c.add(lab);
    txt = new JTextField(10);
    txt.addActionListener(this);
    c.add(txt);
    ta = new JTextArea(10,50);
    ta.setEnabled(false);
    c.add(ta);
    
    f.setSize(600,400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    msg = msg + txt.getText() + "\n";
    ta.setText(msg);
    txt.setText("");                                            
  }
  
  public static void main(String[] args) {
    new HelloText2();
  }
}