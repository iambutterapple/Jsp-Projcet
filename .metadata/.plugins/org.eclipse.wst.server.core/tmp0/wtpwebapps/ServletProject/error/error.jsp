<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<%	response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
	요청하신 처리과정에서 에외가 발생하였습니다.<br>
	빠른시간내에 문제를 해결하도록 하겠습니다.<br>
	에러타입 : <%= exception.getClass().getName()%><br>
	에러메시지 : <b><%=exception.getMessage()%></b>
</body>
</html>