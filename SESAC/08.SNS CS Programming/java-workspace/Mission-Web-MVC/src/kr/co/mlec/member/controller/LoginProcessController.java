package kr.co.mlec.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.member.service.LoginService;
import kr.co.mlec.member.vo.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO(id, password);
		
		LoginService service = new LoginService();
		LoginVO userVO = service.login(loginVO);
		
		String url = "";
		if (userVO == null) {
			// 로그인 실패
			url = "/login.do";
		} else {
			// 로그인 성공
			url = "";
			
			// 서블릿에서는 session이 내장객체가 아니므로 객체를 얻어와야 함, 얻어와서 userVO 등록
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
		}
		// 포워딩 시키는게 아니라 survlet에서 바로 응답을 함
		
		//response.sendRedirect(url);
		
		// sendRedirect 하기위해 'redirect:'라는 접두어 붙여서 return
		return "redirect:"+url; // "redirect:/Mission-Web-MVC/login.do"
	}

}
