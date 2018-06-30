package cn.jssd.model;

import javax.swing.table.AbstractTableModel;

public class TestDataTableModel extends AbstractTableModel{

	/**
	 * just a test data
	 */
	private static final long serialVersionUID = 1L;
	String []title = {"姓名", "年龄", "性别", "教育程度"};
	Object [][]info = {
			{"刘浩", 21, "男", "大学本科"},
			{"李浩", 20, "男", "大学本科"},
			{"常泽青", 20, "男", "大学本科"}
	};
			
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return info.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return info[arg0][arg1];
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return this.getValueAt(0, arg0).getClass();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return title[arg0];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

}
