package kr.co.mlec.board.ui;

import kr.co.mlec.board.dao.BoardDAO;

public class DeleteUI extends BaseUI {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int no = scanInt("삭제할 게시글 번호를 입력하세요 : ");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.deleteBoard(no);
		
		if (result == 1)
		{
			System.out.println("[" + no + "] 번째 게시글이 삭제되었습니다.\n");
		}
		else
		{
			System.out.println("삭제할 게시글이 없습니다.");
			System.out.println();
		}
		
	}

}
