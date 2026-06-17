package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		//utf-8 encoding 형식 변경을 통해 한글 출력 가능
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		
		
		out.print("<html>");
		out.print("<head><title> MyHomePage	</title></head>");
		out.print("<body>");
		out.print("배고프다.I am hungry.◆");
		out.print("</body>");
		out.print("</html>");
		
	}
}
