package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Destination")
public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답코드 작성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			out.print("<html>");
			out.print("<head>");
				out.print("<title>응답페이지</title>");
			out.print("</head>");
					out.print("<body>");
						out.print("<h1>응답페이지 환영</h1>");
					out.print("</body>");
			out.print("</html>");
	
		} finally {
			out.close();
		}
		
	}
	
}
