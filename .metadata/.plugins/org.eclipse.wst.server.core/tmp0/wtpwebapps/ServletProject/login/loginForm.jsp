<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
	<h1>파라미터 전달 방식</h1>
	<form action="login" method="post">
		<fieldset>
			<legend>로그인</legend>
			<ul>
				<li>
					<label>아이디</label>
					<input	type="text" name="userid">
				</li>
				<li>
					<label>비밀번호</label>
					<input type="password" name="password">
				</li>
				<li>
					<input type="submit" value="로그인">
				</li>
			</ul>
		</fieldset>
	</form>
</body>
</html>