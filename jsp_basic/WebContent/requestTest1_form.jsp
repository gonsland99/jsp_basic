<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request예제1</h1>
	<form action="requestTest1.jsp" method="post">
		<table>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><label for="gender">성별</label></td>
				<td>
					남<input type="radio" name="gender" value="male" id="gender">
					여<input type="radio" name="gender" value="female" id="gender">
				
				</td>
			</tr>
			<tr>
				<td><label for="hobby">취미</label></td>
				<td>
					독서<input type="checkbox" name="hobby" value="독서" id="hobby">
					게임<input type="checkbox" name="hobby" value="게임" id="hobby">
					영화<input type="checkbox" name="hobby" value="영화" id="hobby">
					축구<input type="checkbox" name="hobby" value="축구" id="hobby">
					기타<input type="checkbox" name="hobby" value="기타" id="hobby">
				</td>
			</tr>
			<tr>
				<td colspan="1" id="commandCell"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>