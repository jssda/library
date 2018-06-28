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

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 315, 75, 147, 133, 123, 99, 49, 0};
		gridBagLayout.rowHeights = new int[]{39, 189, 18, 103, 99, 120, 74, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("F:\\eclipse-workspace\\library\\image\\top1.gif"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 8;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("LoginName");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(UIManager.getColor("CheckBox.focus"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 3;
		add(lblName, gbc_lblName);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCardid = new JLabel("cardId");
		lblCardid.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCardid = new GridBagConstraints();
		gbc_lblCardid.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardid.gridx = 0;
		gbc_lblCardid.gridy = 4;
		add(lblCardid, gbc_lblCardid);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 3;
		gbc_lblSex.gridy = 4;
		add(lblSex, gbc_lblSex);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getSource() == radioButton) {
					u.setSex(1);
				}
			}
		});
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 4;
		gbc_radioButton.gridy = 4;
		add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == radioButton_1) {
					u.setSex(2);
				}
			}
		});
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 5;
		gbc_radioButton_1.gridy = 4;
		add(radioButton_1, gbc_radioButton_1);
		ButtonGroup bgpSexType = new ButtonGroup();
		bgpSexType.add(radioButton);
		bgpSexType.add(radioButton_1);
		
		JLabel lblReaderType = new JLabel("Reader Type");
		lblReaderType.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblReaderType = new GridBagConstraints();
		gbc_lblReaderType.insets = new Insets(0, 0, 5, 5);
		gbc_lblReaderType.gridx = 0;
		gbc_lblReaderType.gridy = 5;
		add(lblReaderType, gbc_lblReaderType);
		
		JComboBox<String> comboBox = new JComboBox<String>(new ReaderTypeListModel());
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		add(comboBox, gbc_comboBox);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 3;
		gbc_lblPhone.gridy = 5;
		add(lblPhone, gbc_lblPhone);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 5;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("添加信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				u.setLoginName(textField.getText());
				u.setCardId(textField_1.getText());
				u.setReaderType(comboBox.getSelectedIndex() + 1);
				u.setCardType(comboBox.getSelectedIndex() + 1);
				u.setCreateTime(new Date());
				u.setModifyTime(new Date());
				u.setPhone(textField_3.getText());
				u.setName(textField_2.getText());
				if(!DaoFactory.getUserDaoInstence().addReader(u) || u.getSex() == 0) {
					JOptionPane.showMessageDialog(JPReaderInfoAdd.this, "请检查信息", "添加警告", JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("添加成功了");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 6;
		add(button, gbc_button);
		

	}

}
