package kr.co.mlec.library.ui;

import java.util.List;

import kr.co.mlec.library.dao.RentBookDAO;
import kr.co.mlec.library.vo.ManageVO;

public class SearchMyRentUI extends BaseUI {
	
	public void execute() {
		
		RentBookDAO dao = new RentBookDAO();
		List<ManageVO> list = dao.SearchMyRent();
		if(list.isEmpty())
		{
			System.out.println("니가 빌린책은 없어 돌아가.\n\n");
		}
		else {
			System.out.println("-----------------------------");
			System.out.println("책 번호\t\t id\t\t 빌린 날\t 반납기한");
			System.out.println("-----------------------------");
			
			for(ManageVO book : list) {
				System.out.println(book.getBookCode()+ "\t"
						+book.getId()+"\t"
						+book.getLendDate()+"\t"
						+book.getDeadLine());
			}
			
			System.out.println("-----------------------------");
		}   
	}

	
}
