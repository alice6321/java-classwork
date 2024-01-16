import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HelloBrowseDB implements ActionListener {
  JFrame f;
  JTextField t1, t2, t3,t4,t5,t6,t7,t8;
  JButton b1, b2;
  JLabel lab;
  int cur = 0;

  HelloBrowseDB() {
    
    f = new JFrame("HelloBrowseDB");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    t1 = new JTextField(10);
    t1.addActionListener(this);
    c.add(t1);
    t2 = new JTextField(15);
    t2.addActionListener(this);
    c.add(t2);
    t3 = new JTextField(10);
    t3.addActionListener(this);
    c.add(t3);
    t4 = new JTextField(10);
    t4.addActionListener(this);
    c.add(t4);
    t5 = new JTextField(20);
    t5.addActionListener(this);
    c.add(t5);
    t6 = new JTextField(10);
    t6.addActionListener(this);
    c.add(t6);
    t7 = new JTextField(20);
    t7.addActionListener(this);
    c.add(t7);
    t8 = new JTextField(10);
    t8.addActionListener(this);
    c.add(t8);
    
    b1 = new JButton("Prev");
    b1.addActionListener(this);
    c.add(b1);
    lab = new JLabel("current/Total");
    c.add(lab);
    b2 = new JButton("Next");
    b2.addActionListener(this);
    c.add(b2);
    
    jump(cur);
    
    f.setSize(400, 300);
    f.setVisible(true);
  }
  
  void jump(int cur){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:edu.db");
      c.setAutoCommit(false);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
      
      // rowCount
      stmt = c.createStatement();
      ResultSet r = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM u1_new");
      r.next();
      int count = r.getInt("rowcount");
      r.close();
      
      if (cur < 0)
        cur = 0;
      if (cur >= count - 1)
        cur = count - 1;
      lab.setText(Integer.toString(cur+1) + "/" + Integer.toString(count));
      
      stmt = c.createStatement();
      String sql = " SELECT * FROM u1_new limit " + Integer.toString(cur) + ", 1";
      ResultSet rs = stmt.executeQuery(sql);
      
      while (rs.next()) {
        int id = rs.getInt(1);
        t1.setText(Integer.toString(id));
        String title = rs.getString(2);
        t2.setText(title);
        String attribute = rs.getString(3);
        t3.setText(attribute);
        String city = rs.getString(4);
        t4.setText(city);
        String address = rs.getString(5);
        t5.setText(address);
        String phone = rs.getString(6);
        t6.setText(phone);
        String url = rs.getString(7);
        t7.setText(url);
        String type = rs.getString(8);
        t8.setText(type);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b2)
      cur += 1;
    if (e.getSource() == b1)
      cur -= 1;
    jump(cur);
  }
    
  public static void main(String[] args) {
    new HelloBrowseDB();
  }
}