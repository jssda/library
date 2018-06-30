package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import cn.jssd.bean.User;
import cn.jssd.factory.DaoFactory;
import cn.jssd.model.ReaderTypeListModel;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JPReaderInfoAdd extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private User u = null;
	
	/**
	 * Create the panel.
	 */
	public JPReaderInfoAdd() {
		
		u = new User();
		
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(149, 73, 800, 168);
		lblNewLabel_1.setIcon(new ImageIcon("F:\\eclipse-workspace\\library\\image\\top1.gif"));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("LoginName");
		lblNewLabel.setBounds(34, 347, 72, 18);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(UIManager.getColor("CheckBox.focus"));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 344, 316, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(593, 347, 32, 18);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(685, 344, 356, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCardid = new JLabel("cardId");
		lblCardid.setBounds(44, 434, 48, 18);
		lblCardid.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCardid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 431, 316, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setBounds(593, 434, 24, 18);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSex);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.setBounds(706, 430, 43, 27);
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getSource() == radioButton) {
					u.setSex(1);
				}
			}
		});
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(793, 430, 43, 27);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == radioButton_1) {
					u.setSex(2);
				}
			}
		});
		add(radioButton_1);
		ButtonGroup bgpSexType = new ButtonGroup();
		bgpSexType.add(radioButton);
		bgpSexType.add(radioButton_1);
		
		JLabel lblReaderType = new JLabel("Reader Type");
		lblReaderType.setBounds(34, 517, 88, 18);
		lblReaderType.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblReaderType);
		
		JComboBox<String> comboBox = new JComboBox<String>(new ReaderTypeListModel());
		comboBox.setBounds(142, 575, 316, 24);
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(0);
		add(comboBox);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(585, 517, 40, 18);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblPhone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(685, 514, 356, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("添加信息");
		button.setBounds(685, 637, 198, 43);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				u.setLoginName(textField.getText());
				u.setCardId(textField_1.getText());
				u.setCardType(comboBox.getSelectedIndex() + 1);
				u.setCreateTime(new Date());
				u.setModifyTime(new Date());
				u.setPhone(textField_3.getText());
				u.setName(textField_2.getText());
				if(!DaoFactory.getUserDaoInstence().addReader(u) || u.getSex() == 0 || u.getReaderType() == 0) {
					JOptionPane.showMessageDialog(JPReaderInfoAdd.this, "请检查信息", "添加警告", JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("添加成功了");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		add(button);
		
		JLabel lblCardtype = new JLabel("cardType");
		lblCardtype.setBounds(34, 578, 72, 18);
		add(lblCardtype);
		
		JRadioButton radioButton2 = new JRadioButton("管理员");
		radioButton2.setBounds(149, 517, 87, 27);
		radioButton2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getSource() == radioButton2) {
					u.setReaderType(2);;
				}
			}
		});
		add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton("读者");
		radioButton3.setBounds(242, 517, 117, 27);
		radioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == radioButton3) {
					u.setReaderType(1);
				}
			}
		});
		add(radioButton3);
		ButtonGroup bgpCardType = new ButtonGroup();
		bgpCardType.add(radioButton2);
		bgpCardType.add(radioButton3);
		
	}

}
