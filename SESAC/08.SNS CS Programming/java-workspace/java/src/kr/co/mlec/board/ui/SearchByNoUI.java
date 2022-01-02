package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class SearchByNoUI extends BaseUI {

	@Override
	public void execute() {
		int no = scanInt("조회할 글번호를 입력하세요 : ");
		
		BoardDAO dao = new BoardDAO();
		BoardVO result = dao.selectByNo(no);
		//BoardDAO가 가져온 값 = BoardVO 형태로 받아온다 (result로 받음)
		
		if(result == null) {
			System.out.println("조회된 게시물이 없습니다.\n\n");
		} else { //조회된 값이 있는 경우 출력
			System.out.println("================================");
			System.out.println("\t번   호 : " + result.getNo());
			System.out.println("\t제   목 : " + result.getTitle());
			System.out.println("\t글쓴이 : " + result.getWriter());
			System.out.println("\t등록일 : " + result.getReg_date());
			System.out.println("================================\n\n");
		}
	}

}
