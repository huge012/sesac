package kr.co.mlec.library.ui;

import kr.co.mlec.library.dao.LoginDAO;
import kr.co.mlec.library.vo.MemberVO;

public class BaseLoginUI extends BaseUI {
	protected LoginDAO dao;
	
	public BaseLoginUI() {
		super();
		dao = new LoginDAO();
	}
}
