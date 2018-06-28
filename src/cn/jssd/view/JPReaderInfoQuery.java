package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.jssd.factory.DaoFactory;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class JPReaderInfoQuery extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public JPReaderInfoQuery() {
		setLayout(null);
		
		JLabel label = new JLabel("请输入登陆名:");
		label.setBounds(183, 119, 189, 53);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(407, 123, 294, 46);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("请输入查找的读者信息:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 41, 356, 52);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入借阅证号:");
		lblNewLabel_1.setBounds(183, 214, 135, 41);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(407, 211, 411, 47);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnChaxun = new JButton("查询");
		btnChaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CardId = textField_1.getText();
				String LoginName = textField.getText();
				
				
			}
		});
		btnChaxun.setFont(new Font("宋体", Font.PLAIN, 24));
		btnChaxun.setBounds(900, 270, 113, 53);
		add(btnChaxun);

		
		
	}
}
