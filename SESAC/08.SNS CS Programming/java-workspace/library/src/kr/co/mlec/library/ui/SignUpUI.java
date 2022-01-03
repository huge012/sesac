package kr.co.mlec.library.ui;

import kr.co.mlec.library.vo.MemberVO;

public class SignUpUI extends BaseLoginUI {

	public SignUpUI(MemberVO user)
	{
		super(user);
	}
	
	public void execute()
	{
		user.setId(scanStr("아이디를 입력하세요 : "));
		user.setPw(scanStr("비밀번호를 입력하세요 : "));
		user.setName(scanStr("이름을 입력하세요 : "));
		user.setBirth(scanInt("생년월일 8자리를 입력하세요 : "));
		user.setPhone(scanInt("전화번호 11자리를 입력하세요 : "));
		
		int result = dao.signUp(user);
		
		if (result > 0)
			System.out.println("회원가입되셨습니다. 로그인해주세요.");
		else
			System.out.println("이미 등록된 ID입니다. 다시 회원가입해주세요.");
	}
	
}
