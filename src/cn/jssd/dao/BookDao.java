package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.Book;

public interface BookDao {
		
	//���ͼ�����
	public boolean addBook(Book book);
	
	//�޸�ͼ�����
	public boolean modifyBook(Book book);
	
	//ɾ��ͼ�����
	public boolean deletBook(Book book);
	
	//����ͼ�����
	public List<Book> queryBook(Book book);
	
	//����ͼ��
	public boolean borrowBook(Book book);
	
	//����
	public boolean returnBook(Book book);
}
