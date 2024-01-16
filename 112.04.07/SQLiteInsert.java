import java.sql.*;

public class SQLiteInsert {
  public static void main(String[] args) {
    Connection c = null;
    PreparedStatement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:edu.db");
      stmt = c.prepareStatement("INSERT INTO u1_new (id,name,score) VALUES(?,?,?)");
      stmt.setInt(1, 7);
      stmt.setString(2, "Betty");
      stmt.setInt(3, 59);
      stmt.executeUpdate(); 
      System.out.println("INSERT Finish!");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
  }
}