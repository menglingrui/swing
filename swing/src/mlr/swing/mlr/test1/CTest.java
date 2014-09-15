package mlr.swing.mlr.test1;

import javax.swing.*;
import javax.swing.table.*;

public class CTest {
 public static void main(String args[]) {
  JFrame jf = new JFrame("Table with cell spanning");

  CMap m = new CMap1();
  DefaultTableModel tm = new DefaultTableModel( 16, 10 ){
   public boolean isCellEditable( int indexRow, int indexColumn )
   {
    return false;
   }
  };
  //tm.isCellEditable( 16, 10 );
  tm.setValueAt( "port1", 0, 0);//对一个合并的单元格填一个数据。
  jf.getContentPane().add(new JScrollPane(new CTable(m, tm)));
  jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
  jf.setSize(500, 500);
  jf.show();
 }
}