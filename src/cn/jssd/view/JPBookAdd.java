package cn.jssd.view;

import javax.swing.JPanel;

import cn.jssd.bean.Book;
import cn.jssd.bean.BookType;
import cn.jssd.factory.DaoFactory;
import cn.jssd.model.BookTypeListModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class JPBookAdd extends JPanel {

	/**
	 * 图书信息添加视图
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textBookId;
	private JTextField textBookName;
	private JTextField textAuthor;
	private JTextField textPublisher;
	private JTextField textPrice;
	private JTextField textCellection;
	private JTextField textBookshelf;

	/**
	 * Create the panel.
	 */
	public JPBookAdd() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("bookId");
		lblNewLabel.setBounds(109, 122, 72, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("bookName");
		lblNewLabel_1.setBounds(435, 122, 72, 18);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("type");
		lblNewLabel_2.setBounds(828, 122, 47, 18);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("author");
		lblNewLabel_3.setBounds(109, 310, 72, 18);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("publisher");
		lblNewLabel_4.setBounds(435, 310, 72, 18);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("price");
		lblNewLabel_5.setBounds(828, 310, 47, 18);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("collection");
		lblNewLabel_6.setBounds(91, 485, 89, 18);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("bookshelf");
		lblNewLabel_7.setBounds(435, 488, 72, 18);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("请输入添加的图书信息");
		lblNewLabel_8.setBounds(58, 31, 171, 67);
		add(lblNewLabel_8);
		
		JComboBox<String> comboBox = new JComboBox<>(new BookTypeListModel());
		comboBox.setBounds(895, 119, 171, 24);
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(0);
		add(comboBox);
		
		textBookId = new JTextField();
		textBookId.setBounds(182, 119, 220, 24);
		add(textBookId);
		textBookId.setColumns(10);
		
		textBookName = new JTextField();
		textBookName.setBounds(537, 119, 231, 24);
		add(textBookName);
		textBookName.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(182, 307, 220, 24);
		add(textAuthor);
		textAuthor.setColumns(10);
		
		textPublisher = new JTextField();
		textPublisher.setBounds(537, 307, 231, 24);
		add(textPublisher);
		textPublisher.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(896, 307, 170, 24);
		add(textPrice);
		textPrice.setColumns(10);
		
		textCellection = new JTextField();
		textCellection.setBounds(182, 482, 86, 24);
		add(textCellection);
		textCellection.setColumns(10);
		
		textBookshelf = new JTextField();
		textBookshelf.setBounds(537, 485, 231, 24);
		add(textBookshelf);
		textBookshelf.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Book book = new Book();
					book.setBookId(textBookId.getText().trim());
					book.setBookName(textBookName.getText().trim());
					book.setAuthor(textAuthor.getText().trim());
					book.setBookshelf(Integer.parseInt(textBookshelf.getText().trim()));
					book.setCollection(Integer.parseInt(textCellection.getText().trim()));
					book.setPrice(Double.parseDouble(textPrice.getText().trim()));
					book.setPublisher(textPublisher.getText().trim());
					
					//找到类型并设置
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
					book.setType(selectType);
					
					if(DaoFactory.getBookInstence().addBook(book)) {
						JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "添加失败", "错误", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "请检查数字输入信息", "输入错误", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(889, 609, 113, 27);
		add(btnNewButton);

		
	}
}
