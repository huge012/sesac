package kr.co.mlec.library.memberui;

import java.util.List;

import kr.co.mlec.library.dao.MemberDAO;
import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.loginui.MemberLoginUI;
import kr.co.mlec.library.vo.LoginVO;
import kr.co.mlec.library.vo.RentalVO;

public class ReturnBookUI extends BaseUI {
	// 2.반납
	// 로그인 정보를 가지고 있는 loginVO에서 아이디를 가져오기
	// 해당 아이디로 대출중인 책 정보 출력
	// 반납 하시겠습니까?
	// Y -> 해당 열을 t_rental에서 삭제 -> 해당 도서의 t_books에서의 status update
	/// 완료 안내 출력

	public static LoginVO login;

	@Override
	public void execute() {

		MemberDAO dao = new MemberDAO();
		RentalVO rental = new RentalVO();
		String logID = MemberLoginUI.logInfo.getId();
		System.out.println("현재 로그인 아이디 : " + logID);

	
		List<RentalVO> returnBookList = dao.rentalBookList(rental);
		System.out.println("현재 로그인 아이디 : " + logID);
		System.out.println("==============================대출중인 도서 목록==================================");
		System.out.println("번호\t\t      제목\t\t\t     저자\t\t   대출일\t\t       반납 기한");

		for (RentalVO returnBook : returnBookList) {
			System.out.println(returnBook.getbNo() + returnBook.getTitle() + returnBook.getAuthor()
					+ returnBook.getRenDate() + returnBook.getRenDate());
		}
		System.out.println("============================================================================");

		int returnBNo = scanInt("반납하실 도서 코드를 입력하세요 : ");
		dao.returnBook(returnBNo);
		System.out.println("--반납이 완료되었습니다.-- 또오세요~~^^/");
	}
}
