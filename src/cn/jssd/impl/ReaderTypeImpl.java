package cn.jssd.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jssd.bean.ReaderType;
import cn.jssd.dao.ReaderTypeDao;
import cn.jssd.util.DBUtil;

public class ReaderTypeImpl implements ReaderTypeDao {

	@Override
	public int queryMaxBook(ReaderType rt) {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getInstence();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int books = 0;
		int type = rt.getType();
		String sql = "select maxBook from u_reader_type_tab where type = " + type + ";";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				books = rs.getInt(1);
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
		
		return books;
	}

}
