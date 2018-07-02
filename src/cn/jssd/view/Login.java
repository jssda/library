package cn.jssd.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jssd.factory.DaoFactory;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("管理员登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 596) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - 412) / 2,
				596 , 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("用户名");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(56, 152, 121, 40);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\eclipse-workspace\\library\\image\\top.gif"));
		lblNewLabel.setBounds(0, 0, 578, 121);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(56, 205, 121, 40);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(193, 158, 285, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 211, 285, 32);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {		//登陆事件监听
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				String pass = String.valueOf((passwordField.getPassword())).trim();
				
				if("".equals(name) || "".equals(pass)) {
					JOptionPane.showMessageDialog(Login.this, "请检查登陆信息", "登陆警告", JOptionPane.WARNING_MESSAGE);
				} else if(! DaoFactory.getUserDaoInstence().checkLogin(name, pass)) {
					JOptionPane.showMessageDialog(Login.this, "请检查登陆信息", "登陆警告", JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("登陆成功");
					Login.this.setVisible(false);
					new Manage().setVisible(true);
				}
			}
		});
		button.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		button.setBounds(181, 272, 121, 45);
		contentPane.add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_1.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		button_1.setForeground(Color.BLACK);
		button_1.setBounds(350, 272, 128, 45);
		contentPane.add(button_1);
	}
}
