package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.Borrow;

public interface BorrowDao {
	
	//添加借阅记录
	public boolean BorrowAdd(Borrow bo);
	
	//还书记录
	public boolean BorrowReturn(Borrow bo);
	
	//查询记录
	public List<Borrow> BorrowQuery(Borrow bo);
}
