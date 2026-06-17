<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.jdbc.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffcc">
<h2>Beans를 사용한 데이터베이스 연동</h2>
	<table bordercolor="#0000ff" border="1">
	<tr>
		<td><strong>ID</strong></td>
		<td><strong>PW</strong></td>
		<td><strong>NAME</strong></td>
		<td><strong>MENU_NUM1</strong></td>
		<td><strong>MENU_NUM2</strong></td>
		<td><strong>E_MAIL</strong></td>
		<td><strong>PHONE</strong></td>
		<td><strong>ZIPCODE/ADDRESS</strong></td>
		<td><strong>JOB</strong></td>
	</tr>
	<jsp:useBean id="dao" class="com.jdbc.TempMemberDAO" scope="page"></jsp:useBean>
	<%
		Vector<TempMemberVO> vecList = dao.getMemberList();
		int counter = vecList.size();
		
		for(int i=0;i<counter;i++){
			TempMemberVO vo = vecList.elementAt(i);
		
	
	%>
	<tr>
		<td><%=vo.getId()%></td>
		<td><%=vo.getPassword()%></td>
		<td><%=vo.getName()%></td>
		<td><%=vo.getMemb_num1()%></td>
		<td><%=vo.getMeme_num2()%></td>
		<td><%=vo.getE_email()%></td>
		<td><%=vo.getPhone()%></td>
		<td><%=vo.getAddress()%>/<%=vo.getZipcode() %></td>
		<td><%=vo.getJob()%></td>
	
	<%} %>
	</tr>
	</table>
	total:record:<%=counter %>
</body>
</html>