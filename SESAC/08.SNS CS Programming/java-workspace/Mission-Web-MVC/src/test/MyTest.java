package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.member.dao.LoginDAO;
import kr.co.mlec.member.vo.LoginVO;
import kr.co.mlec.page.vo.PageVO;

public class MyTest {
	
	@Ignore
	@Test
	public void 전체게시글조회서비스() throws Exception {
		
		BoardService service = new BoardService();
		List<BoardVO> list = service.selectAllBoard(1);
		
		// assertNotNull(list); // list가 null이 아닌지 체크
		for (BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	@Ignore
	@Test
	public void 로그인서비스() throws Exception {
		LoginDAO dao = new LoginDAO();
		
		LoginVO vo = new LoginVO();
		vo.setId("admin");
		vo.setPassword("admin");
		LoginVO user = dao.login(vo);
		
		assertNotNull(user);
	}
	
	@Test
	public void 선택게시글조회() throws Exception {
		BoardService service = new BoardService();
		BoardVO board = service.selectBoardNo(1);
		
		System.out.println(board);
	}
}
