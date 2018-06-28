package cn.jssd.model;

import javax.swing.table.AbstractTableModel;

import cn.jssd.factory.DaoFactory;

public class ReaderInfoTableModel extends AbstractTableModel{

	private String cardId = null;
	private String loginName = null;
	private Object[] title = {"loginName", "password", "cardId", "name", "sex", "rederType",
								"cardType", "phone", "createTime", "modifyTime"};
	private Object[][] body = null;
	
	public ReaderInfoTableModel(String cardId, String loginName) {
		// TODO Auto-generated constructor stub
		this.cardId = cardId;
		this.loginName = loginName;
		init();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void init() {
		body = DaoFactory.getUserDaoInstence().listToObject(
					DaoFactory.getUserDaoInstence().queryReaderList(cardId, loginName));
	}
	
	
	//得到模型的列数
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	//得到模型的行数
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return body.length;
	}

	//得到某个单元格的值
	@Override
	public Object getValueAt(int raw, int col) {
		// TODO Auto-generated method stub
		return body[raw][col];
	}
	
}
