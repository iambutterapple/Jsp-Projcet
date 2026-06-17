<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	int bufferSize = out.getBufferSize();
    	int remainSize = out.getRemaining();
    	int useredSize = bufferSize - remainSize;
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
		1. 자원
		2. 유지보수성
		3. 운영
		
		버퍼 전체 크기 : <%= bufferSize %> <br>
		사용한 버퍼 크기 : <%= useredSize %> <br>
		남은 버퍼 크기 : <%out.print(remainSize); %> <br>
</body>
</html>