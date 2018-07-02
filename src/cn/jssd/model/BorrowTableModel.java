package cn.jssd.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.jssd.bean.Borrow;
import cn.jssd.factory.DaoFactory;

public class BorrowTableModel extends AbstractTableModel{

	/**
	 * 借书数据模型
	 */
	private static final long serialVersionUID = 1L;
	private List<Borrow> list = null;
	private String[] title = {"id", "cardId", "status", "createTime", "bookId", "returnTime"};
	
	public BorrowTableModel(Borrow bo) {
		// TODO Auto-generated constructor stub
		list = DaoFactory.getBorrowInstence().BorrowQuery(bo);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case 0:
			return list.get(arg0).getId();
		case 1:
			return list.get(arg0).getCardId();
		case 2:
			return list.get(arg0).getStatus();
		case 3:
			return list.get(arg0).getCreateTime();
		case 4:
			return list.get(arg0).getBookId();
		case 5:
			return list.get(arg0).getReturnTime();
		}
		
		return -1;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return title[column];
	}

}
