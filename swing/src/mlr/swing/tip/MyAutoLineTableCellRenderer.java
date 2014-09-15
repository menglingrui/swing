package mlr.swing.tip;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class MyAutoLineTableCellRenderer extends JTextArea implements TableCellRenderer, Serializable{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		//设置渲染器支持多行
		this.setLineWrap(true);
		//设置渲染的文本
		this.setText((String) value);
		//根据不同行的文本的高度，取最大高度设置行高度
        int maxPreferredHeight = 0;   
        for (int i = 0; i < table.getColumnCount(); i++) {   
            setText("" + table.getValueAt(row, i));   
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0);   
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);   
        }   
  
        if (table.getRowHeight(row) != maxPreferredHeight)  // 少了这行则处理器瞎忙   
            table.setRowHeight(row, maxPreferredHeight);   
  		
		return this;
	}
	
	

}
