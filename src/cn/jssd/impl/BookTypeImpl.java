package cn.jssd.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.jssd.bean.BookType;
import cn.jssd.dao.BookTypeDao;
import cn.jssd.util.DBUtil;

public class BookTypeImpl implements BookTypeDao {

	@Override
	public boolean addBookType(BookType bt) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		int type = bt.getType();
		int bor = bt.getBorrowingDays();
		String discription = bt.getDescription();
		
		if(bor == 0 || "".equals(discription)) {
			flag = false;
		} else {
			String sql = "insert into b_book_type_tab values (null, ?, ?, ?);";
			Connection conn = DBUtil.getInstence();
			PreparedStatement ps = null;
			int count = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, type);
				ps.setInt(2, bor);
				ps.setString(3, discription);
				
				count = ps.executeUpdate();
				if(count == 0) {
					flag = false;
				} else {
					flag = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("插入图书类别出错啦");
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
	public boolean modifyBookType(BookType bt) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		int id = bt.getId();
		int type = bt.getType();
		int bor = bt.getBorrowingDays();
		String discription = bt.getDescription();
		
		if(bor == 0 || "".equals(discription)) {
			flag = false;
		} else {
			String sql = 	"update b_book_type_tab"
							+ " set type = " + type + ","
							+ " BorrowingDays = " + bor + ","
							+ " description = '" + discription + "'"
							+ " where id = " + id + ";";
			
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
				System.out.println("修改图书类别出错啦");
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
	public boolean deletBookType(BookType bt) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from b_book_type_tab where id = " + bt.getId() + ";";
		Connection conn = DBUtil.getInstence();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			ps.execute(sql);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除读书类别出错啦");
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
	public List<BookType> queryBookType(BookType bt) {
		// TODO Auto-generated method stub
		List<BookType> list = new ArrayList<>();
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = null;
			if(bt.getType() != null && bt.getBorrowingDays() != null) {
				sql = "select * " + 
						"from b_book_type_tab " + 
						"where type = " 
						+ bt.getType()
						+ " and BorrowingDays = "
						+ bt.getBorrowingDays()
						+ " and description like '%" + bt.getDescription() + "%';";
			} else if(bt.getType() != null) {
				sql = "select * " + 
						"from b_book_type_tab " + 
						"where type = " 
						+ bt.getType()
						+ " and description like '%" + bt.getDescription() + "%';";
			} else if(bt.getBorrowingDays() != null) {
				sql = "select * " + 
						"from b_book_type_tab " + 
						"where BorrowingDays = "
						+ bt.getBorrowingDays()
						+ " and description like '%" + bt.getDescription() + "%';";
			} else {
				sql = "select * " + 
						"from b_book_type_tab " + 
						"where  description like '%" + bt.getDescription() + "%';";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookType b = new BookType();
				b.setId(rs.getInt(1));
				b.setType(rs.getInt(2));
				b.setBorrowingDays(rs.getInt(3));
				b.setDescription(rs.getString(4));
				list.add(b);
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
