package kr.co.mlec.board.ui;

import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	@Override
	public void execute() {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll(); //-> 여기 이부분을 제대로 체크
		
		
		//조회할 게시물이 없으면    if(list.isEmpty()) -> 조회할 게시물이 없습니다.
		//있으면 모두 출력 (for each 문으로 출력하는게 가장 쉬움)
		if(list.isEmpty()) {
			System.out.println("조회할 게시물이 없습니다.\n\n");
		} else {
			System.out.println("=====================================");
			System.out.println("번호\t\t   등록일\t\t글쓴이\t   제목");
			System.out.println("=====================================");
			
			//foreach문 사용하여 출력
			for(BoardVO board : list) {
				System.out.println(board.getNo()+"\t"
						+board.getReg_date()+"\t "
						+board.getWriter()+"      "
						+board.getTitle());
			}

			System.out.println("=====================================\n\n");

		}

	}
}
