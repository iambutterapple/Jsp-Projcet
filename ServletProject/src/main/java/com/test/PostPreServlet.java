package com.test;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/PostPre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println("init ... ");
	}

	public void destroy() {
		System.out.println("destory ... ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ... ");
	}
	//선처리 작업 : init() 메소드가 호출되기 전에 먼저 처리하는 작업 설명
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod....");
	}
	//후작업 지정 : destroy() 메소드가 호출된 다음에는 호출되는 메소드
	@PreDestroy
	public void clean(){
		System.out.println("clean...");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ... ");
	}
}
