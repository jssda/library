package cn.jssd.bean;

public class BookType {
	private Integer id = null;
	private Integer type = null;
	private Integer borrowingDays = null;
	private String description = null;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getBorrowingDays() {
		return borrowingDays;
	}

	public void setBorrowingDays(int borrowingDays) {
		this.borrowingDays = borrowingDays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getDescription();
	}
}
