package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.RentBookDAO;
import kr.co.mlec.library.vo.ManageVO;
import kr.co.mlec.library.vo.MemberVO;

public class ReturnBookUI extends BaseUI {
	
	public void execute()
	{
		RentBookDAO dao = new RentBookDAO();
		ManageVO rent = new ManageVO();
		
		rent.setBookCode(scanInt("반납할 책 코드를 입력하세요 : "));
		rent.setId(SelectMemberUI.user.getId());
		
		int result = dao.ReturnInfo(rent);
		
		if (result != 0)
			System.out.println("성공적으로 반납했습니다. 이용해주셔서 감사합니다.");
		else
			System.out.println("빌린 정보가 일치하지 않습니다. 다시 시도해주세요.");
	}
	
}
