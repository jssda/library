package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import cn.jssd.bean.Borrow;
import cn.jssd.factory.DaoFactory;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPBorrow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCardId;
	private JTextField textBookId;

	/**
	 * Create the panel.
	 */
	public JPBorrow() {
		setLayout(null);
		
		JLabel lblBorrowInfo = new JLabel("请输入借阅信息");
		lblBorrowInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowInfo.setFont(new Font("宋体", Font.PLAIN, 30));
		lblBorrowInfo.setBounds(404, 90, 354, 53);
		add(lblBorrowInfo);
		
		JLabel lblCardId = new JLabel("请输入借阅证号");
		lblCardId.setBounds(204, 250, 160, 53);
		add(lblCardId);
		
		JLabel lblBookId = new JLabel("请输入图书编号");
		lblBookId.setBounds(204, 357, 160, 53);
		add(lblBookId);
		
		textCardId = new JTextField();
		textCardId.setBounds(345, 250, 594, 53);
		add(textCardId);
		textCardId.setColumns(10);
		
		textBookId = new JTextField();
		textBookId.setBounds(345, 357, 594, 53);
		add(textBookId);
		textBookId.setColumns(10);
		
		JButton btnAdd = new JButton("添加借阅信息");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Borrow bo = new Borrow();
				bo.setCardId(textCardId.getText().trim());
				bo.setBookId(textBookId.getText().trim());
				
				if(DaoFactory.getBorrowInstence().BorrowAdd(bo)) {
					JOptionPane.showMessageDialog(null, "借阅成功", "借阅提示", JOptionPane.ERROR_MESSAGE);
					textBookId.setText("");
					textCardId.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "借阅失败, 请检查图书剩余或者此读者可借阅数目", "错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setBounds(645, 531, 317, 90);
		add(btnAdd);

	}
}
