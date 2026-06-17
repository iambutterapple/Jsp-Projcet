<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBoard</title>
	<link href="style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="script.js"></script>
</head>
<!--
	작성한 글이 새글인지 아니면 답변글인지를 구분해야한다.
  -->
<%
	//답변글일때
	int num=0,ref=1,step=0,depth=0;
	try{
		//새글일경우 num = 0을 넘겨주고
		if(request.getParameter("num") != null)
		{
			//담변글일 경우는 원본글의 번호를 받아 와야함
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			step = Integer.parseInt(request.getParameter("step"));
			depth = Integer.parseInt(request.getParameter("depth"));
		}
	
	
%>
<body bgcolor="<%=bodyback_c%>">
	<div align="center">
		<b>글쓰기</b>
	</div>
	<form action="writeProc.jsp" method="post" name="writeForm" onsubmit="return writerSave()">
		<!--writeProc.jsp"로 페이지를 이동할때 num,ref,step,depth의 값을 가지고 페이지 이동을 해야하므로
			hidden 속성을 이용하여 넘겨준다. -->
		<input type ="hidden" name ="number" value="<%=num %>">
		<input type ="hidden" name ="ref" value="<%=ref %>">
		<input type ="hidden" name ="step" value="<%=step %>">
		<input type ="hidden" name ="depth" value="<%=depth %>">
		
		<table width="400" border="1" cellpadding="0" cellspacing="0" align="center"
		bgcolor="<%=bodyback_c%>">
			<tr>
				<td align="center" colspan="2" bgcolor="<%=value_c%>">
					<a href="list.jsp">글목록</a>
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">이름</td>
				<td width="330">
					<input type="text" size="12" maxlength="12" name = "writer">
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">이메일</td>
				<td width="330">
					<input type="text" size="30" maxlength="30" name = "email">
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">제목</td>
				<td width="330">
					<%if(request.getParameter("num")== null){//새글인 경우 %>
						<input type="text" size="50" maxlength="50" name = "subject">
					<% }else{ // 답변글일때%>
						<input type="text" size="50" maxlength="50" name = "subject" value="[답변]">
					<% } %>
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">내용</td>
				<td width="330">
					<textarea rows="13" cols="50" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
				<td width="330">
					<input type="password" size="10" maxlength="10" name="pass">
				</td>
			</tr>
			<tr>
				<td colspan="2"  bgcolor="<%=value_c %>" align="center">
				
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="글목록" onclick="window.location='list.jsp'">
				</td>
			</tr>	
		
		</table>
	</form>
	<%
		}catch(Exception e){
			e.printStackTrace();
		}
	
	%>
</body>
</html>