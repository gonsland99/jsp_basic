<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="beantest" class="jsp_bean.beanTest" scope="page"/> 
<!-- scope
	page: 현재페이지 내에서만 적용
	request: 요청처리 완료시까지 적용
	session: 브라우저 종료전까지 적용
	application: 서버 죵료전까지 적용
 -->
<jsp:setProperty name="beantest" property="name" value="Hello java"/> 
<!-- private변수는 유지되지만 setName메소드를 통해 값이 setProperty값으로 변경된다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=beantest.getName() %></h3>
	<jsp:getProperty name="beantest" property="name"/> 
</body>
</html>