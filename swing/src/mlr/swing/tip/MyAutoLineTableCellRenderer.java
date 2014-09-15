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
		//������Ⱦ��֧�ֶ���
		this.setLineWrap(true);
		//������Ⱦ���ı�
		this.setText((String) value);
		//���ݲ�ͬ�е��ı��ĸ߶ȣ�ȡ���߶������и߶�
        int maxPreferredHeight = 0;   
        for (int i = 0; i < table.getColumnCount(); i++) {   
            setText("" + table.getValueAt(row, i));   
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0);   
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);   
        }   
  
        if (table.getRowHeight(row) != maxPreferredHeight)  // ��������������Ϲæ   
            table.setRowHeight(row, maxPreferredHeight);   
  		
		return this;
	}
	
	

}
