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


public class HelloBarChart_1 {

  public HelloBarChart_1(String appTitle) {
    JFrame f = new JFrame("HelloBarChart_1");
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container c = f.getContentPane();
    CategoryDataset dataset = createDataset();
    JFreeChart chart=ChartFactory.createBarChart(
    "", "年度", "百萬人口數",
    dataset,
    PlotOrientation.VERTICAL,
    true,true,false
    );
    chart.setTitle(new TextTitle("條狀圖範例",new Font("正楷體",Font.BOLD,28)));
    
    LegendTitle legend = chart.getLegend(0);
    legend.setItemFont(new Font("正楷體",Font.BOLD,24));
    
    CategoryPlot plot = chart.getCategoryPlot();
    Font chfont = new Font("正楷體",Font.BOLD,20);
    plot.getDomainAxis().setLabelFont(chfont);
    plot.getRangeAxis().setLabelFont(chfont);
    
    ChartPanel panel=new ChartPanel(chart);
    c.add(panel);
    
    f.pack();
    f.setVisible(true);
  }
  
  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset =
       new DefaultCategoryDataset();
    dataset.addValue(10, "中國", "2005");
    dataset.addValue(30, "日本", "2005");
    dataset.addValue(20, "中國", "2010");
    dataset.addValue(25, "日本", "2010");
    dataset.addValue(15, "中國", "2015");
    dataset.addValue(40, "日本", "2015");
    return dataset;
  }
  public static void main(String[] args) throws Exception {
    HelloBarChart_1 example =
    new HelloBarChart_1("HelloBarChart_1");
  }
}