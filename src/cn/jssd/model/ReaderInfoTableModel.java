package cn.jssd.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import cn.jssd.factory.DaoFactory;

public class ReaderInfoTableModel extends AbstractTableModel{

	private String cardId = null;
	private String loginName = null;
	private String[] title = {"id","loginName", "password", "cardId", "name", "sex", "rederType",
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
		if(body.length == 0) {
			JOptionPane.showMessageDialog(null, "没有查找到", "查询问题", JOptionPane.WARNING_MESSAGE);
		}
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
//		if(body.length == 0) {
//			return 5;
//		} else 
			return body.length;
	}

//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		// TODO Auto-generated method stub
//		return body[0][columnIndex].getClass();
//	}


	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return title[column];
	}


	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}


	//得到某个单元格的值
	@Override
	public Object getValueAt(int raw, int col) {
		// TODO Auto-generated method stub
		return body[raw][col];
	}
	
}
