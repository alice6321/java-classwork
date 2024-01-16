import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class HelloJTable1 {
public HelloJTable1() {
JFrame f = new JFrame("HelloJTable1");
Container c = f.getContentPane();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
String[] columns = new String[] {"id", "name", "score"};
Object[][] data = new Object[][] {
{1, "Apple", 100},
{2, "Lisa", 71},
{3, "Henry", 89}
};
final Class[] columnClass = new Class[] {
Integer.class, String.class, Integer.class
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
f.setSize(400, 300);
f.setVisible(true);
}
public static void main(String[] args) {
new HelloJTable1();
}
}