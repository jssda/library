package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.jssd.bean.User;
import cn.jssd.factory.DaoFactory;
import cn.jssd.model.ReaderInfoTableModel;
import cn.jssd.model.ReaderTypeListModel;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ReaderInfoTable extends JPanel {

	/**
	 * 读者信息展示表格
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public ReaderInfoTable() {
		setLayout(null);
		
		User u = new User();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 994, 255);
		add(scrollPane);
		
		setTable(new JTable(3, 10));
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTable().setFillsViewportHeight(true);
		scrollPane.setViewportView(getTable());
		getTable().setToolTipText("读者信息");
		
		JLabel lblLoginname = new JLabel("loginName");
		lblLoginname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginname.setBounds(53, 292, 94, 24);
		add(lblLoginname);
		
		textField = new JTextField();
		textField.setBounds(142, 292, 86, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(268, 295, 72, 21);
		add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(354, 292, 147, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("cardId");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(526, 294, 72, 21);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(612, 292, 138, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(764, 295, 72, 18);
		add(lblName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(850, 292, 86, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSex = new JLabel("sex");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setBounds(53, 366, 72, 18);
		add(lblSex);
		
		JLabel lblReadertype = new JLabel("readerType");
		lblReadertype.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadertype.setBounds(268, 366, 86, 18);
		add(lblReadertype);
		
		JLabel lblCardtype = new JLabel("cardType");
		lblCardtype.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardtype.setBounds(53, 431, 101, 18);
		add(lblCardtype);
		
//		textField_6 = new JTextField();
//		textField_6.setBounds(157, 428, 101, 24);
//		add(textField_6);
//		textField_6.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>(new ReaderTypeListModel());
		comboBox.setBounds(157, 428, 101, 24);
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(-1);
		add(comboBox);
		
		JButton button = new JButton("保存修改信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				u.setLoginName(textField.getText().trim());
				u.setPassword(textField_1.getText().trim());
				u.setCardId(textField_2.getText().trim());
				u.setName(textField_3.getText().trim());
				u.setPhone(textField_4.getText().trim());
				u.setCardType(comboBox.getSelectedIndex() + 1);
				java.sql.Timestamp modifyTime = new java.sql.Timestamp(new java.util.Date().getTime());
				u.setModifyTime(modifyTime);
				
				if(!DaoFactory.getUserDaoInstence().modifyReader(u)) {
					JOptionPane.showMessageDialog(null, "修改失败", "修改警告", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
					getTable().setModel(new ReaderInfoTableModel("", ""));
				}
			}
		});
		button.setBounds(803, 362, 133, 44);
		add(button);
		
		JButton btnNewButton = new JButton("删除数据");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DaoFactory.getUserDaoInstence().deletReader(u)) {
					JOptionPane.showMessageDialog(null, "删除失败", "删除警告", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
					getTable().setModel(new ReaderInfoTableModel("", ""));
				}
			}
		});
		btnNewButton.setBounds(803, 419, 133, 42);
		add(btnNewButton);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == radioButton) {
					u.setSex(1);
				}
			}
		});
		radioButton.setBounds(134, 362, 43, 27);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == radioButton_1) {
					u.setSex(2);
				}
			}
		});
		radioButton_1.setBounds(194, 362, 45, 27);
		add(radioButton_1);

		ButtonGroup sexType = new ButtonGroup();
		sexType.add(radioButton);
		sexType.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("读者");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == radioButton_1) {
					u.setReaderType(1);;
				}
			}
		});
		radioButton_2.setBounds(458, 362, 59, 27);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("管理员");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == radioButton_3) {
					u.setReaderType(2);;
				}
			}
		});
		radioButton_3.setBounds(360, 362, 86, 27);
		add(radioButton_3);
		
		ButtonGroup readerType = new ButtonGroup();
		readerType.add(radioButton_2);
		readerType.add(radioButton_3);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(328, 431, 72, 18);
		add(lblPhone);
		
		textField_4 = new JTextField();
		textField_4.setBounds(410, 428, 308, 24);
		add(textField_4);
		textField_4.setColumns(10);
		
		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting() && getTable().getSelectedRow() != -1) {
					TableModel model = getTable().getModel();
					int selectRow = getTable().getSelectedRow();
					u.setId((int) model.getValueAt(selectRow, 0));
					textField.setText((String) model.getValueAt(selectRow, 1));
					textField_1.setText((String) model.getValueAt(selectRow, 2));
					textField_2.setText((String) model.getValueAt(selectRow, 3));
					textField_3.setText((String) model.getValueAt(selectRow, 4));
					if("男".equals(model.getValueAt(selectRow, 5))) {
						radioButton.setSelected(true);
						u.setSex(1);
					} else if("女".equals(model.getValueAt(selectRow, 5))) {
						radioButton_1.setSelected(true);
						u.setSex(2);
					}
					
					if("管理员".equals(model.getValueAt(selectRow, 6))) {
						radioButton_3.setSelected(true);
						u.setReaderType(2);
					} else if("读者".equals(model.getValueAt(selectRow, 6))) {
						radioButton_2.setSelected(true);
						u.setReaderType(1);
					}
					
					textField_4.setText((String) model.getValueAt(selectRow, 8));
					
					if("本科生".equals(model.getValueAt(selectRow, 7))) {
						comboBox.setSelectedIndex(0);
					} else if("研究生".equals(model.getValueAt(selectRow, 7))) {
						comboBox.setSelectedIndex(1);
					} else if("教师".equals(model.getValueAt(selectRow, 7))) {
						comboBox.setSelectedIndex(2);
					} else if("领导".equals(model.getValueAt(selectRow, 7))) {
						comboBox.setSelectedIndex(3);
					} else if("管理员".equals(model.getValueAt(selectRow, 7))) {
						comboBox.setSelectedIndex(4);
					}
					repaint();
				}
			}
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"id", "loginName", "password", "cardId", "name", "sex", "readerType", "cardType", "phone", "creatTime", "modifyTime"
			}
		));
	}
}
