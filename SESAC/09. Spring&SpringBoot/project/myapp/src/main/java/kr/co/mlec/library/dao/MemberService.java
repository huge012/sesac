package kr.co.mlec.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.library.vo.BookVO;
import kr.co.mlec.library.vo.RentalVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	
	public RentalVO borrowBook(RentalVO rental) {
		return dao.borrowBook(rental);
	}
	
	public boolean checkRental(RentalVO rental) {
		return dao.checkRental(rental);
	}
	
	public List<BookVO> rentalSelect(BookVO book) {
		return dao.rentalSelect(book);
	}
	
	public List<RentalVO> rentalBookList(RentalVO rental) {
		return dao.rentalBookList(rental);
	}
	
	public void returnBook(int returnBNo) {
		dao.returnBook(returnBNo);
	}
	
	public List<BookVO> selectAllBook() {
		return dao.selectAllBook();
	}
	
	public List<BookVO> selectByTitleBook(String bTitle) {
		return dao.selectByTitleBook(bTitle);
	}
	
	public BookVO selectByNoBook(int bookNo) {
		return dao.selectByNoBook(bookNo);
	}
}
