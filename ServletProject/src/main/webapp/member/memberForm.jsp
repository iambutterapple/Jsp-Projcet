<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
	<form action="Member" method="post">
		<fieldset>회원관리</fieldset>
		<ul>
			<li>
				<label>이름</label>
				<input type="text" name="username">
			</li>
			<li>
				<label>주소</label>
				<input type="text" name="address">
			</li>
			<li>
				<label>아이디</label>
				<input type="text" name="userid">
			</li>
			<li>
				<label>패스워드</label>
				<input type="password" name="password">
			</li>
			<li>
				<label>이메일</label>
				<input type="email" name="email">
			</li>
			<li>
				<input type="submit" value="회원가입">
			</li>
		</ul>
	</form>
</body>
</html>