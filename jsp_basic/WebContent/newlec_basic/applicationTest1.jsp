<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Application 내장객체</title>
</head>
<body>
<!-- 내장객체 
 application과 session의 차이: 세션은 브라우저 닫을 시, 어플리케이션은 서버 종료 시 데이터 초기화
 page와 request차이: 페이지는 같은페이지 내에서만, 요청은 같은 영역 안에서 포워딩 가능 
 -->
 <!--내장 액션테그
 forward, elemnet, body...
 include지시어와 액션태그 차이: 지시어는 정적(페이지 내 제어권을 가짐), 액션태그는 동적으로 사용(임시 제어권)
  -->
	<h1>application 테스트</h1>
	<table border="1">
		<tr>
			<td>jsp버전</td>
			<td><%=application.getMajorVersion() %>.<%=application.getMinorVersion() %></td>
		</tr>
		<tr>
			<td>컨테이너 정보</td>
			<td><%=application.getServerInfo() %></td>
		</tr>
		<tr>
			<td>was경로</td>
			<td><%=application.getRealPath("/") %></td>
		</tr>
	</table>
</body>
</html>