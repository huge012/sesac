package kr.co.mlec.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.library.vo.BookVO;
import kr.co.mlec.library.vo.LoginVO;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO dao;
	
	public List<LoginVO> selectMember() {
		return dao.selectMember();
	}
	
	public List<BookVO> selectAllBook() {
		return dao.selectAllBook();
	}
	
	public BookVO selectBook(int bNo) {
		return dao.selectBook(bNo);
	}
	
	public int addBook(BookVO library) {
		return dao.addBook(library);
	}
	
	public int updateBook(BookVO updateB) {
		return dao.updateBook(updateB);
	}
	
	public int deleteBook(BookVO deleteBook) {
		return dao.deleteBook(deleteBook);
	}
	
	
}
