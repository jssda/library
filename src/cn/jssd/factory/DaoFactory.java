package cn.jssd.factory;

import cn.jssd.dao.UserDao;
import cn.jssd.impl.UserImp;

public class DaoFactory {
	
	public static UserDao getUserDaoInstence() {
		return new UserImp();
	}
	
}
