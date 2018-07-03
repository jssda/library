package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;
import cn.jssd.model.BookTypeTableModel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPBookTypeModify extends JPanel {
	/**
	 * 图书类目添加视图
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea_1;
	private Integer selectID = null;
	/**
	 * Create the panel.
	 */
	public JPBookTypeModify() {
		setLayout(null);
		
		JLabel lblid = new JLabel("typeID");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setBounds(145, 54, 80, 30);
		add(lblid);
		
		JLabel label = new JLabel("描述信息");
		label.setBounds(440, 63, 80, 30);
		add(label);
		
		JLabel label_1 = new JLabel("借阅天数");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(137, 149, 88, 30);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(269, 61, 86, 24);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(556, 67, 248, 131);
		add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 148, 86, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 243, 876, 250);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "type", "brrowingDays", "description"
			}
		));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int selectRow = table.getSelectedRow();
					selectID = (int) table.getValueAt(selectRow, 0);
					textField_2.setText(table.getValueAt(selectRow, 1).toString());
					textField_3.setText( table.getValueAt(selectRow, 2).toString());
					textArea_1.setText((String) table.getValueAt(selectRow, 3));
				}
			}
		});
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookType bt = new BookType();
				try {
					if(!"".equals(textField.getText().trim()))
						bt.setType(Integer.parseInt(textField.getText().trim()));
					if(!"".equals(textField_1.getText().trim()))
						bt.setBorrowingDays(Integer.parseInt(textField_1.getText().trim()));
					bt.setDescription(textArea.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请检查输入格式", "输入错误", JOptionPane.ERROR_MESSAGE);
				}
				
				table.setModel(new BookTypeTableModel(bt));
				textArea.setText("");
				textArea_1.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton.setBounds(882, 96, 113, 59);
		add(btnNewButton);
		
		JLabel lblType = new JLabel("type");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setBounds(148, 546, 72, 18);
		add(lblType);
		
		JLabel lblBorrowingdays = new JLabel("borrowingDays");
		lblBorrowingdays.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowingdays.setBounds(124, 644, 117, 30);
		add(lblBorrowingdays);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setBounds(471, 551, 97, 24);
		add(lblDescription);
		
		textField_2 = new JTextField();
		textField_2.setBounds(271, 552, 86, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(273, 649, 86, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(515, 590, 161, 97);
		add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookType bt = new BookType();
				bt.setId(selectID);
				bt.setType(Integer.parseInt(textField_2.getText().trim()));
				bt.setBorrowingDays(Integer.parseInt(textField_3.getText().trim()));
				bt.setDescription(textArea_1.getText().trim());
				
				if(DaoFactory.getBookTypeInstence().modifyBookType(bt)) {
					JOptionPane.showMessageDialog(null, "修改完成", "提示", JOptionPane.INFORMATION_MESSAGE);
					table.setModel(new BookTypeTableModel(bt));
				} else {
					JOptionPane.showMessageDialog(null, "修改时错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(809, 569, 113, 27);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(809, 635, 113, 27);
		add(btnNewButton_2);
	}
}
