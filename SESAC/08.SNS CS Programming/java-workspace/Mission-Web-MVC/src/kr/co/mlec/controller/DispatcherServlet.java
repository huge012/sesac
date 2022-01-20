package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapping mappings = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// ServletConfig : 서블릿 환경설정을 받아옴
		String propLoc = config.getInitParameter("propLocation");
		mappings = new HandlerMapping(propLoc);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); // 내가 설정한 path (server-modules에서 설정 가능, 실 서비스 할 땐 '/' 로 수정)
		uri = uri.substring(contextPath.length());
		
		//System.out.println("요청 URI : "+uri);
		//System.out.println(contextPath);
		
		try {
			String callPage = "";
			Controller control = mappings.getController(uri);

			//if (control != null) {
				callPage = control.handleRequest(request, response);
				
				// callPage 주소에 따라 forward 혹은 sendRedirect 해야함
				if(callPage.startsWith("redirect:")) {
					callPage = callPage.substring("redirect:".length());
					response.sendRedirect(request.getContextPath()+callPage); // 리다이렉트 - 서블릿에서 바로 응답
				}
				else {
					// <jsp:forward> : jsp action태그
					// RequestDispatcher : java에서 forward 명령어 사용할 객체, request에 있음
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);

					// 받았던 모든 request 객체와 넘겨주기 위한 response 객체를 보내줌
					dispatcher.forward(request, response);
				}
			//}
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
