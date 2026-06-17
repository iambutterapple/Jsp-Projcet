package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] sports = request.getParameterValues("sports");
		String gender = request.getParameter("gender");
		System.out.println(gender);
			
		//한글처리
		response.setContentType("text/html;charset=UTF-8");
		//문자데이터를 출력하기위한 스트림 객체 생성
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		for(String Sport : sports)
		{
			out.print("취    미 : " + Sport + "<br>");
		}
		out.print("성    별 : " + gender + "<br>");
		out.println("</body>");
		out.println("</html>");
	}
}
