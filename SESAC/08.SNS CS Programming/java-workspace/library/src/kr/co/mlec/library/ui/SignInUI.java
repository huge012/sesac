package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class SignInUI extends BaseLoginUI {
		
	public void execute()
	{
		String id = scanStr("아이디를 입력하세요 : ");
		String pw = scanStr("비밀번호를 입력하세요 : ");
		
		SelectMemberUI.user.setId(id);
		SelectMemberUI.user.setPw(pw);
		
		boolean result = dao.signIn();
		
		if(result)
		{
			System.out.println("로그인 성공!");
			BaseUI menu; 
			if (SelectMemberUI.user.getIsAdmin() == 1)
				menu = new AdminMenuUI();
			else
				menu = new MemberMenuUI();
			menu.execute();
		}
		else
			System.out.println("아이디/패스워드가 다릅니다. 다시 로그인해주세요.");
	}
	
}
