package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextSetServlet
 */
//@WebServlet("/ContextSet")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//속성 값 지정
		String company = "globalin";
		String manager = "Jungsub Kim";
		
		getServletContext().setAttribute("company", company);
		getServletContext().setAttribute("manager", manager);
		
		String com = (String)getServletContext().getAttribute("company");
		String man = (String)getServletContext().getAttribute("manager");
		
		//요청시 한글 처리
		request.setCharacterEncoding("utf-8");
		//응답시 한글 처리
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		
		out.print(com + ":" + man + "<br>");
		System.out.println("s"+3+4);	
		System.out.println("s"+(3+4));	
		
		
		out.print("</body></html>");
		
		
	}

}
