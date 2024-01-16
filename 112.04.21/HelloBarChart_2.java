import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import java.sql.*;

     
public class HelloBarChart_2 {

  public HelloBarChart_2(String appTitle) {
    JFrame f = new JFrame("HelloBarChart_2");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    CategoryDataset dataset = createDataset();
    JFreeChart chart=ChartFactory.createBarChart(
    "car Usage Statistics", "Category", "Score",
    dataset,
    PlotOrientation.VERTICAL,
    true,true,false
    );
   
    ChartPanel panel=new ChartPanel(chart);
    c.add(panel);
    
    f.pack();
    f.setVisible(true);
  }
  
  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:db1.db");
      con.setAutoCommit(false);
      
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM car");
      
      // columnName, columnCount
      ResultSetMetaData rsmd = rs.getMetaData();
      
      while (rs.next()) {
        String company = rs.getString(1);
        Double speed = rs.getDouble(2);
        Double user_rating = rs.getDouble(3);
        Double millage = rs.getDouble(4);
        Double safety = rs.getDouble(5);
        dataset.addValue(speed , company ,rsmd.getColumnName(2));
        dataset.addValue(user_rating , company ,rsmd.getColumnName(3));
        dataset.addValue(millage , company ,rsmd.getColumnName(4));
        dataset.addValue(safety , company ,rsmd.getColumnName(5));
      }
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + " : " + e.getMessage());
      System.exit(0);
    }
    return dataset;
  }
  
  public static void main(String[] args) throws Exception {
    HelloBarChart_2 example = new HelloBarChart_2("HelloBarChart_2");
  }
}