<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<fmt:formatNumber type="number" value="12345678" /><br>
	
	<fmt:formatNumber type="currency" value="12345.678" /><br>

	<fmt:formatNumber type="percent" value="0.1234" /><br> 
	<fmt:formatNumber pattern="#,###.0" value="123456.888" /><br>
	
	<c:set var="now" value="<%= new java.util.Date() %>"></c:set>
	<c:out value="${now}"/>
	date : <fmt:formatDate value="${now }" type="date"/>
	time : <fmt:formatDate value="${now }" type="time"/>
	date : <fmt:formatDate value="${now }" type="both"/>
</body>
</html>