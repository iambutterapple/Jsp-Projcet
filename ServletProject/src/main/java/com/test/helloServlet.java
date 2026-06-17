package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
//@WebServlet(name = "Hello",urlPatterns = {"/Hello","/aaa"})
public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		//서블릿이 생성될때 호출되는 메소드..
		System.out.println("init... 요청");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청이 있을때마다 호출되는 메소드
		System.out.println("HelloServlet 요청 작업 완료");
	}
	
	@Override
	//서버가 중지될때 호출되는 메소드
	public void destroy() {
		System.out.println("destory 요청...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
