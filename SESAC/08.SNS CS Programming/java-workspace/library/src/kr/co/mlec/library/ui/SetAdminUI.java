package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.UpdateUserInfoDAO;
import kr.co.mlec.library.vo.MemberVO;

public class SetAdminUI extends BaseUI {

	public void execute() {
		String id = scanStr("관리자로 지정할 id를 입력하세요: ");
		
		UpdateUserInfoDAO dao = new UpdateUserInfoDAO();
		MemberVO user = new MemberVO();
		
		user.setId(id);
		int rs = dao.setupManager(user);
		
		if (rs > 0) {
			System.out.println(user.getId() + "는 관리자로 등록되었습니다.\n");
		} else {
			System.out.println("등록이 실패되었습니다.");
			System.out.println();
		}
		
	}

}
