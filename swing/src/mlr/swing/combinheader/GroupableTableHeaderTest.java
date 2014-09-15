package mlr.swing.combinheader;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 *  ��75    75            150     150     75    
    �ߣ�40    40             20     20     40
   ¥�� ˮƽ/��ֱϵ��   A & B  C & D  ¥��  Column A
 * �ϲ���ͷ����
 * 
 * @author Brad.Wu
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GroupableTableHeaderTest extends JFrame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GroupableTableHeaderTest test = new GroupableTableHeaderTest();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(800, 600);
        test.setVisible(true);
    }

    private DefaultTableModel tableModel = new DefaultTableModel() {

        /*
         * ���� Javadoc��
         * 
         * @see javax.swing.table.DefaultTableModel#getColumnCount()
         */
        @Override
        public int getColumnCount() {
            return 6;
        }

        /*
         * ���� Javadoc��
         * 
         * @see javax.swing.table.DefaultTableModel#getRowCount()
         */
        @Override
        public int getRowCount() {
            return 2;
        }

    };

    private JTable table = new JTable(tableModel);

    private JScrollPane scroll = new JScrollPane(table);

    /**
     * @throws HeadlessException
     */
    public GroupableTableHeaderTest() throws HeadlessException {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        GroupableTableHeader tableHeader = new GroupableTableHeader();
        table.setTableHeader(tableHeader);

        DefaultGroup group = new DefaultGroup();
        group.setRow(0);
        group.setRowSpan(2);
        group.setColumn(0);
        group.setHeaderValue("¥��");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(0);
        group.setRowSpan(2);
        group.setColumn(1);
        group.setHeaderValue("ˮƽ/��ֱϵ��");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(0);
        group.setColumn(2);
        group.setColumnSpan(2);
        group.setHeaderValue("A & B");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(1);
        group.setColumn(2);
        group.setHeaderValue("Column A");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(1);
        group.setColumn(3);
        group.setHeaderValue("Column B");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(0);
        group.setColumn(4);
        group.setColumnSpan(2);
        group.setHeaderValue("C & D");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(1);
        group.setColumn(4);
        group.setHeaderValue("Column C");
        tableHeader.addGroup(group);

        group = new DefaultGroup();
        group.setRow(1);
        group.setColumn(5);
        group.setHeaderValue("Column D");
        tableHeader.addGroup(group);

        getContentPane().add(scroll, BorderLayout.CENTER);
    }
}
