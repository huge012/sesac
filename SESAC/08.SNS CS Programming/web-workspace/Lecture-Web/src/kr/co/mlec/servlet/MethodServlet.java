package kr.co.mlec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	// http://localhost:9999/Lecture-Web/method?id=aaa
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getMethod(); // Get방식인지 Post방식인지
		String uri = request.getRequestURI(); // /Lecture-Web/method?
		String id = request.getParameter("id"); // id 키로 들어온 값 "aaa"
		
		/* 이클립스 콘솔에 출력
		System.out.println("요청 메소드 : "+method);
		System.out.println("요청 URI : "+uri);
		System.out.println("id : "+id);
		*/
		
		/* html 코드 클라이언트에게 출력해주기 : I/O , OutputStream 혹은 Writer 객체 필요*/
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>"); // 클라이언트에게 전달
		out.println("<HEAD>");
		out.println("<TITLE>메소드 호출 결과</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("============================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;출 력 결 과 <br>");
		out.println("============================<br>");
		out.println("요청 메소드 : "+method+"<br>");
		out.println("요청 URI : "+uri+"<br>");
		out.println("파라미터(id) : "+id+"<br>");
		out.println("============================<br>");
		out.println("</BODY>");		
		out.println("</HTML>");
		
		out.flush();
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // post방식은 인코딩 필수
		
		String method = request.getMethod(); // Get방식인지 Post방식인지
		String uri = request.getRequestURI(); // /Lecture-Web/method?
		String id = request.getParameter("id"); // id 키로 들어온 값 "aaa"
		
		/*이클립스 콘솔에 출력*/
		System.out.println("요청 메소드 : "+method);
		System.out.println("요청 URI : "+uri);
		System.out.println("id : "+id);
		
		
		
	}
	
}
