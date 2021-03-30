<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>섬네일</h3>
<form action="thumbnail.jsp" method="post" enctype="multipart/form-data">
	이미지파일 : <input type="file" name="filename" /><br /><br />
	<input type="submit" value="전송" />
</form>
</body>
</html>