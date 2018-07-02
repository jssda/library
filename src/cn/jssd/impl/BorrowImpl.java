package cn.jssd.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import cn.jssd.bean.Book;
import cn.jssd.bean.BookType;
import cn.jssd.bean.Borrow;
import cn.jssd.bean.User;
import cn.jssd.dao.BorrowDao;
import cn.jssd.factory.DaoFactory;
import cn.jssd.util.DBUtil;
import cn.jssd.util.DateUtil;

public class BorrowImpl implements BorrowDao {

	@Override
	public boolean BorrowAdd(Borrow bo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String cardId = bo.getCardId();
		String bookId = bo.getBookId();
		Book book = new Book();
		book.setBookId(bookId);
		User u = new User();
		u.setCardId(bo.getCardId());
		Timestamp creatTime = new Timestamp(new Date().getTime());
		
		if("".equals(cardId) || "".equals(bookId) ||
				DaoFactory.getBookInstence().borrowBook(book) == false ||
				DaoFactory.getUserDaoInstence().chackMaxBook(u) == false) {
			flag = false;
		} else {
			String sql = "insert into b_borrow_tab values (null, ?, ?, ?, ?, null);";
			Connection conn = DBUtil.getInstence();
			PreparedStatement ps = null;
			int count = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, cardId);
				ps.setShort(2, (short) 1);
				ps.setString(4, bookId);
				ps.setTimestamp(3, creatTime);
				
				count = ps.executeUpdate();
				if(count == 0) {
					flag = false;
				} else {
					flag = true;
				}
				
			} catch (SQLIntegrityConstraintViolationException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "请检查编号正确性", "提示", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("借阅图书出错啦");
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
	public boolean BorrowReturn(Borrow bo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Date date1 = null;
		Date date2 = null;
		Book book = new Book();
		book.setBookId(bo.getBookId());
		book.setBookName("");
		List<Book> list1 = DaoFactory.getBookInstence().queryBook(book);
		
		bo.setStatus(1);
		List<Borrow> list = BorrowQuery(bo);
		if(list.size() < 1) {
			flag = false;
		} else {
			date1 = list.get(0).getCreateTime();
			date2 = new Date();
			
			int days = DateUtil.daysBetween(date1, date2);
			int day = 0;
			if(list1.size() < 1) {
				flag = false;
			} else {
				int type = list1.get(0).getType();
				BookType bt = new BookType();
				bt.setType(type);
				List<BookType> list2 = DaoFactory.getBookTypeInstence().queryBookType(bt);
				if(list2.size() < 1) {
					flag = false;
				} else {
					day = list2.get(0).getBorrowingDays();
				}
			}
			
			if(days > day) {
				JOptionPane.showMessageDialog(null, "请注意, 这位读者借书时间超限", "警告", JOptionPane.WARNING_MESSAGE);
			} else {
				DaoFactory.getBookInstence().returnBook(book);
				String sql = "update b_borrow_tab set status = 2 "
						 + ", returnTime = now() "
						+ "where cardId = '" + bo.getCardId() + "'"
						+ " and bookId = '" + bo.getBookId() + "';";
				Connection conn = DBUtil.getInstence();
				Statement s = null;
				int count = 0;
				try {
					s = conn.createStatement();
					
					count = s.executeUpdate(sql);
					if(count == 0) {
						flag = false;
					} else {
						flag = true;
					}
					
				} catch (SQLIntegrityConstraintViolationException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "请检查编号正确性", "提示", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("还书出错啦");
					flag = false;
					e.printStackTrace();
				} finally {
					try {
						if(s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		return flag;
	}

	@Override
	public List<Borrow> BorrowQuery(Borrow bo) {
		// TODO Auto-generated method stub
		
		ArrayList<Borrow> list = new ArrayList<>();
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from b_borrow_tab where status = " + bo.getStatus();
		
		if(bo.getCardId() != null && !"".equals(bo.getCardId())) {
			sql += " and cardId = '" + bo.getCardId() + "'";
		}
		if(bo.getBookId() != null && !"".equals(bo.getBookId())) {
			sql += " and bookId = '" + bo.getBookId() + "'";
		}
		sql += ";";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Borrow temp = new Borrow();
				temp.setId(rs.getInt(1));
				temp.setCardId(rs.getString(2));
				temp.setStatus(rs.getInt(3));
				temp.setCreateTime(rs.getTimestamp(4));
				temp.setBookId(rs.getString(5));
				temp.setReturnTime(rs.getTimestamp(6));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
