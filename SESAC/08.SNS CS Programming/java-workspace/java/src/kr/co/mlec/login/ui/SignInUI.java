package kr.co.mlec.login.ui;

import kr.co.mlec.board.ui.BoardUI;
import kr.co.mlec.login.dao.LoginDAO;
import kr.co.mlec.login.vo.LoginVO;

/*
 * 로그인
 * 아이디, 비밀번호 입력받아서 맞으면 Board 실행
 */

public class SignInUI extends BaseUI {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id = scanStr("아이디를 입력하세요 : ");
		String pass = scanStr("비밀번호를 입력하세요 : ");		
		LoginVO user = new LoginVO();
		user.setId(id);
		user.setPass(pass);
		
		LoginDAO dao = new LoginDAO();
		boolean result = dao.signIn(user);
		
		if (result)
		{
			System.out.println("로그인 성공!");
			BoardUI board = new BoardUI();
			board.execute();
		}
		else
			System.out.println("아이디/패스워드가 다릅니다. 다시 로그인해주세요.");
		
	}

}
