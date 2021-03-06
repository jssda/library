package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.User;

public interface UserDao {
	
	//管理员登陆检查
	public boolean checkLogin(String name, String pass);
	
	//增加读者信息
	public boolean addReader(User u);
	
	//修改读者信息
	public boolean modifyReader(User u);
	
	//删除读者信息
	public boolean deletReader(User u);
	
	//查询读者信息
	public List<User> queryReaderList(String cardId, String loginName);
	
	//对象数据转化成二维数组数据
	public Object[][] listToObject(List<User> list);
	
	//查看借阅天数是否够
	public boolean chackMaxBook(User u);
	
}
