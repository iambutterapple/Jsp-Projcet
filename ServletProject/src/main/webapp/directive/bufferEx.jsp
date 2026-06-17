<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="flash" %>
<!--	autoFlush = "true" : 버퍼가 다 찼을 경우 비울것인가 아닌가를 지정함  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
	<% for(int i=0;i<1000;i++){ %>
	1234
	<%} %>
</body>
</html>