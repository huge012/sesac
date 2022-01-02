package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class AddUI extends BaseUI {

	@Override
	public void execute() {
		
		String title = scanStr("게시글 제목을 입력하세요 : ");
		String writer = scanStr("글쓴이를 입력하세요 : ");
		
		BoardDAO dao = new BoardDAO();
		
		// dao.insertBoard(title, writer);
		// 입력받은 내용 전달 -> dao에서 db와 연결 -> db에서 돌아온 후 안내문 출력 (어떤 곳에 저장되는 지는 모름)
		// 하지만, 입력한 내용이 제목,작성자 2개만 있다는 보장이 없다. 파라미터로 직접 받는 방법은 좋지 않음
		// VO(Value Object),DTO(Data Terminal Object) : 실제 값을 저장하는 클래스 <-> 기능 클래스
		// 	->테이블 하나당 한 개씩 만든다
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		int success = dao.insertBoard(board);
		
		if (success > 0)
			System.out.println("게시글 등록이 완료되었습니다.");
		else
			System.out.println("게시글 등록에 실패했습니다.");
	}

}
