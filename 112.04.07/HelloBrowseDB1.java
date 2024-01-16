import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
import java.sql.ResultSet;
import javax.xml.transform.Result;

 class HelloBrowseDB1 implements ActionListener {
  JFrame f;
  JTextField t1, t2,t3;
  JButton b1,b2;
  JLabel lab;
  int cur = 0;
  
  HelloBrowseDB1(){
  
    f = new JFrame("HelloBrowseDB1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    t1 = new JTextField(20);
    t1.addActionListener(this);
    c.add(t1);
    t2 = new JTextField(20);
    t2.addActionListener(this);
    c.add(t2);
    t3 = new JTextField(20);
    t3.addActionListener(this);
    c.add(t3);
    
    b1 = new JButton("Prev") ;
    b1.addActionListener(this);
    c.add(b1);
    lab = new JLabel("current/Total") ;
    c.add(lab);
    b2 = new JButton("Next") ;
    b2.addActionListener(this);
    c.add(b2);
    
    init();
    
    f.setSize(600,400);
    f.setVisible(true);
  }
  
  void init(){
    Connection c = null;
    Statement stmt = null;
    try {
      class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:db1.db");
      c.setAutoCommit(false);
      
      //rowCount 
      stmt = c.createStatement();
      ResultSet r = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM 1");
      r.next();
      int count = r.getInt("rowcount");
      r.close();
      lab.setText(Integer.toString(cur) + "/" + Integer.toString(count));
      
      stmt = c.createStatement();
      String sql ="SELECT * FROM 1 limit"  + Integer.toString(cur) + ",1";
      Result
    } catch(Exception e) {
      
    } finally {
      
    } // end of try
  
  public static void main(String[] args){
    new HelloBrowseDB1(); 
  }
}    