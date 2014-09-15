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
		  data.add("����");
		  data.add("�Ϻ���ѧ");
		  data.add("ɽ��Ϋ��");
		  data.add("�й�");		  
		  dataVector.add(data);
		  
		  
		  
		  Vector data1=new Vector();  
		  data1.add("����1");
		  data1.add("�Ϻ���ѧ1");
		  data1.add("ɽ��Ϋ��1");
		  data1.add("�й�1");		  
		  dataVector.add(data1);
		  
		  Vector data2=new Vector();  
		  data2.add("����2");
		  data2.add("�Ϻ���ѧ2");
		  data2.add("ɽ��Ϋ��2");
		  data2.add("�й�2");		  
		  dataVector.add(data2);
		  
		  Vector names=new Vector();
		  
		  names.add("����");
		  names.add("ѧУ");
		  names.add("סַ");
		  names.add("����");
		//  names.add("����");
		  
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
