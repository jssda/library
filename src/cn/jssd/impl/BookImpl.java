package cn.jssd.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jssd.bean.Book;
import cn.jssd.dao.BookDao;
import cn.jssd.util.DBUtil;

public class BookImpl implements BookDao {

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		String bookId = book.getBookId();
		String bookName = book.getBookName();
		Integer type = book.getType();
		String author = book.getAuthor();
		String publisher = book.getPublisher();
		Double price = book.getPrice();
		Integer collection = book.getCollection();
		Integer bookshelf = book.getBookshelf();
		java.sql.Timestamp createTime = new Timestamp(new java.util.Date().getTime());
		
		if(bookId == null || "".equals(bookId) || "".equals(bookName) || "".equals(author) ||
				"".equals(publisher) || price == null || collection == null || bookshelf == null) {
			flag = false;
		} else {
			String sql = "insert into b_book_tab"
					+ "(id, " + 
					" bookId," + 
					" bookName," + 
					" TYPE," + 
					" author," + 
					" publisher," + 
					" price," + 
					" collection," + 
					" bookshelf," + 
					" createTime) "
					+ "values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			Connection conn = DBUtil.getInstence();
			PreparedStatement ps = null;
			int count = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, bookId);;
				ps.setString(2, bookName);
				ps.setInt(3, type);
				ps.setString(4, author);
				ps.setString(5, publisher);
				ps.setDouble(6, price);
				ps.setInt(7, collection);
				ps.setInt(8, bookshelf);
				ps.setTimestamp(9, createTime);
				
				count = ps.executeUpdate();
				if(count == 0) {
					flag = false;
				} else {
					flag = true;
				}
				
			} catch(SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "图书编号重复", "错误", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("插入图书出错啦");
				flag = false;
				e.printStackTrace();
			} finally {
				try {
					if(ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	@Override
	public boolean modifyBook(Book book) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
//		int id = bt.getId();
//		int type = bt.getType();
//		int bor = bt.getBorrowingDays();
//		String discription = bt.getDescription();
//		
//		if(bor == 0 || "".equals(discription)) {
//			flag = false;
//		} else {
//			String sql = 	"update b_book_type_tab"
//							+ " set type = " + type + ","
//							+ " BorrowingDays = " + bor + ","
//							+ " description = '" + discription + "'"
//							+ " where id = " + id + ";";
//			
//			Connection conn = DBUtil.getInstence();
//			Statement ps = null;
//			int count = 0;
//			try {
//				ps = conn.createStatement();
//				count = ps.executeUpdate(sql);
//				if(count == 0) {
//					flag = false;
//				} else {
//					flag = true;
//				}			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("修改图书类别出错啦");
//				e.printStackTrace();
//			} finally {
//				try {
//					if(ps != null) {
//						ps.close();
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		return flag;
	}

	@Override
	public boolean deletBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> queryBook(Book book) {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<>();
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String bookId = book.getBookId();
		String bookName = book.getBookName();
		String bookPub = book.getPublisher();
		Integer bookShelf = book.getBookshelf();
		String author = book.getAuthor();
		Integer bookType = book.getType();
		
		String sql = "select * from b_book_tab where bookName like '%" + bookName + "%'";
		
		if(!"".equals(bookId)) {
			sql = sql + " and bookId = '" + bookId + "'";
		}
		if(!"".equals(bookPub)) {
			sql = sql + " and publisher = '" + bookPub + "'";
		}
		if(!"".equals(author)) {
			sql = sql + " and author = '" + author + "'"; 
		}
		if(bookShelf != null) {
			sql = sql + " and type = '" + bookType + "'";
		}
		if(bookType != null) {
			sql = sql + " and type = " + bookType;
		}
		sql += ";";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt(1));
				temp.setBookId(rs.getString(2));
				temp.setBookName(rs.getString(3));
				temp.setType(rs.getInt(4));
				temp.setAuthor(rs.getString(5));
				temp.setPublisher(rs.getString(6));
				temp.setPrice(rs.getDouble(7));
				temp.setCollection(rs.getInt(8));
				temp.setBookshelf(rs.getInt(9));
				temp.setCreateTime(rs.getTimestamp(10));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && ps != null) {
					rs.close();
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
