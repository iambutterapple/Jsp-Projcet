<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="Member" class="com.actiontag.member" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="Member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
	<ul>
		<li>이름 : <jsp:getProperty property="name" name="Member"/>  </li>	
	</ul>
	<ul>
		<li>메일 : <jsp:getProperty property="email" name="Member"/>  </li>	
	</ul>
	<ul>
		<li>번호 : <jsp:getProperty property="phone" name="Member"/>  </li>	
	</ul>

</body>
</html>