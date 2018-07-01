package cn.jssd.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;

public class BookTypeListModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * booktype listÄ£ÐÍ
	 */
	private static final long serialVersionUID = 1L;
	private List<BookType> data = new ArrayList<>();
	private Object item;
	
	public BookTypeListModel() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init() {
		BookType bt = new BookType();
		bt.setDescription("");
		data = DaoFactory.getBookTypeInstence().queryBookType(bt);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public String getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0).getDescription();
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.item;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		this.item = anItem;
	}
}
