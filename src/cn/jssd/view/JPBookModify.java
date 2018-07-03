package cn.jssd.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cn.jssd.bean.Book;
import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;
import cn.jssd.model.BookTableModel;
import cn.jssd.model.BookTypeListModel;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class JPBookModify extends JPanel {
	/**
	 * ͼ����Ϣ������ͼ
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textBookId;
	private JTextField textPublisher;
	private JTextField textBookshelf;
	private JTextField textAuthor;
	private JTextField textBookName;
	private JTable table;
	private JTextField textBookId2;
	private JTextField textBookName2;
	private JTextField textAuthor2;
	private JTextField textPublisher2;
	private JTextField textPrice2;
	private JTextField textCollection2;
	private JTextField textBookShelf2;
	private JComboBox<String> comboBox_1;
	private int SelectId;
	
	/**
	 * Create the panel.
	 */
	public JPBookModify() {
		setLayout(null);
		
		JLabel lblBookId = new JLabel("ͼ����");
		lblBookId.setBounds(103, 79, 72, 18);
		add(lblBookId);
		
		JLabel lblBookName = new JLabel("ͼ������");
		lblBookName.setBounds(103, 164, 72, 18);
		add(lblBookName);
		
		JLabel lblBookType = new JLabel("ͼ������");
		lblBookType.setBounds(402, 164, 72, 18);
		add(lblBookType);
		
		JLabel lblPublisher = new JLabel("������");
		lblPublisher.setBounds(402, 79, 72, 18);
		add(lblPublisher);
		
		JLabel lblBookshelf = new JLabel("��ܱ��");
		lblBookshelf.setBounds(642, 79, 72, 18);
		add(lblBookshelf);
		
		JLabel lblBookAuthor = new JLabel("����");
		lblBookAuthor.setBounds(888, 79, 51, 18);
		add(lblBookAuthor);
		
		textBookId = new JTextField();
		textBookId.setBounds(189, 76, 178, 24);
		add(textBookId);
		textBookId.setColumns(10);
		
		textPublisher = new JTextField();
		textPublisher.setBounds(463, 76, 165, 24);
		add(textPublisher);
		textPublisher.setColumns(10);
		
		textBookshelf = new JTextField();
		textBookshelf.setBounds(714, 76, 146, 24);
		add(textBookshelf);
		textBookshelf.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setText("");
		textAuthor.setBounds(929, 76, 127, 24);
		add(textAuthor);
		textAuthor.setColumns(10);
		
		textBookName = new JTextField();
		textBookName.setBounds(189, 161, 178, 24);
		add(textBookName);
		textBookName.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>(new BookTypeListModel());
		comboBox.setEditable(false);
		comboBox.setBounds(482, 161, 146, 24);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 233, 1065, 248);
		add(scrollPane);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					SelectId = (int) table.getValueAt(table.getSelectedRow(), 0);
					textBookId2.setText((String) table.getValueAt(table.getSelectedRow(), 1));
					textBookName2.setText((String) table.getValueAt(table.getSelectedRow(), 2));
					textAuthor2.setText((String) table.getValueAt(table.getSelectedRow(), 4));
					textPublisher2.setText((String) table.getValueAt(table.getSelectedRow(), 5));
					textPrice2.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
					textCollection2.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
					textBookShelf2.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
					
					String seleItem = (String) table.getValueAt(table.getSelectedRow(), 3);
					Integer seleIndex = null;
					for(int i = 0; i < comboBox_1.getModel().getSize(); i ++) {
						if(comboBox_1.getModel().getElementAt(i).equals(seleItem)) {
							seleIndex = i;
						}
					}
					comboBox_1.setSelectedIndex(seleIndex);
					comboBox_1.repaint();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"id", "bookId", "bookName", "type", "author", "publisher", "price", "collection", "bookshelf", "createTime"
			}
		));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnQuery = new JButton("��ѯ");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Book book = new Book();
					book.setAuthor(textAuthor.getText().trim());
					book.setBookId(textBookId.getText().trim());
					book.setBookName(textBookName.getText().trim());
					if(!"".equals(textBookshelf.getText()))
						book.setBookshelf(Integer.parseInt(textBookshelf.getText().trim()));
					book.setPublisher(textPublisher.getText().trim());
					//�ҵ�ѡ���ͼ������
					String selectItem = (String) comboBox.getSelectedItem();
					Integer selectType = null;
					BookType b = new BookType();
					b.setDescription("");
					List<BookType> list = DaoFactory.getBookTypeInstence().queryBookType(b);
					Iterator<BookType> it = list.iterator();
					while(it.hasNext()) {
						BookType temp = it.next();
						if(temp.getDescription().equals(selectItem)) {
							selectType = temp.getType();
						}
					}
					if(selectType != null)
						book.setType(selectType);
					
					table.setModel(new BookTableModel(book));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setEnabled(true);
					textAuthor.setText("");
					textBookId.setText("");
					textBookName.setText("");
					textBookshelf.setText("");
					textPublisher.setText("");
					comboBox.setSelectedIndex(-1);
					comboBox.repaint();
					textAuthor2.setText("");
					textBookId2.setText("");
					textBookName2.setText("");
					textBookShelf2.setText("");
					textCollection2.setText("");
					textPublisher2.setText("");
					comboBox_1.setSelectedIndex(-1);
					comboBox_1.repaint();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "������������ָ�ʽ", "����", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();;
					JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnQuery.setBounds(714, 151, 146, 44);
		add(btnQuery);
		
		JLabel lblBookId2 = new JLabel("ͼ����");
		lblBookId2.setBounds(80, 524, 72, 18);
		add(lblBookId2);
		
		JLabel lblBookName2 = new JLabel("ͼ����");
		lblBookName2.setBounds(352, 524, 72, 18);
		add(lblBookName2);
		
		JLabel lblType2 = new JLabel("ͼ�����");
		lblType2.setBounds(610, 524, 72, 18);
		add(lblType2);
		
		JLabel lblAuthor2 = new JLabel("����");
		lblAuthor2.setBounds(855, 524, 72, 18);
		add(lblAuthor2);
		
		JLabel lblPublisher2 = new JLabel("������");
		lblPublisher2.setBounds(80, 577, 72, 18);
		add(lblPublisher2);
		
		JLabel lblPrice2 = new JLabel("��Ǯ");
		lblPrice2.setBounds(352, 577, 72, 18);
		add(lblPrice2);
		
		JLabel lblCollection2 = new JLabel("�ݲز���");
		lblCollection2.setBounds(610, 577, 72, 18);
		add(lblCollection2);
		
		JLabel lblBookShelf2 = new JLabel("��ܱ��");
		lblBookShelf2.setBounds(855, 577, 72, 18);
		add(lblBookShelf2);
		
		textBookId2 = new JTextField();
		textBookId2.setBounds(166, 521, 154, 24);
		add(textBookId2);
		textBookId2.setColumns(10);
		
		textBookName2 = new JTextField();
		textBookName2.setBounds(438, 521, 127, 24);
		add(textBookName2);
		textBookName2.setColumns(10);
		
		textAuthor2 = new JTextField();
		textAuthor2.setBounds(935, 521, 162, 24);
		add(textAuthor2);
		textAuthor2.setColumns(10);
		
		textPublisher2 = new JTextField();
		textPublisher2.setBounds(166, 574, 154, 24);
		add(textPublisher2);
		textPublisher2.setColumns(10);
		
		textPrice2 = new JTextField();
		textPrice2.setBounds(438, 574, 127, 24);
		add(textPrice2);
		textPrice2.setColumns(10);
		
		textCollection2 = new JTextField();
		textCollection2.setBounds(699, 574, 127, 24);
		add(textCollection2);
		textCollection2.setColumns(10);
		
		textBookShelf2 = new JTextField();
		textBookShelf2.setBounds(941, 574, 156, 24);
		add(textBookShelf2);
		textBookShelf2.setColumns(10);
		
		comboBox_1 = new JComboBox<>(new BookTypeListModel());
		comboBox_1.setBounds(696, 521, 130, 24);
		add(comboBox_1);
		
		JButton btnDelet = new JButton("ɾ��");
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book();
				book.setId(SelectId);
				if(DaoFactory.getBookInstence().deletBook(book)) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					table.setModel(new BookTableModel(book));
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelet.setBounds(556, 667, 146, 44);
		add(btnDelet);
		
		JButton btnSave = new JButton("����");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book();
				book.setId(SelectId);
				book.setAuthor(textAuthor2.getText().trim());
				book.setBookId(textBookId2.getText().trim());
				book.setBookName(textBookName2.getText().trim());
				book.setBookshelf(Integer.parseInt(textBookShelf2.getText().trim()));
				book.setCollection(Integer.parseInt(textCollection2.getText().trim()));
				book.setPrice(Double.parseDouble(textPrice2.getText().trim()));
				book.setPublisher(textPublisher2.getText().trim());
				//�ҵ�ѡ�е�����
				String selectItem = (String) comboBox_1.getSelectedItem();
				Integer selectType = null;
				BookType b = new BookType();
				b.setDescription("");
				List<BookType> list = DaoFactory.getBookTypeInstence().queryBookType(b);
				Iterator<BookType> it = list.iterator();
				while(it.hasNext()) {
					BookType temp = it.next();
					if(temp.getDescription().equals(selectItem)) {
						selectType = temp.getType();
					}
				}
				if(selectType != null)
					book.setType(selectType);
				
				if(DaoFactory.getBookInstence().modifyBook(book)) {
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					table.setModel(new BookTableModel(book));
				} else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnSave.setBounds(770, 667, 120, 44);
		add(btnSave);

	}
}
