package kr.co.mlec.library.vo;

public class ManageVO {

	private int number;
	private int bookCode;
	private String id;
	private String lendDate;
	private String deadLine;
	private String returnDate;
	
	
	// 생성자
	public ManageVO()
	{
		super();
	}
	
	public ManageVO(int bookCode, String id, String lendDate, String deadLine) {
		super();
		this.bookCode = bookCode;
		this.id = id;
		this.lendDate = lendDate;
		this.deadLine = deadLine;
	}

	public ManageVO(int number, int bookCode, String id, String lendDate, String deadLine, String returnDate) {
		super();
		this.number = number;
		this.bookCode = bookCode;
		this.id = id;
		this.lendDate = lendDate;
		this.deadLine = deadLine;
		this.returnDate = returnDate;
	}

	
	// getter setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLendDate() {
		return lendDate;
	}

	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	// toString
	@Override
	public String toString() {
		return "ManageVO [number=" + number + ", bookCode=" + bookCode + ", id=" + id + ", lendDate=" + lendDate
				+ ", deadLine=" + deadLine + ", returnDate=" + returnDate + "]";
	}
	
	
	
	
}
