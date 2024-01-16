import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class HelloList1 implements ListSelectionListener {
  JFrame f;
  JList lst;
  
  HelloList1() {
    f = new JFrame("HelloList1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    String gender[] = {"Male1","Male2","Male3","Male4","Male5","Male6","Male7","Male8"};
    
    lst = new JList(gender);
    lst.addListSelectionListener(this);
    lst.setVisibleRowCount(5);
    JScrollPane sp = new JScrollPane(lst);
    c.add(sp);
    
    f.setSize(600, 400);
    f.setVisible(true);
  }
  
  public void valueChanged(ListSelectionEvent e) {
    JOptionPane.showMessageDialog(f,lst.getSelectedValue());
/*
    if (lst.getSelectedIndex() == 0)
    JOptionPane.showMessageDialog(f,"Male");
    if (lst.getSelectedIndex() == 1)
    JOptionPane.showMessageDialog(f,"Female");
*/
  }
  
  public static void main(String[] args) {
    new HelloList1();
  }
}