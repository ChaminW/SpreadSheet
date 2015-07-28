import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class t extends JFrame {
public static void main(String[] args) {
new t().setVisible(true);
}
private t() {
super("Movies!");
String[] columnNames =
{"Title", "Rating", "On Video?"};
Object[][] data = {
{"A Bug's Life", "G", new Boolean(false)},
{"A Civil Action", "PG13", new Boolean(false)},
// ... more movies omitted ...
};
JTable table = new JTable(data, columnNames);
getContentPane().add(new JScrollPane(table),
BorderLayout.CENTER);
pack();
}
}