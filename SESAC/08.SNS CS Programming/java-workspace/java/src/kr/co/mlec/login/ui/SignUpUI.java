package kr.co.mlec.login.ui;

import kr.co.mlec.login.dao.LoginDAO;
import kr.co.mlec.login.vo.LoginVO;

/*
 * 회원가입
 * id, pass 입력받아서 등록
 * 
 */

public class SignUpUI extends BaseUI {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String id = scanStr("아이디를 입력하세요 : ");
		String pass = scanStr("비밀번호를 입력하세요 : ");

		LoginVO user = new LoginVO();
		user.setId(id);
		user.setPass(pass);
		
		LoginDAO dao = new LoginDAO();
		int result = dao.signUp(user);
		
		if (result > 0)
			System.out.println("회원가입되셨습니다. 로그인해주세요.");
		else
			System.out.println("이미 등록된 ID입니다. 다시 회원가입해주세요.");
	}

}
