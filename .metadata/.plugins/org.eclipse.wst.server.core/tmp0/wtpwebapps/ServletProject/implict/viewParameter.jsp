<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>

</body>
		<b>rquest.getParameter() 메소드 사용 </b><br>
		namer 파라미터		: <%=request.getParameter("name") %>
		address 파라미터	: <%=request.getParameter("address") %>
		
		<%
			String values[] = request.getParameterValues("pet");
			if(values != null)
			{
				for(int i=0;i<values.length;i++)
				{
					
		%>
				<%= values[i] %>	
		<% 			
				}
			}
		%>	
		
		<br><b>rquest.getParameterNames() 메소드 사용 </b><br>
		<%
			Enumeration enumData = request.getParameterNames();
			while(enumData.hasMoreElements()){
				String name = (String)enumData.nextElement();
		%>
			<%= name %>
		<% 
			}
		%>
		
		<br><b>rquest.getParameterNames() 메소드 사용 </b><br>
		<%
			Map parameterMap = request.getParameterMap();
			String nameParam[] = (String[])parameterMap.get("name");
			if(nameParam !=null)
			{
		%>
		name = <%= nameParam[0] %>
		<%} %>
		
</html>