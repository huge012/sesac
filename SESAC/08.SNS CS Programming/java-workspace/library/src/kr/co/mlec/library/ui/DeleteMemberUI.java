package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.UpdateUserInfoDAO;
import kr.co.mlec.library.vo.MemberVO;

public class DeleteMemberUI extends BaseUI {

	public void execute() {
		String id = scanStr("삭제할 아이디를 입력하세요: ");
		String pw = scanStr("비밀번호를 입력하세요: ");
		
		UpdateUserInfoDAO dao = new UpdateUserInfoDAO();
		MemberVO user = new MemberVO();
		
		user.setId(id);
		user.setPw(pw);
		int rs = dao.deleteMemberInfo(user);
		
		if(rs > 0)
		{
			System.out.println( user.getId() + "님의 아이디는 삭제 되었습니다.\n");
		}
		else
		{
			System.out.println("삭제가 실패되었습니다.");
			System.out.println();
		}
		
	}
	
}
