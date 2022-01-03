package kr.co.mlec.library.vo;

public class ManageVO {

	private int number;
	private int bookCode;
	private String id;
	private int lendDate;
	private int deadLine;
	private int returnDate;
	
	
	// 생성자
	public ManageVO()
	{
		super();
	}
	
	public ManageVO(int number, int bookCode, String id, int lendDate, int deadLine, int returnDate) {
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

	public int getLendDate() {
		return lendDate;
	}

	public void setLendDate(int lendDate) {
		this.lendDate = lendDate;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public int getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}

	// toString
	@Override
	public String toString() {
		return "ManageVO [number=" + number + ", bookCode=" + bookCode + ", id=" + id + ", lendDate=" + lendDate
				+ ", deadLine=" + deadLine + ", returnDate=" + returnDate + "]";
	}
	
	
	
	
}
