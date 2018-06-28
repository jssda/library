package cn.jssd.dao;

import java.util.List;

import cn.jssd.bean.User;

public interface UserDao {
	
	//����Ա��½���
	public boolean checkLogin(String name, String pass);
	
	//���Ӷ�����Ϣ
	public boolean addReader(User u);
	
	//�޸Ķ�����Ϣ
	public boolean modifyReader(String sql);
	
	//ɾ��������Ϣ
	public boolean deletReader(String sql);
	
	//��ѯ������Ϣ
	public List<User> queryReaderList(String cardId, String loginName);
	
	//��������ת���ɶ�ά��������
	public Object[][] listToObject(List<User> list);
	
}
