<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
	background: orange;
}

.td_right {
	width: 300px;
	background: skyblue;
}

#commandCell {
	text-align: center;
}
</style>
</head>
<body>
<!-- 게시판 등록 -->
<section id = "writeFrom">
	<h2>게시판글등록</h2>
	<form action = "/boardWritePro.do" method = "post" enctype = "multipart/form-data" name = "boardform">
		<table>
			<tr>
				<td class = "td_left"><label for = "board_name">글쓴이</label></td>
				<td class = "td_right">
					<input type = "text" name = "BOARD_NAME" id = "board_name" required="required">
				</td>
			</tr>
			
			<tr>
				<td class = "td_left"><label for = "board_pass">비밀번호</label></td>
				<td class = "td_right">
					<input type = "password" name = "BOARD_PASS" id = "board_pass" required="required">
				</td>
			</tr>
			
			<tr>
				<td class = "td_left"><label for = "board_subject">제목</label></td>
				<td class = "td_right">
					<input type = "text" name = "BOARD_SUBJECT" id = "board_subject" required="required">
				</td>
			</tr>
			
			<tr>
				<td class = "td_left"><label for = "board_content">내용</label></td>
				<td class = "td_right">
					<textarea rows="40" cols="15" id = "board_content" name = "BOARD_CONTENT" required="required"></textarea>
				</td>
			</tr>
			
			<tr>
				<td class = "td_left"><label for = "board_file">파일첨부</label></td>
				<td class = "td_right">
					<input type = "file" name = "BOARD_FILE" id = "board_file">
				</td>
			</tr>
		</table>
		<section id = "commandCell">
			<input type = "submit" value = "등록">&nbsp;&nbsp;
			<input type = "reset" value = "다시쓰기">&nbsp;&nbsp;
			<input type = "button" value = "목록" onclick = "history.back()">
		</section>
	</form>
</section>
</body>
</html>