<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "test" value = "hello" />
	<h3>&lt;c:set&gt; 사용후 : <c:out value = "${test }" /></h3>
	<c:remove var = "test" />
	<h3>&lt;c:remove&gt; 사용후 : <c:out value = "${test }" /></h3>
	
	<c:catch var = "err">
	<%=10/0 %>
	</c:catch>
	<h3>&lt;c:catch&gt; 로 잡아낸 오류 : <c:out value = "${err }" /></h3>
	
	<c:if test = "${5 < 10 }">
		<h3>5는 10보다 작음</h3>
	</c:if>
	<c:if test = "${6 + 3 == 9 }">
		<h3>6 + 3은 9다</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${5 + 10 == 50 }">
			<h3>50이다</h3>
		</c:when>
		
		<c:otherwise>
			<h3>50아니다</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>