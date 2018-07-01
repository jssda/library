package cn.jssd.factory;

import cn.jssd.dao.BookDao;
import cn.jssd.dao.BookTypeDao;
import cn.jssd.dao.UserDao;
import cn.jssd.impl.BookImpl;
import cn.jssd.impl.BookTypeImpl;
import cn.jssd.impl.UserImp;

public class DaoFactory {
	
	public static UserDao getUserDaoInstence() {
		return new UserImp();
	}

	public static BookTypeDao getBookTypeInstence() {
		return new BookTypeImpl();
	}
	
	public static BookDao getBookInstence() {
		return new BookImpl();
	}
}
