package cn.jssd.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.jssd.bean.Book;
import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;

public class BookTableModel extends AbstractTableModel{

	/**
	 * 图书信息数据模型
	 */
	private static final long serialVersionUID = 1L;
	private String title[] = {"id", "bookId", "bookName", "type", "author", "publisher", "price",
			"collection", "bookshelf", "createTime"};
	private List<Book> list = null;
	
	
	public BookTableModel(Book book) {
		// TODO Auto-generated constructor stub
		list = DaoFactory.getBookInstence().queryBook(book);
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
			return list.get(arg0).getBookId();
		case 2:
			return list.get(arg0).getBookName();
		case 3:
//			return list.get(arg0).getType();
			BookType bt = new BookType();
			bt.setDescription("");
			bt.setType(list.get(arg0).getType());
			List<BookType> lTemp = DaoFactory.getBookTypeInstence().queryBookType(bt);
			return lTemp.get(0).getDescription();
		case 4:
			return list.get(arg0).getAuthor();
		case 5:
			return list.get(arg0).getPublisher();
		case 6:
			return list.get(arg0).getPrice();
		case 7:
			return list.get(arg0).getCollection();
		case 8:
			return list.get(arg0).getBookshelf();
		case 9:
			return list.get(arg0).getCreateTime();

		default:
			break;
		}
		
		return -1;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return title[column];
	}

}
