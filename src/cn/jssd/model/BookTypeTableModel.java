package cn.jssd.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;

public class BookTypeTableModel extends AbstractTableModel{

	/**
	 * 图书类型表格数据模块
	 */
	private static final long serialVersionUID = 1L;
	private String[] title = {"id", "type", "brrowingDays", "description"};
	private List<BookType> list = null;
	
	public BookTypeTableModel(BookType bt) {
		// TODO Auto-generated constructor stub
		list = DaoFactory.getBookTypeInstence().queryBookType(bt);
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
			return list.get(arg0).getType();
		case 2:
			return list.get(arg0).getBorrowingDays();
		case 3:
			return list.get(arg0).getDescription();
		default:
			break;
		}
		return -1;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return title[arg0];
	}
	
	
}
