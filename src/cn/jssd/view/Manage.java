package cn.jssd.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Dimension;

public class Manage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Manage frame = new Manage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Manage() {
		setBackground(UIManager.getColor("Button.disabledForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 1200) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - 800) / 2, 1200, 800);
		this.setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout layout = new CardLayout(0, 0);
		contentPane.setLayout(layout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setRequestFocusEnabled(false);
		menuBar.setSize(new Dimension(0, 80));
		menuBar.setBounds(new Rectangle(0, 0, 0, 80));
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("图书管理信息");
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem = new JMenuItem("读者信息添加");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp1");
			}
		});
		mntmNewMenuItem.setFont(new Font("Serif", mntmNewMenuItem.getFont().getStyle(), 15));
		menu.add(mntmNewMenuItem);

		JMenuItem menuItem = new JMenuItem("读者信息查询修改与删除");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp3");
			}
		});
		menuItem.setFont(UIManager.getFont("Button.font"));
		menu.add(menuItem);

		JMenu mnNewMenu = new JMenu("图书信息管理");
		menuBar.add(mnNewMenu);

		JMenu menu_1 = new JMenu("图书类别管理");
		mnNewMenu.add(menu_1);

		JMenuItem menuItem_2 = new JMenuItem("图书类别添加");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp4");
			}
		});
		menu_1.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("图书类别修改");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp5");
			}
		});
		menuItem_3.setFont(UIManager.getFont("Button.font"));
		menu_1.add(menuItem_3);

		JMenu mnNewMenu_1 = new JMenu("图书信息管理");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书信息添加");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp6");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("图书信息管理");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp7");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_2 = new JMenu("借阅管理");
		mnNewMenu_2.setBounds(new Rectangle(0, 0, 0, 80));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("图书借阅");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp8");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("图书归还");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp9");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenuItem mntmborrowInfoQuery = new JMenuItem("借阅信息搜索");
		mntmborrowInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(contentPane, "jp10");
			}
		});
		mnNewMenu_2.add(mntmborrowInfoQuery);

		JPanel panel = new JPReaderInfoAdd();
		contentPane.add(panel, "jp1");

		JPanel panel_2 = new JPReaderInfoQuery();
		contentPane.add(panel_2, "jp3");

		JPanel panel_3 = new JPBookTypeAdd();
		contentPane.add(panel_3, "jp4");

		JPanel panel_4 = new JPBookTypeModify();
		contentPane.add(panel_4, "jp5");

		JPanel panel_5 = new JPBookAdd();
		contentPane.add(panel_5, "jp6");

		JPanel panel_6 = new JPBookModify();
		contentPane.add(panel_6, "jp7");

		JPanel panel_7 = new JPBorrow();
		contentPane.add(panel_7, "jp8");

		JPanel panel_8 = new JPReturn();
		contentPane.add(panel_8, "jp9");

		JPanel panel_9 = new JPBorrowQuery();
		contentPane.add(panel_9, "jp10");
	}

}
