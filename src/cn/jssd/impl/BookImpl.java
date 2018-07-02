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
		
		int id = book.getId();
		String bookId = book.getBookId();
		String bookName = book.getBookName();
		Integer type = book.getType();
		String author = book.getAuthor();
		String publisher = book.getPublisher();
		Double price = book.getPrice();
		Integer collection = book.getCollection();
		Integer bookshelf = book.getBookshelf();
		
		if(bookId == null || "".equals(bookId) || "".equals(bookName) ||
				collection == null || bookshelf == null) {
			flag = false;
		} else {
			String sql = 	"update b_book_tab"
							+ " set bookName = '" + bookName + "',"
							+ " bookId = '" + bookId + "',"
							+ " type = " + type + ","
							+ " collection = '" + collection + "',"
							+ " bookShelf = '" + bookshelf + "'";
			
			if(!"".equals(author)) {
				sql += ", author = '" + author + "'";
			}
			if(!"".equals(publisher)) {
				sql += ", publisher = '" + publisher + "'";
			}
			if(price != null) {
				sql += ", price = '" + price + "'";
			}
			sql += " where id = " + id + ";";
			
//			System.out.println("sql = " + sql);
			Connection conn = DBUtil.getInstence();
			Statement ps = null;
			int count = 0;
			try {
				ps = conn.createStatement();
				count = ps.executeUpdate(sql);
				if(count == 0) {
					flag = false;
				} else {
					flag = true;
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("修改图书信息出错啦");
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
	public boolean deletBook(Book book) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from b_book_tab where id = " + book.getId() + ";";
		Connection conn = DBUtil.getInstence();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			ps.execute(sql);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除读书信息出错啦");
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
		
		return flag;
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
		Integer collection = book.getCollection();
		
		String sql = "select * from b_book_tab where bookName like '%" + bookName + "%'";
		
		if(!"".equals(bookId) && bookId != null) {
			sql = sql + " and bookId = '" + bookId + "'";
		}
		if(!"".equals(bookPub) && bookPub != null) {
			sql = sql + " and publisher = '" + bookPub + "'";
		}
		if(!"".equals(author) && author != null) {
			sql = sql + " and author = '" + author + "'"; 
		}
		if(bookShelf != null) {
			sql = sql + " and type = '" + bookType + "'";
		}
		if(bookType != null) {
			sql = sql + " and type = " + bookType;
		}
		if(collection != null) {
			sql = sql + " and collection = " + collection;
		}
		sql += ";";
		
//		System.out.println("sql = " + sql);
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

	@Override
	public boolean borrowBook(Book book) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update b_book_tab set "
				+ "collection = collection - 1 "
				+ "where bookId = '" + book.getBookId() + "';";
		System.out.println("sql = " + sql);
		Connection conn = DBUtil.getInstence();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			
			book.setBookName("");
			List<Book> list = queryBook(book);
			int collection = list.get(0).getCollection();
			if(collection <= 0) {
				flag = false;
			} else {
				ps.execute(sql);
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("借阅图书出错啦");
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
		
		
		return flag;
	}

	@Override
	public boolean returnBook(Book book) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		String sql = "update b_book_tab set "
				+ "collection = collection + 1 "
				+ "where bookId = '" + book.getBookId() + "';";
		System.out.println("sql = " + sql);
		Connection conn = DBUtil.getInstence();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			
			book.setBookName("");
			List<Book> list = queryBook(book);
			int collection = list.get(0).getCollection();
			if(collection <= 0) {
				flag = false;
			} else {
				ps.execute(sql);
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("还书出错啦");
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
		
		
		return flag;
	}

}
