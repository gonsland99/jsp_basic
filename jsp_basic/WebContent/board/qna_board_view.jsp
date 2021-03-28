<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#articleForm {
	width: 500px;
	height: 500px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	height: 40px;
	text-align: center;
}

#articleContentArea {
	background: orange;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>
<body>
<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<article id="basicInfoArea">
			제 목 :
			<%=article.getBOARD_SUBJECT()%>
			<br />
			첨부파일 :
			<%if(!(article.getBOARD_FILE()==null)){ %>
			<a href="file_down1.jsp?downFile=<%=article.getBOARD_FILE()%>"> <%=article.getBOARD_FILE() %>
			</a>
<%-- 			<a download href="boardUpload/<%=article.getBOARD_FILE()%>"> <%=article.getBOARD_FILE() %> --%>
<!-- 			</a> -->
			<%} %>
		</article>
		<article id="articleContentArea">
			<%=article.getBOARD_CONTENT() %>
		</article>
	</section>
	<section id="commandList">
		<a
			href="/boardReplyForm.do?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">
			[답변] </a> <a
			href="/boardModifyForm.do?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">
			[수정] </a> <a
			href="/boardDeleteForm.do?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">
			[삭제] </a> <a href="/boardList.do?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>