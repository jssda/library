package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.Borrow;

public interface BorrowDao {
	
	//��ӽ��ļ�¼
	public boolean BorrowAdd(Borrow bo);
	
	//�����¼
	public boolean BorrowReturn(Borrow bo);
	
	//��ѯ��¼
	public List<Borrow> BorrowQuery(Borrow bo);
}
