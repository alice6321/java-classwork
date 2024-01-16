import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 

 class HelloBrowseDB implements ActionListener {
  JFrame f;
  JTextField t1, t2,t3;
  JButton b1,b2;
  JLabel lab;
  int cur = 0;
  
  HelloBrowseDB(){
  
    f = new JFrame("HelloBrowseDB");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    b = new JButton("HelloEvent");
    b.addActionListener(this);
    c.add(b);
    f.setSize(600,400);
    f.setVisible(true);
  }