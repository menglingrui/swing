package mlr.swing.mutilinetip;  
import java.awt.Dimension;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Toolkit;  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.StringReader;  
import java.util.Enumeration;  
import java.util.Vector;  
import javax.swing.JComponent;  
import javax.swing.JToolTip;  
import javax.swing.SwingUtilities;  
import javax.swing.plaf.metal.MetalToolTipUI;  
/** 
 * 可显示多行的ToolTip 
 * 
 * @author monitor 
 * Created on 2011-2-26, 22:12:06 
 */  
public class MultiLineToolTip extends JToolTip {  
    public MultiLineToolTip() {  
        setUI(new MultiLineToolTipUI());  
    }  
    private class MultiLineToolTipUI extends MetalToolTipUI {  
        private String[] strs;  
        private int maxWidth = 0;  
        @Override  
        public void paint(Graphics g, JComponent c) {  
            FontMetrics metrics = c.getFontMetrics(g.getFont());  
            Dimension size = c.getSize();  
            g.setColor(c.getBackground());  
            g.fillRect(0, 0, size.width, size.height);  
            g.setColor(c.getForeground());  
            if (strs != null) {  
                for (int i = 0; i < strs.length; i++) {  
                    g.drawString(strs[i], 3, (metrics.getHeight()) * (i + 1));  
                }  
            }  
        }  
        @Override  
        public Dimension getPreferredSize(JComponent c) {  
            FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(c.getFont());  
            String tipText = ((JToolTip) c).getTipText();  
            if (tipText == null) {  
                tipText = " ";  
            }  
            BufferedReader br = new BufferedReader(new StringReader(tipText));  
            String line;  
            int maxWidth = 0;  
            Vector v = new Vector();  
            try {  
                while ((line = br.readLine()) != null) {  
                    int width = SwingUtilities.computeStringWidth(metrics, line);  
                    maxWidth = (maxWidth < width) ? width : maxWidth;  
                    v.addElement(line);  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
            int lines = v.size();  
            if (lines < 1) {  
                strs = null;  
                lines = 1;  
            } else {  
                strs = new String[lines];  
                int i = 0;  
                for (Enumeration e = v.elements(); e.hasMoreElements(); i++) {  
                    strs[i] = (String) e.nextElement();  
                }  
            }  
            int height = metrics.getHeight() * lines;  
            this.maxWidth = maxWidth;  
            return new Dimension(maxWidth + 6, height + 4);  
        }  
    }  
}  