package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.BookType;

public interface BookTypeDao {
	
	//���ͼ�����
	public boolean addBookType(BookType bt);
	
	//�޸�ͼ�����
	public boolean modifyBookType(BookType bt);
	
	//ɾ��ͼ�����
	public boolean deletBookType(BookType bt);
	
	//����ͼ�����
	public List<BookType> queryBookType(BookType bt);
	
}
