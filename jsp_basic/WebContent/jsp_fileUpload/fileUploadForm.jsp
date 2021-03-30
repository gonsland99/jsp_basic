<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<section id="uploadFormArea" class="w-50 ml-5 mt-5">
	<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
		<div>
			<h2>파일 업로드 폼</h2>
		</div>
		
		<div class="form-group">
			<label for="name">올린사람 : </label>
			<input class="form-control" type="text" name="name" id="name">
		</div>
		
		<div class="form-group">
			<label for="subject">제목 : </label>
			<input class="form-control" type="text" name="subject" id="subject">
		</div>
		
		<div class="form-group">
			<label for="fileName1">파일명1 : </label>
			<input class="form-control-file" type="file" name="fileName1" id="fileName1">
		</div>
		
		<div class="form-group">
			<label for="fileName2">파일명2 : </label>
			<input class="form-control-file" type="file" name="fileName2" id="fileName2">
		</div>
		
		<div class="form-group">
			<input class="btn btn-primary btn-block" type="submit" value="전송">
		</div>
	</form>
</section>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>