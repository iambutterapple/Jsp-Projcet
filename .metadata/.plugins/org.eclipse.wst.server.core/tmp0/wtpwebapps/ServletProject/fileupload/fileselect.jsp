<%@page import="org.apache.tomcat.util.http.fileupload.impl.FileCountLimitExceededException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public String getParam(HttpServletRequest request, String paramName){
		if(request.getParameter(paramName) != null){
			return request.getParameter(paramName);
		} else {
			return "";
		}
	}
%>
<%
	request.setCharacterEncoding("utf-8");

	int filecounter = 0;
	if(request.getParameter("addcnt") != null && !request.getParameter("addcnt").equals("")){
		try {
			filecounter = Integer.parseInt(request.getParameter("addcnt"));
		} catch(NumberFormatException e) {
			filecounter = 0;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
	<link href="style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		// 파일 개수 입력 후 확인 버튼 눌렀을 때
		function addFile(formName){
			if(formName.addcnt.value.trim() == ""){
				alert("입력할 파일 개수를 입력하고 확인 버튼을 눌러주세요.");
				formName.addcnt.focus();
				return;
			}
			formName.submit();
		}
		
		// DONE 버튼 눌렀을 때 검증 및 전송
		function elementCheck(form2){
			// 1. 첫 번째 폼(fileName1)의 입력값들을 두 번째 폼(frmName2)의 hidden 필드에 복사
			var form1 = document.fileName1;
			form2.txtUser.value = form1.user.value;
			form2.txtTitle.value = form1.title.value;
			form2.txtAbstract.value = form1.abstract.value;

			// 2. 파일 첨부 여부 체크
			var paramIndex = 1;
			for(var idx = 0; idx < form2.elements.length; idx++){
				if(form2.elements[idx].type == "file"){
					if(form2.elements[idx].value == ""){
						var message = paramIndex + "번째 파일 정보가 누락되었습니다. 업로드할 파일을 선택해주세요.";
						alert(message);
						form2.elements[idx].focus();
						return;
					}
					paramIndex++;
				}
			}
			
			// 3. 전송
			form2.action = "fileView.jsp";
			form2.submit();
		}
	</script>
</head>
<body topmargin="100">
	<div align="center">
		<font color="#0000ff" size="2">
			여러개의 파일의 업로드 하려면 파일 개수를 입력한 후<br>
			확인 버튼을 눌러 주세요.<br>
			입력이 완료되면 DONE버튼을 눌러주세요.
		</font>
	</div><br>
	
	<form action="" method="post" name="fileName1">
		<table width="75%" border="1" align="center" cellpadding="1" cellspacing="2" bordercolor="#660000" bgcolor="#ffff99">
			<tr bgcolor="#ffcc00">
				<td width="10%"><div align="right">user</div></td>
				<td>
					<input type="text" name="user" value="<%=getParam(request,"user")%>">
				</td>
				<td width="10%"><div align="right">title</div></td>
				<td>
					<input type="text" name="title" value="<%=getParam(request,"title")%>">
				</td>
			</tr>
			<tr bgcolor="#ffcc00">
				<td width="15%"><div align="right">abstract</div></td>
				<td width="50%" colspan="3">
					<%-- textarea는 value 속성이 아니라 태그 사이에 값을 넣어야 합니다 --%>
					<textarea rows="3" cols="40" name="abstract"><%=getParam(request,"abstract")%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div align="center">
						<font size="-2"> 추가할 파일 수 입력</font>
						<input type="text" name="addcnt" value="<%=filecounter > 0 ? filecounter : ""%>">
						<input type="button" value="확인" onclick="addFile(this.form)">
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<br>

	<form action="" name="frmName2" method="post" enctype="multipart/form-data">
		<input type="hidden" name="txtUser" value="<%=getParam(request,"user")%>">
		<input type="hidden" name="txtTitle" value="<%=getParam(request,"title")%>">
		<input type="hidden" name="txtAbstract" value="<%=getParam(request,"abstract")%>">

		<table width="75%" border="1" align="center" cellpadding="1" cellspacing="2" bordercolor="#660000" bgcolor="#ffff99">
			<tr bgcolor="#ffcc00">
				<td width="80%">
					<% if(filecounter == 0) { %>
						<div align="center" style="font-size: 12px; color: gray;">위에서 파일 개수를 입력하고 확인을 누르면 여기에 파일 선택창이 나타납니다.</div>
					<% } %>
					<% for(int i=0; i<filecounter; i++){ %>
						<input type="file" size="50" name="selectFile<%=i%>" style="margin: 4px 0;"><br>
					<% } %>
				</td>
				<td width="20%" align="center">
					<input type="button" value="DONE" onclick="elementCheck(this.form)" style="padding: 10px 20px;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>