package kr.co.mlec.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/examMethod")
@WebServlet(urlPatterns= {"/examMethod"})
public class ExamMethodServlet extends HttpServlet {

	
	// http://localhost:9999/Lecture-Web/examMethod?name=hong&hobby=reading&hobby=movie
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/examMethod service()...");
		
		String name = request.getParameter("name");
		String hobby = request.getParameter("hobby"); // 중복 키 여러 values 있을 때 getParameter 사용 시 맨 앞에 하나만 가져옴
		String[] hobbies = request.getParameterValues("hobby"); // 중복 키 여러 values 있을 땐 getParameterValues
		
		System.out.println("name : " + name);
		System.out.println("hobby : " + hobby);
		System.out.println("hobbies : " + Arrays.deepToString(hobbies));
		
	}
	
}
