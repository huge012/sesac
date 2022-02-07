package kr.co.mlec.library.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.mlec.library.dao.LoginService;
import kr.co.mlec.library.vo.LoginVO;

public class MyApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5.xml");
		LoginService service = ctx.getBean("loginService", LoginService.class);
		LoginVO vo = new LoginVO("admin", "admin", null, null, null, 0);
		service.MemberLogin(vo);
		
		//insert Test
		//LoginVO vo2 = new LoginVO("lee", "1234", "아무개", null, null, 2);
		//service.createAdmin(vo2);
	}

}
