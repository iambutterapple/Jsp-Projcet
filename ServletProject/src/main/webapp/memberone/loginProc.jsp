<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO"></jsp:useBean>
<%
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	int check = dao.loginCheck(id, pass);
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%
	if(check == 1){//로그인 성공
		session.setAttribute("loginID", id);
		response.sendRedirect("login.jsp");
	}else if(check == 0){//아이디는 존재하는데 비밀번호가 틀렸단
		
%>
<script type="text/javascript">
	alert("비밀번호 틀렸습니다.");
	history.go(-1);
</script>
	<%	} else { //-1일때 %>
<script type="text/javascript">
	alert("아이디가 존재하지 않습니다.");
</script>
	<%	} %>
</body>
</html>