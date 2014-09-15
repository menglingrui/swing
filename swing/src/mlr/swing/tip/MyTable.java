package mlr.swing.tip;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.table.TableCellRenderer;

import mlr.swing.mutilinetip.MultiLineToolTip;

public class MyTable extends JTable{
    public MyTable(Object[][] playerInfo, String[] names) {
	    super(playerInfo,names);
	}

    
	public String getToolTipText(MouseEvent event) {
        String tip = null;
        Point p = event.getPoint();

        // Locate the renderer under the event location
        int hitColumnIndex = columnAtPoint(p);
        int hitRowIndex = rowAtPoint(p);

        if ((hitColumnIndex != -1) && (hitRowIndex != -1)) {
            TableCellRenderer renderer = getCellRenderer(hitRowIndex, hitColumnIndex);
            Component component = prepareRenderer(renderer, hitRowIndex, hitColumnIndex);

            // Now have to see if the component is a JComponent before
            // getting the tip
            if (component instanceof JComponent) {
                // Convert the event to the renderer's coordinate system
                Rectangle cellRect = getCellRect(hitRowIndex, hitColumnIndex, false);
                p.translate(-cellRect.x, -cellRect.y);
                MouseEvent newEvent = new MouseEvent(component, event.getID(),
                                          event.getWhen(), event.getModifiers(),
                                          p.x, p.y,
                                          event.getXOnScreen(),
                                          event.getYOnScreen(),
                                          event.getClickCount(),
                                          event.isPopupTrigger(),
                                          MouseEvent.NOBUTTON);

                tip = ((JComponent)component).getToolTipText(newEvent);
            }
        }

        // No tip from the renderer get our own tip
        if (tip == null)
            tip = getToolTipText();

        return tip;
    }
	
	public JToolTip createToolTip() {
	    MultiLineToolTip tip = new MultiLineToolTip();
        tip.setComponent(this);
        return tip;
 }
}
