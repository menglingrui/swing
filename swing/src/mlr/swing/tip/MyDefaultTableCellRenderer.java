package mlr.swing.tip;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableCellRenderer;

import mlr.swing.mutilinetip.MultiLineToolTip;

public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(
			JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		JComponent conet=(JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		
		
		conet.setToolTipText("按住 Shift 键并单击可关闭所有文档\n按住 Alt 键并单击可关闭其他文档");
		
		
		
		return conet;
	}
	
	public JToolTip createToolTip() {
		    MultiLineToolTip tip = new MultiLineToolTip();
	        tip.setComponent(this);
	        return tip;
	 }

}
