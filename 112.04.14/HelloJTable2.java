import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class HelloJTable2 {
  public HelloJTable2() {
    JFrame f = new JFrame("HelloJTable2");
    Container c = f.getContentPane();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    
    Object[][] data = null;
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:edu.db");
      con.setAutoCommit(false);
      
      //rowCount
      stmt = con.createStatement();
      ResultSet r = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM u1_new");
      r.next();
      int count = r.getInt("rowcount");
      r.close();
      
      data = new Object[count][8];
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM u1_new");
      int i=0;
      while (rs.next()) {
        data[i][0]=rs.getInt(1);
        data[i][1]=rs.getString(2);
        data[i][2]=rs.getString(3);
        data[i][3]=rs.getString(4);
        data[i][4]=rs.getString(5);
        data[i][5]=rs.getString(6);
        data[i][6]=rs.getString(7);
        data[i][7]=rs.getString(8); 
        i++;
      }
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + " : " + e.getMessage());
      System.exit(0);
    }
    
    String[] columns = new String[] {"id", "title", "attribute","city","address","phone","url","type"};
    
    final Class[] columnClass = new Class[] {
    Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
    };
    DefaultTableModel model = new DefaultTableModel(data, columns) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
      @Override
      public Class < ? > getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
      }
    };
    JTable table = new JTable(model);
    //table.setRowHeight(64);
    c.add(new JScrollPane(table));
    f.setSize(1000, 800);
    f.setVisible(true);
  }
  public static void main(String[] args) {
    new HelloJTable2();
  }
}