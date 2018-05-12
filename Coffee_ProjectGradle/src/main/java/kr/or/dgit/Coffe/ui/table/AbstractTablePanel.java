package kr.or.dgit.Coffe.ui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.Coffe.dto.Rank;

@SuppressWarnings("serial")
public abstract class AbstractTablePanel extends JPanel {
	protected JTable table;
	protected NonEditableModel model;
	protected int selectRowIndex;
	protected Object[] colNames;

	public AbstractTablePanel() {
		
	}
	public AbstractTablePanel(String title) {
		initComponents(title);
		setColumnNames();
	}

	private void initComponents(String title) {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		scrollPane.setViewportView(table);
		
	}
	
	protected abstract void setAlignWith();
		
	protected abstract void setColumnNames();


	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table.getColumnModel();
		System.out.println(table.getColumnModel());
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableSetWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			// 문제는 여기인가
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void loadData(List<Rank> items) {
		Object[][] datas = toArray(items);
		model = new NonEditableModel(datas, colNames);
		table.setModel(model);
		setAlignWith();
	}

	protected Object[][] toArray(List<Rank> items) {
		Object[][] results = new Object[items.size()][];
		for (int i = 0; i < items.size(); i++) {
			results[i] = items.get(i).toArray();
		}
		return results;
	}

	class NonEditableModel extends DefaultTableModel {
		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

}
