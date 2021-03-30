<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>다중파일업로드테스트</h1>
<form action="partUploadPro2" method="post" enctype="multipart/form-data">
	<div>
		<label for="writer">작성자 : </label>
		<input type="text" name="writer" id="writer">
	</div>
	
	<div>
		<label for="partFile1">업로드 파일1 : </label>
		<input type="file" name="partFile1" id="partFile1">
		<label for="partFile2">업로드 파일2 : </label>
		<input type="file" name="partFile2" id="partFile2">
	</div>
	
	<div>
		<input type="submit" value="다중 업로드">
	</div>
</form>
</body>
</html>