package mlr.swing.mlr.test;

import java.awt.Color;
import java.awt.PopupMenu;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class SwingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  DefaultTableModel dataModel = new DefaultTableModel();
		  
		  dataModel.setColumnCount(1);
		  
		  Vector dataVector=new Vector();
		  
		  Vector data=new Vector();  
		  data.add("张三");
		  data.add("上海大学");
		  data.add("山东潍坊");
		  data.add("中国");		  
		  dataVector.add(data);
		  
		  
		  
		  Vector data1=new Vector();  
		  data1.add("张三1");
		  data1.add("上海大学1");
		  data1.add("山东潍坊1");
		  data1.add("中国1");		  
		  dataVector.add(data1);
		  
		  Vector data2=new Vector();  
		  data2.add("张三2");
		  data2.add("上海大学2");
		  data2.add("山东潍坊2");
		  data2.add("中国2");		  
		  dataVector.add(data2);
		  
		  Vector names=new Vector();
		  
		  names.add("姓名");
		  names.add("学校");
		  names.add("住址");
		  names.add("国籍");
		//  names.add("其他");
		  
		  dataModel.setDataVector(dataVector, names);
		  
	      JTable table = new JTable(dataModel);
	      
	   
	      table.getColumnModel().getColumn(0).setPreferredWidth(160);
	      
	      table.setRowHeight(100);
	      
	      table.getTableHeader().setBackground(Color.BLUE);
	      
	//      table.getTableHeader().setInputMap(0, map)
	  	      
	      JScrollPane scrollpane = new JScrollPane(table);
	      
	      
	      
	      JFrame frm=new JFrame();
	      
	      frm.setSize(600, 500);
	      
	      frm.setContentPane(scrollpane);
	      
	      frm.show();
	    	  

	      

	}

}
