import java.sql.*; 

public class SQLiteSelect {
  public static void main(String args[]) {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:edu.db");
      c.setAutoCommit(false);
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM u1_new;");
      
      ResultSetMetaData rsmd = rs.getMetaData();
      int column_count =rsmd.getColumnCount();
      for (int i= 1; i <= column_count;i++ ) {
        String temp =  rsmd.getCatalogName(i);
        System.out.println("%s ",temp);
      } // end of for
      System.out.println();
      
      while (rs.next()) {
        int id = rs.getInt(1);
        System.out.println(id);
        for (int i= 2; i <= column_count;i++ ) {
          String s =  rsmd.getString(i);
          System.out.println("%s ", s);
        }
        System.out.println();
      } 
      rs.close();
      stmt.close();
      c.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + " : " + e.getMessage());
      System.exit(0);
    }
  }
}