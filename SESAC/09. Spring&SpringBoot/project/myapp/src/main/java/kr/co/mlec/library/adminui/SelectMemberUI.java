package kr.co.mlec.library.adminui;


import kr.co.mlec.library.dao.AdminDAO;
import kr.co.mlec.library.loginui.BaseUI;
import kr.co.mlec.library.vo.BookVO;
import kr.co.mlec.library.vo.LoginVO;

public class SelectMemberUI extends BaseUI {

	@Override
	public void execute() {
		
		AdminDAO dao = new AdminDAO();
		java.util.List<LoginVO> list = dao.selectMember();
		
		
		if(list.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.\n\n");
		}else {
			System.out.println("\n");
			System.out.println("\t\t\t --도서관 회원 목록--");
			System.out.println("======================================================");
			System.out.println("아이디\t이름\t\t       이메일\t\t  가입날짜");
			System.out.println("======================================================");
			
			for(LoginVO member : list) {
//				System.out.println(member.getId()+"\t\t"
//						+member.getName()+"\t\t"
//						+member.getEmail()+"\t\t"
//						+member.getJoindate());
				System.out.printf("%-8s\t%-8s\t%-20s\t%-15s\n", member.getId(), member.getName(), member.getEmail(), member.getJoindate());
			}
			System.out.println("======================================================\n\n");
			
		}
		
	}
	
}
