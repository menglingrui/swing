package mlr.swing.tip;
  
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import sun.swing.DefaultLookup;
  
  
public class JtableCellTips {   
       
    private JTable table=null;  
       
    String[] namestooltip={"wow ncp  name","some word"};   
       
    
    public JtableCellTips(){   
    	
        JFrame f = new JFrame();   
        f.setSize(600, 300);   
        Object[][] playerInfo = {   
                { "提里奥.弗丁", "种族不代表荣耀，我见过最高尚的兽人，\n 也见过最卑劣的人类。" },   
                { "莫格莱尼", "生命本身毫无意义，\n只有死亡才能让你了解人性的真谛。"} };   
        String[] Names = { "姓名", "台词" }; 
        
        table=new MyTable(playerInfo, Names);
        
       // table.set
           

	//   table.setCellEditor(anEditor)
	
        
   //    table.get
        
        table = new MyTable(playerInfo, Names);
        
    	table.setDefaultRenderer(table.getColumnClass(0),
				new MyAutoLineTableCellRenderer());
    	
//    	 table.getCellEditor();
         
    	
 //       {   
//            public String getToolTipText(MouseEvent e) {   
//                int row=table.rowAtPoint(e.getPoint());   
//                int col=table.columnAtPoint(e.getPoint());   
//                String tiptextString=null;   
//                if(row>-1 && col>-1){   
//                    Object value=table.getValueAt(row, col);   
//                    if(null!=value && !"".equals(value))   
//                        tiptextString="aa"+"\n"+"bb";//悬浮显示单元格内容  
//                }   
//                return tiptextString;   
//            }   
               
//             protected JTableHeader createDefaultTableHeader() {   
//                    return new JTableHeader(columnModel) {   
//                        public String getToolTipText(MouseEvent e) {   
//                            String tip = null;   
//                            java.awt.Point p = e.getPoint();   
//                            int index = columnModel.getColumnIndexAtX(p.x);   
//                            int realIndex =  columnModel.getColumn(index).getModelIndex();   
//                            return namestooltip[realIndex];   
//                        }   
//                    };   
//                }   
//  
//        };  
        
        table.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {   
                int row=table.rowAtPoint(e.getPoint());   
                int col=table.columnAtPoint(e.getPoint());  
                
           //     ToolTipManager.sharedInstance().unregisterComponent(table);
                
                String tiptextString=null;   
                if(row>-1 && col>-1){   
                    Object value=table.getValueAt(row, col);   
                    if(null!=value && !"".equals(value))   
                        tiptextString=value.toString()+"AAA";//悬浮显示单元格内容                     
                    JLabel lable=new JLabel();                    
                    lable.setText(row+"+++"+col);                   
                    table.setToolTipText("aaaaa");
               }   
               
               
                
            }
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
				
			}
		});
           
        //悬浮提示单元格的值    
//      table.addMouseMotionListener(new MouseAdapter(){  
//          public void mouseMoved(MouseEvent e) {  
//              int row=table.rowAtPoint(e.getPoint());  
//              int col=table.columnAtPoint(e.getPoint());  
//              if(row>-1 && col>-1){   
//                  Object value=table.getValueAt(row, col);  
//                  if(null!=value && !"".equals(value))  
//                      table.setToolTipText(value.toString());//悬浮显示单元格内容  
//                  else   
//                      table.setToolTipText(null);//关闭提示  
//              }   
//          }   
//      });   
           
        JScrollPane scrollPane = new JScrollPane(table);   
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);   
        f.setTitle("单元格悬浮提示");   
        f.setLocationRelativeTo(null);   
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   
        f.setVisible(true);   
           
    }   
    
	public void setTableRenderer(JTable table) {
        TableColumnModel tcm = table.getColumnModel();
        for (int i = 0, n = tcm.getColumnCount(); i < n; i++) {
            TableColumn tc = tcm.getColumn(i);
            tc.setCellRenderer(new MyDefaultTableCellRenderer());
        }
    }
    public static void main(String[] args) {   
        new JtableCellTips();   
    }   
  
}  