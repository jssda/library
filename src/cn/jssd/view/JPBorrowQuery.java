package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.jssd.bean.Borrow;
import cn.jssd.model.BorrowTableModel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class JPBorrowQuery extends JPanel {

	/**
	 * ½èÔÄ²éÑ¯ÊÓÍ¼Ä£¿é
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textcardId;
	private JTextField textbookId;
	private JTable table;
	private int select = 1;
	
	/**
	 * Create the panel.
	 */
	public JPBorrowQuery() {
		setLayout(null);
		
		JLabel lblcardId = new JLabel("½èÔÄÖ¤ÕËºÅ");
		lblcardId.setBounds(140, 91, 125, 40);
		add(lblcardId);
		
		JLabel lblbookId = new JLabel("Í¼Êé±àºÅ");
		lblbookId.setBounds(140, 170, 125, 40);
		add(lblbookId);
		
		textcardId = new JTextField();
		textcardId.setBounds(279, 91, 332, 40);
		add(textcardId);
		textcardId.setColumns(10);
		
		textbookId = new JTextField();
		textbookId.setBounds(279, 170, 332, 40);
		add(textbookId);
		textbookId.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ÒÑ½è¼ÇÂ¼");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == rdbtnNewRadioButton) {
					select = 1;
				}
			}
		});
		rdbtnNewRadioButton.setBounds(707, 115, 157, 27);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ÒÑ»¹¼ÇÂ¼");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == rdbtnNewRadioButton_1) {
					select = 2;
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(707, 177, 157, 27);
		add(rdbtnNewRadioButton_1);
		
		ButtonGroup bgpSexType = new ButtonGroup();
		bgpSexType.add(rdbtnNewRadioButton);
		bgpSexType.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("ËÑË÷");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardId = textcardId.getText().trim();
				String bookId = textbookId.getText().trim();
				
				Borrow bo = new Borrow();
				bo.setCardId(cardId);
				bo.setBookId(bookId);
				bo.setStatus(select);
				table.setModel(new BorrowTableModel(bo));
			}
		});
		btnNewButton.setBounds(885, 123, 125, 51);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(152, 312, 871, 355);
		add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"id", "cardId", "status", "createTime", "bookId", "returnTime"
			}
		));
		scrollPane.setViewportView(table);

	}
}
