package kr.co.mlec.board.vo;

import kr.co.mlec.board.dao.BoardDAO;

/*
 * 	AddUI 에 실제 실행할 내용을 작성할 때,
 * 
 *  BoardDAO dao = new BoardDAO();
	dao.insertBoard(title, writer); //입력받은 내용 전달 -> dao에서 db와 연결 -> db에서 돌아온 후 안내문 출력 (어떤 곳에 저장되는 지는 모름)
	하지만, 입력한 내용이 제목,작성자 2개만 있다는 보장이 없다. 파라미터로 직접 받는 방법은 좋지 않음
	VO(Value Object),DTO(Data Terminal Object) : 실제 값을 저장하는 클래스 <-> 기능 클래스
	  ->테이블 하나당 한 개씩 만든다
	  
	VO에서 자동으로 만들어야 할 것들  
	1. 디폴트 생성자
	2. 매개변수 생성자
	3. getter/setter 메서드
	4. toString 메서드
	-> Source로 자동 생성
 */
public class BoardVO {
	
	private int no;
	private String title;
	private String writer;
	private String reg_date;
	
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String writer, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.reg_date = reg_date;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", reg_date=" + reg_date + "]";
	}
	
	
	
	
}