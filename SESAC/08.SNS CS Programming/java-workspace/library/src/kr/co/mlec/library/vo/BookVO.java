package kr.co.mlec.library.vo;

public class BookVO {
	private int bookCode;
	private String title;
	private String writer;
	private String publisher;
	private int availableBook;
	
	// 생성자
	public BookVO()
	{
		super();
	}
	
	public BookVO(int bookCode, String title, String writer, String publisher, int availableBook) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.availableBook = availableBook;
	}
	
	// getter, setter
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getAvailableBook() {
		return availableBook;
	}
	public void setAvailableBook(int availableBook) {
		this.availableBook = availableBook;
	}
	
	// toString
	@Override
	public String toString() {
		return "BookVO [bookCode=" + bookCode + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", availableBook=" + availableBook + "]";
	}
	
	
	
}
