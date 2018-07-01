package cn.jssd.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.jssd.bean.User;
import cn.jssd.dao.UserDao;
import cn.jssd.util.DBUtil;

public class UserImp implements UserDao {

	public boolean checkLogin(String name, String pass) {
		
		String sql = "select * from u_user_tab where loginName = '" + name + "'and password = '" + pass + "';";
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出错啦");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean addReader(User u) {

		boolean flag = false;
		String LoginName = u.getLoginName().trim();
		String cardId = u.getCardId().trim();
		String name = u.getName().trim();
		int sex = u.getSex();
		int readerType = u.getReaderType();
		int cardType = u.getCardType();
		String phone = u.getPhone();
		Timestamp CreateTime = new Timestamp(new java.util.Date().getTime());
		Timestamp modifyTime = new Timestamp(new java.util.Date().getTime());
		
		if("".equals(LoginName) || "".equals(cardId) || "".equals(name) || "".equals(phone)) {
			flag = false;
		} else {
			String sql = 	"insert u_user_tab(" +
					"loginName," + 
					"  cardId," + 
					"  name," + 
					"  sex," + 
					"  readerType," + 
					"  cardType," + 
					"  phone," + 
					"  createTime," + 
					"  modifyTime," +
					"password )" +
					"values (?,?,?,?,?,?,?,?,?,?);";
			Connection conn = DBUtil.getInstence();
			PreparedStatement ps = null;
			int count = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, LoginName);
				ps.setString(2, cardId);
				ps.setString(3, name);
				ps.setInt(4, sex);
				ps.setInt(5, readerType);
				ps.setInt(6, cardType);
				ps.setString(7, phone);
				ps.setTimestamp(8, CreateTime);
				ps.setTimestamp(9, modifyTime);
				ps.setString(10, "0000");
				
				count = ps.executeUpdate();
				if(count == 0) {
					flag = false;
				} else {
					flag = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("插入图书信息出错啦");
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
	public boolean modifyReader(User u) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String LoginName = u.getLoginName().trim();
		String cardId = u.getCardId().trim();
		String name = u.getName().trim();
		int sex = u.getSex();
		int readerType = u.getReaderType();
		int cardType = u.getCardType();
		String phone = u.getPhone();
		Timestamp modifyTime = new Timestamp(new java.util.Date().getTime());
		
		if("".equals(LoginName) || "".equals(cardId) || "".equals(name) || "".equals(phone)) {
			flag = false;
		} else {
			String sql = "update u_user_tab "
					+ "set loginName = '" + LoginName + "',"
					+ "cardId = '" + cardId + "',"
					+ "name = '" + name + "',"
					+ "sex = '" + sex + "',"
					+ "readerType = '" + readerType + "',"
					+ "cardType = '" + cardType + "',"
					+ "phone = '" + phone + "',"
					+ "modifyTime = '" + modifyTime + "'"
					+ "where id = " + u.getId() + ";";
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
				System.out.println("插入图书信息出错啦");
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
	public boolean deletReader(User u) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from u_user_tab where id = " + u.getId() + ";";
		Connection conn = DBUtil.getInstence();
		Statement ps = null;
		try {
			ps = conn.createStatement();
			ps.execute(sql);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除读者信息出错啦");
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
	public List<User> queryReaderList(String cardId, String loginName) {
		// TODO Auto-generated method stub
		ArrayList<User> list = new ArrayList<>();
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * " + 
					"from u_user_tab " + 
					"where loginName like '%" + loginName + "%' and cardId like '%" + cardId + "%' "
					+ "and readerType <> 5;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setCardId(rs.getString(4));
				u.setName(rs.getString(5));
				u.setSex(rs.getInt(6));
				u.setReaderType(rs.getShort(7));
				u.setCardType(rs.getInt(8));
				u.setPhone(rs.getString(9));
				u.setCreateTime(rs.getTimestamp(10));
				u.setModifyTime(rs.getTimestamp(11));
				list.add(u);
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
		
//		System.out.println("listsize() = " + list.size());
		return list;
	}

	@Override
	public Object[][] listToObject(List<User> list) {
		// TODO Auto-generated method stub
		Object[][] date = null;
		int rows = list.size();
		date = new Object[rows][11];
		for(int i = 0; i < list.size(); i ++) {
			date[i][0] = list.get(i).getId();
			date[i][1] = list.get(i).getLoginName();
			date[i][2] = list.get(i).getPassword();
			date[i][3] = list.get(i).getCardId();
			date[i][4] = list.get(i).getName();
			int sex = list.get(i).getSex();
			if(sex == 1) {
				date[i][5] = "男";
			} else if(sex == 2) {
				date[i][5] = "女";
			}
			int readerType = list.get(i).getReaderType();
			if(readerType == 1) {
				date[i][6] = "读者";
			} else {
				date[i][6] = "管理员";
			}
			int cardType = list.get(i).getCardType();
			if(cardType == 1) {
				date[i][7] = "本科生";
			} else if(cardType == 2) {
				date[i][7] = "研究生";
			} else if(cardType == 3) {
				date[i][7] = "教师";
			} else if(cardType == 4) {
				date[i][7] = "领导";
			} else if(cardType == 5) {
				date[i][7] = "管理员";
			}
			date[i][8] = list.get(i).getPhone();
			date[i][9] = list.get(i).getCreateTime();
			date[i][10] = list.get(i).getModifyTime();
		}
		
		return date;
	}

	
}
