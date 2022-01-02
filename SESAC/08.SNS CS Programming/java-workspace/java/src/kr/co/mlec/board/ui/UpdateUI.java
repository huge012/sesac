package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class UpdateUI extends BaseUI {

	@Override
	public void execute() {
		int no = scanInt("수정할 글 번호를 입력하세요 : ");
		String title = scanStr("변경할 제목을 입력하세요 : ");
		String writer = scanStr("변경할 글쓴이를 입력하세요 : ");
		
		BoardDAO dao = new BoardDAO();
		BoardVO board = new BoardVO();
		
		dao.updateBoard(board);
		board.setNo(no);
		board.setTitle(title);
		board.setWriter(writer);
		int result = dao.updateBoard(board);
		
		if(result == 0) {
			System.out.println("수정할 게시글이 없습니다.");
			System.out.println();
		} else {
			System.out.println("["+no+"]번 게시글이 수정되었습니다.\n");
		}

	}

}
