package com.sample;


/*
 * ServletConfig와 ServletContext 객체의 파라미터 값을 web.xml에 저장해 놓는다.
 * 
 * 
 * ServletConfig API를 활용한 초기화 파라미터
 * 	- ServletConfig 객체는 Container(tomcat)가 서블릿 생성할때 생성되는 객체
 *  - DD(web.xml)를 읽어서 이름/값의 쌍으로 된 초기화 파라미터를 읽어서 저장한다.
 *  - servlet에서는 getServletConfig()를 이용해서 servlet과 관련되
 *  	ServletConfig 객체를 획득할 수 있음
 *  - ServletConfig 객체는 Servlet 객체당 한개씩 생성됨
 * 
 * ServletContext Api를 활용한 초기화 파라미터
 *  - ServletContext 객체는 web application 당 하나씩 생성함
 *  - web application 전체에서 참조할 수 있는 초기화 파라미터를 저장함
 *  - servlet에서는 getServletContext()를 이용해서 ServletContext 객체 획득할 수 있음
 *  
 * */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InitParam",urlPatterns = {"/InitParam"}
		,initParams = {@WebInitParam(name = "tel",value = "010-1234-1234")
		,@WebInitParam(name = "email",value = "aaa@naver.com")}
		
		
		)
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private String company;
     private String manager;
     private String tel;
     private String email;
     String com;
     String man;
     @Override
     public void init()throws ServletException{
    	 System.out.println("초기화 메소드 수행");
    	 //serlvetcontext의 초기화 파라미터 값 얻어오기
    	 //company = getServletContext().getInitParameter("company");
    	 //manager = getServletContext().getInitParameter("manager");
    	 //servletconfig의 초기화 파라미터 값 얻어오기
    	 company = "globalin";
    	 manager = "JungSubkim";
    	 getServletContext().setAttribute("company", company);
    	 getServletContext().setAttribute("manager", manager);
    	 
    	 com = 	(String)getServletContext().getAttribute("company");
    	 man = 	(String)getServletContext().getAttribute("manager");
    	 
    	 tel = getServletConfig().getInitParameter("tel");
    	 email = getServletConfig().getInitParameter("email");
     
    	 
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
			
			out.print("회사명 : " + com+"<br>");
			out.print("관리자 : " + man+"<br>");
			out.print("전화번호 : " + tel+"<br>");
			out.print("이 메 일 : " + email+"<br>");
			
			out.print("</body></html>");
			
		
	 }
 
}
