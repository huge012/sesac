package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class SignInUI extends BaseLoginUI {
	
	public SignInUI(MemberVO user)
	{
		super(user);
	}
	
	public void execute()
	{
		String id = scanStr("아이디를 입력하세요 : ");
		String pw = scanStr("비밀번호를 입력하세요 : ");
		
		user.setId(id);
		user.setPw(pw);
		user.setIsAdmin(user.getIsAdmin());
		
		boolean result = dao.signIn(user);
		
		if(result)
		{
			System.out.println("로그인 성공!");
			BaseUI menu; 
			if (user.getIsAdmin() == 1)
				menu = new AdminMenuUI(user);
			else
				menu = new MemberMenuUI(user);
			menu.execute();
		}
		else
			System.out.println("아이디/패스워드가 다릅니다. 다시 로그인해주세요.");
	}
	
}
