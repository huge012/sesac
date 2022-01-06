package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.UpdateUserInfoDAO;
import kr.co.mlec.library.vo.MemberVO;

public class UpdateMemberInfoUI extends BaseUI {
	
	public void execute()
	{
		String id = scanStr("수정할 회원의 아이디를 입력하세요: ");
		String pw = scanStr("수정할 비밀번호를 입력하세요: ");
		int phone = scanInt("수정할 전화번호를 입력하세요: ");
		
		UpdateUserInfoDAO dao = new UpdateUserInfoDAO();
		MemberVO member = new MemberVO();
		
		member.setId(SelectMemberUI.user.getId());
		member.setId(id);
		member.setPw(pw);
		member.setPhone(phone);
		int result = dao.updateInfo(member);
		
		if(result == 0) 
		{
			System.out.println("변경하지 못했습니다. 다시 하세요.");
		}
		else
		{
			System.out.println("비밀번호가 수정되었습니다.");
			System.out.println("전화번호가 수정되었습니다.");
		}
		
	}
	
}
