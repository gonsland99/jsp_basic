<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{width:400px; border:1px solid gray;margin:0 auto; }
	table{margin:0 auto; }
	td{text-align: center; }
</style>
</head>
<body>
	<form action="session2.jsp"  method="post">
		<table>
			<tr><td><label>아이디: </label><input type="text" name="id"></td></tr>
			<tr><td><label>비밀번호: </label><input type="text" name="pass"></td></tr>
			<tr>
				<td>
					<input type="submit" value="로그인">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>