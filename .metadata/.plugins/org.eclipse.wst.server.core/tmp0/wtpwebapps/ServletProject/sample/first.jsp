<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP File</title>
</head>
		<h2>JSP  Script</h2>
		<%
			//스크립트연산 처리 
			String scriptlet = "스크립트 이력";
			String comment = "주석문 입니다.";
			
			//출력문 
			out.print("내장 객체를 이용한 출력 : " + declation + "<br>");
		%>

		선언문 출력하기 (변수) : <%= declation  %> <br>
		선언문 출력하기 (메소드) : <%= declationMethod() %><br>
		스크립트릿 출력하기 <%=scriptlet %><br>


		<%!
			//변수 선언
			String declation = "선언문 입니다.";
		
			public String declationMethod(){
				return declation;
			}
		%>

</body>
</html>