<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>


<jsp:useBean id="dao" class="com.memberone.StudentDAO"></jsp:useBean>
<jsp:useBean id="vo" class="com.memberone.StudnetVO"></jsp:useBean>

<jsp:setProperty property="*" name="vo"/>


<%
	//memberInsert()메소드에서 true가 반환되어 flag에 저장된다.
	boolean flag = dao.memeberInsert(vo);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
	<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body bgcolor="#ffffcc">
	<div align="center">
		<%
		
			if(flag) //flag가 true 일때 회원가입 성공
			{
				out.println("<br>회원가입을 축하드립니다.");
				out.println("<a href='login.jsp'>로그인</a>");
			}else{
				out.println("<b>회원가입에 실패. 다시 입력.");
				out.println("<a href='regForm.jsp'>다시 가입</a>");
			}
		
		%>
	</div>
</body>
</html>