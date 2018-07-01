package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPBookTypeAdd extends JPanel {

	/**
	 * 图书类别添加视图
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public JPBookTypeAdd() {
		setLayout(null);
		
		JLabel label = new JLabel("请输入图书类别信息:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 25));
		label.setBounds(144, 49, 289, 86);
		add(label);
		
		JLabel label_1 = new JLabel("图书类别编号:");
		label_1.setBounds(196, 209, 116, 51);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(363, 216, 138, 36);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("最多可借阅时间:");
		label_2.setBounds(633, 212, 132, 45);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(812, 214, 104, 41);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("类别描述:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(223, 390, 96, 45);
		add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 318, 466, 195);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(textField.getText());
					int bor = Integer.parseInt(textField_1.getText());
					String description = textArea.getText().trim();
					
					BookType bt = new BookType();
					bt.setType(id);
					bt.setId(id);
					bt.setBorrowingDays(bor);
					bt.setDescription(description);
					
					if(DaoFactory.getBookTypeInstence().addBookType(bt)) {
						JOptionPane.showMessageDialog(null, "图书类别添加成功", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "请注意输入", "信息错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "请注意输入", "信息错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(851, 557, 129, 59);
		add(btnNewButton);
		
	}
}
