package kr.co.mlec.board;

/*
 * 자바빈즈 클래스
 * 1. 패키지 존재
 * 2. 클래스의 접근제한자 public
 * 3. 멤버 변수의 접근제한자 private
 * 4. getter, setter 구현
 * 5. 기본 생성자
 * 
 * 기본 생성자 alt+shift+s			c
 * 매개변수 생성자 alt+shift+s		o
 * getter,setter alt+shift+s	r
 * toString() alt+shift+s		s
 * 
 */

public class BoardVO {
	private int no;
	private String title;
	
	public BoardVO() {
	}
	
	public BoardVO(int no, String title) {
		this.no = no;
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
