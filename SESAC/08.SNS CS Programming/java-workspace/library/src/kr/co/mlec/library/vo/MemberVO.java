package kr.co.mlec.library.vo;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private int birth;
	private int phone;
	private int lending_book_number;
	private int isAdmin;
	
	// 생성자
	public MemberVO()
	{
		super();
	}
	
	public MemberVO(String id, String pw, String name, int birth, int phone, int lending_book_number, int isAdmin) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.lending_book_number = lending_book_number;
		this.isAdmin = isAdmin;
	}
	
	// getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getLending_book_number() {
		return lending_book_number;
	}
	public void setLending_book_number(int lending_book_number) {
		this.lending_book_number = lending_book_number;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	//toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", birth=" + birth + ", phone=" + phone + ", lending_book_number="
				+ lending_book_number + ", isAdmin=" + isAdmin + "]";
	}

	
}
