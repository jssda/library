package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.Book;

public interface BookDao {
		
	//添加图书类别
	public boolean addBook(Book book);
	
	//修改图书类别
	public boolean modifyBook(Book book);
	
	//删除图书类别
	public boolean deletBook(Book book);
	
	//查找图书类别
	public List<Book> queryBook(Book book);
	
	//借阅图书
	public boolean borrowBook(Book book);
	
	//还书
	public boolean returnBook(Book book);
}
