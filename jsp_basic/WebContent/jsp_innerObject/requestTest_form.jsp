<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 request</title>
</head>
<body>
	<form action="requestTest.jsp" method="post">
		<table>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td><label for="name">성별</label></td>
				<td>
					남<input type="radio" name="gender" value="male" checked="checked"/>
					여<input type="radio" name="gender" value="female"/>
				</td>
			</tr>
			<tr>
				<td><label for="name">취미</label></td>
				<td>
					독서<input type="checkbox" name="hobby" value="독서"/>
					축구<input type="checkbox" name="hobby" value="축구"/>
					게임<input type="checkbox" name="hobby" value="게임"/>
					여행<input type="checkbox" name="hobby" value="여행"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="command"><input type="submit" name="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>