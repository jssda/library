package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.BookType;

public interface BookTypeDao {
	
	//添加图书类别
	public boolean addBookType(BookType bt);
	
	//修改图书类别
	public boolean modifyBookType(BookType bt);
	
	//删除图书类别
	public boolean deletBookType(BookType bt);
	
	//查找图书类别
	public List<BookType> queryBookType(BookType bt);
	
}
