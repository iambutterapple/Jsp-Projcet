<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 액션 태그
	- 클라이언트 또는 서버에서 어떤 행동을 하도록 지시하는 태그임
	
	-<jsp:param> : 파라미터 값을 전달할때 사용하는 태그
	형식 : <jsp:param name = "파라미터변수" value="값"/>
	
	-<jsp:forward> : 페이지를 이동할때 사용하는 xorm
	형식
		<jsp:forward page="이동할페이지">
			<jsp:param name ="변수명" value="값"/>
		</jsp:forward>		

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<form action="<%=request.getContextPath() %>/forward/view.jsp">
	이동할 페이지 선택:
	<select name="code">
		<option value="A">A페이지</option>
		<option	value="B">B페이지</option>
		<option	value="C">C페이지</option>
	</select>
	<input type="submit" value="이동">
</form>
</body>
</html>