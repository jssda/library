package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import cn.jssd.bean.Borrow;
import cn.jssd.factory.DaoFactory;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPReturn extends JPanel {

	/**
	 * ������ͼ
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCardId;
	private JTextField textBookId;

	/**
	 * Create the panel.
	 */
	public JPReturn() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����뻹����Ϣ");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(253, 93, 605, 66);
		add(lblNewLabel);
		
		JLabel lblCardId = new JLabel("����֤�˺�");
		lblCardId.setBounds(235, 214, 104, 43);
		add(lblCardId);
		
		JLabel lblBookId = new JLabel("ͼ����");
		lblBookId.setBounds(235, 370, 93, 43);
		add(lblBookId);
		
		textCardId = new JTextField();
		textCardId.setBounds(408, 214, 482, 43);
		add(textCardId);
		textCardId.setColumns(10);
		
		textBookId = new JTextField();
		textBookId.setBounds(408, 370, 482, 43);
		add(textBookId);
		textBookId.setColumns(10);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cardId = textCardId.getText().trim();
				String bookId = textBookId.getText().trim();
				Borrow bo = new Borrow();
				bo.setBookId(bookId);
				bo.setCardId(cardId);
				
				if(DaoFactory.getBorrowInstence().BorrowReturn(bo)) {
					JOptionPane.showMessageDialog(null, "����ɹ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
					textBookId.setText("");
					textCardId.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ��", "������ʾ",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(796, 513, 139, 66);
		add(btnNewButton);

	}

}
