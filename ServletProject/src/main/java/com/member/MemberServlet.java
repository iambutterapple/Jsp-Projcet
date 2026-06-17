package com.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글 처리
		request.setCharacterEncoding("utf-8");
		//응답시 한글 처리
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		
		Enumeration<String> enu = request.getParameterNames();
		
		//변수 여부 파악
		while(enu.hasMoreElements())
		{
			//다음 요소 있는지 파악
			String name = enu.nextElement();
			String value = request.getParameter(name);
			out.print(name + ":" + value + "<br>");
			
		}
		
		out.print("</body></html>");
		
	}

}
