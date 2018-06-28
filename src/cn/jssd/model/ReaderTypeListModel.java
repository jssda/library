package cn.jssd.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ReaderTypeListModel extends AbstractListModel<String> implements ComboBoxModel<String>{

	private static final long serialVersionUID = 1L;
	private String[] type = {"本科生", "研究生", "教师", "领导", "管理员"};
	private String item = null;
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return type.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return type[index];
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.item;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		this.item = (String) anItem;
	}
}
