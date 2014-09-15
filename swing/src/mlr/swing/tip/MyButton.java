package mlr.swing.tip;  
  
import java.awt.event.ActionListener;  
  
import javax.swing.JButton;  
import javax.swing.JToolTip;  

import mlr.swing.mutilinetip.MultiLineToolTip;
  
public class MyButton extends JButton {  
  
     private static final long serialVersionUID = -4212536258012660909L;  
      
     private ActionListener toolTipBtnListener;  
      
     public MyButton() {  
          super();  
     }  

      
     public void addToolTipBtnListener(ActionListener l) {  
          toolTipBtnListener = l;  
     }  
      
     public JToolTip createToolTip() {  
          setToolTipText("��ס Shift ���������ɹر������ĵ�\n" +
          		"��ס Alt ���������ɹر������ĵ�"); 
          return new MultiLineToolTip();  
     }  
}  