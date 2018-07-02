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
		
		JLabel lblBorrowInfo = new JLabel("�����������Ϣ");
		lblBorrowInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowInfo.setFont(new Font("����", Font.PLAIN, 30));
		lblBorrowInfo.setBounds(404, 90, 354, 53);
		add(lblBorrowInfo);
		
		JLabel lblCardId = new JLabel("���������֤��");
		lblCardId.setBounds(204, 250, 160, 53);
		add(lblCardId);
		
		JLabel lblBookId = new JLabel("������ͼ����");
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
		
		JButton btnAdd = new JButton("��ӽ�����Ϣ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Borrow bo = new Borrow();
				bo.setCardId(textCardId.getText().trim());
				bo.setBookId(textBookId.getText().trim());
				
				if(DaoFactory.getBorrowInstence().BorrowAdd(bo)) {
					JOptionPane.showMessageDialog(null, "���ĳɹ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
					textBookId.setText("");
					textCardId.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ��, ����ͼ��ʣ����ߴ˶��߿ɽ�����Ŀ", "������ʾ",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setBounds(645, 531, 317, 90);
		add(btnAdd);

	}
}
