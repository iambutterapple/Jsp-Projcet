<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%
	//쿠키생성
	Cookie cookie = new Cookie("hour","1time");
	//쿠키 유효시간
	cookie.setMaxAge(60);
	response.addCookie(cookie);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
유효시간이 10초안 hour 쿠키 생성
</body>
</html>