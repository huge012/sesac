package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.RentBookDAO;
import kr.co.mlec.library.vo.ManageVO;
import kr.co.mlec.library.vo.MemberVO;

public class RentBookUI extends BaseUI {
	
	public void execute()
	{
		RentBookDAO dao = new RentBookDAO();
		ManageVO rent = new ManageVO();
		
		rent.setBookCode(scanInt("빌릴 책 코드를 입력하세요 : "));
		rent.setId(SelectMemberUI.user.getId());
		
		int result = dao.insertRentInfo(rent);
		
		if (result != 0)
			System.out.println("성공적으로 빌렸습니다. 대출 기한은 7일입니다.");
		else
			System.out.println("지금은 대출할 수 없습니다.");
		
	}
	
}
