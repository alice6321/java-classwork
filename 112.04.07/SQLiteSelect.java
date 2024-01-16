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
      while (rs.next()) {
        String title = rs.getString(2);
        String url = rs.getString(7);
        System.out.printf(" %-60s %-40s \n ",title,url);
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