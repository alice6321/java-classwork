import java.sql.*;

public class SQLiteDelete{
  public static void main(String[] args) {
    Connection c = null;
    PreparedStatement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:db1.db");
      stmt = c.prepareStatement("DELETE FROM tb1 WHERE id=?");
      stmt.setInt(1, 7);
      stmt.executeUpdate(); 
      System.out.println("DELETE Finish!");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}