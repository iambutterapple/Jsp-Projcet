package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
//@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 데이터베이스에서 사용자 정보를 조회함
		 * 폼에서 가져온 아이디와 패스워드가 데이터베이스에 저장된 정보와
		 * 일치하면 로그인성공, 일치하지 않으면 로그인 실패
		 * */
		
		String dbID = "admin";
		String dbPWD = "1234";
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		if(dbID.equals(id) && dbPWD.equals(pwd))
		{
			//데이터베이스에 저장된 아이디와 로그인 폼에 입력한 아이디와 비밀번호가 일치하면 
			HttpSession session = request.getSession();
			//세션에 로그인한 정보를 저장함
			session.setAttribute("user", id);
			
		}
		
		response.sendRedirect("Login");
	
	}
	
}
