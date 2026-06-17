<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String code = request.getParameter("code");  
	String viewPageURI = null;
	
	if(code.equals("A"))
	{
		viewPageURI = "viewModel/a.jsp";
	}else if(code.equals("B"))
	{
		viewPageURI = "viewModel/b.jsp";
	}else if(code.equals("C"))
	{
		viewPageURI = "viewModel/c.jsp";
	}
%>
	<jsp:forward page="<%= viewPageURI %>"></jsp:forward>
