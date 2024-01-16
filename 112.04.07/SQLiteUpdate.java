import java.sql.*;

public class SQLiteUpdate {
  public static void main(String[] args) {
    Connection c = null;
    PreparedStatement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:db1.db");
      stmt = c.prepareStatement("UPDATE tb1 SET score=? WHERE id=?");
      stmt.setInt(1, 98);
      stmt.setInt(2, 1);
      stmt.executeUpdate(); 
      System.out.println("UPDATE Finish!");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}