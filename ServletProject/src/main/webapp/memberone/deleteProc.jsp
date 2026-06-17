<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.memberone.*"%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<%
	String id = (String)session.getAttribute("loginID");
	String pass = request.getParameter("pass");

	int check = dao.deleteMember(id, pass);
	
	if(check == 1){
		session.invalidate();
%>
</head>
<meta http-equiv="refresh" content="2;url=login.jsp">
<body>
	<div align="center">
		<font size="4">
		회원정보가 삭제처리가 되었습니다. <br>
		-끝- <br>
		<!-- <a href="login.jsp">로그인</a> -->
	</font>
	</div>
	<%} else {%>
	<script type="text/javascript">
		alert("비밀번호 일치하지 않습니다.");
		history.go(-1);
	</script>
	<%} %>
</body>
</html>