package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.jssd.model.ReaderInfoTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPReaderInfoQuery extends JPanel {

	/**
	 * ������Ϣ��ѯ���
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private ReaderInfoTable panel = null;
	
	/**
	 * Create the panel.
	 */
	public JPReaderInfoQuery() {
		setLayout(null);
		
		JLabel label = new JLabel("�������½��:");
		label.setBounds(183, 94, 189, 53);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(407, 97, 294, 46);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("��������ҵĶ�����Ϣ:");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(37, 29, 356, 52);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���������֤��:");
		lblNewLabel_1.setBounds(183, 182, 135, 41);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(390, 179, 411, 47);
		add(textField_1);
		textField_1.setColumns(10);
		
		panel = new ReaderInfoTable();
		panel.getTable().setLocation(14, 32);
		panel.setBounds(77, 255, 994, 484);
		add(panel);
		
		JButton btnChaxun = new JButton("��ѯ");
		btnChaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CardId = textField_1.getText();
				String LoginName = textField.getText();
				
				if("".equals(CardId) && "".equals(LoginName)) {
					JOptionPane.showMessageDialog(null, "��ѯʧ��", "��ѯ����", JOptionPane.WARNING_MESSAGE);
				} else {
					panel.getTable().setModel(new ReaderInfoTableModel(CardId, LoginName));
				}
			}
		});
		btnChaxun.setFont(new Font("����", Font.PLAIN, 24));
		btnChaxun.setBounds(827, 90, 113, 53);
		add(btnChaxun);		
		
	}
}
