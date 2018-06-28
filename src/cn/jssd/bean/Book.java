package cn.jssd.bean;

import java.util.Date;

public class Book {

	private String bookId = null;
	private String bookName = null;
	private int type = 0;
	private String author = null;
	private String publisher = null;
	private double price = 0f;
	private int collection = 0;
	private int bookshelf = 0;
	private Date createTime = null;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(int bookshelf) {
		this.bookshelf = bookshelf;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
