import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

class HelloCombo1 implements ActionListener {
  JFrame f;
  JComboBox cb;
  String city[] = {"Yilan","Keelung","New Taipe","Taipei","Taoyuan","Hsinchu ","Miaoli", "Taichung","Changhua","Nantou", "Yunlin","Chiayi","Tainan", "Kaohsiung","Pingtung","Taitung","Hualien"};
  
  HelloCombo1() {
    f = new JFrame("HelloCombo1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    cb = new JComboBox(city);
    cb.addActionListener(this); 
    c.add(cb);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(f, cb.getSelectedItem());
  }
  
  public static void main(String[] args) {
    new HelloCombo1();
  }
}