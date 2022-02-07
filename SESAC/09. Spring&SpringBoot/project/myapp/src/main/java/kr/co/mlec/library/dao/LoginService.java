package kr.co.mlec.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.library.vo.LoginVO;

@Service
public class LoginService {
	
	@Autowired
	LoginDAO dao; // new LoginDao();
	
	public void MemberLogin(LoginVO library) {
		dao.MemberLogin(library);
	}
	
	public boolean createAdmin(LoginVO library) {
		return dao.createAdmin(library);
	}
	
	public boolean createMember(LoginVO library) {
		return dao.createMember(library);
	}
	
	public int CheckID(LoginVO library) {
		return dao.CheckID(library);
	}
	
	
	
}
