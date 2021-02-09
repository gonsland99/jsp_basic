<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculator</title>
<style>
*{margin: 0; padding: 0;}
table{
	border: 5px solid #999;
	padding: 10px;
	background: #eee;
}
.output{
	background: #ccc;
	font-size: 30px;
	font-weight: bold;
	text-align: right;
	padding: 10px;
}
input{
	width: 50px;
	height: 50px;
	margin: 3px;
	border: 1px solid #aaa;
	background: #ddd;
	border-radius: 5px;
	font-size: 18px;
}
.zero input{width: 110px;}
</style>
</head>
<body>
	<form action="calc4" method="post">
		<table>
			<tr>
				<td class="output" colspan="4"><%=request.getAttribute("exp")%></td>
			</tr>
			<tr>
				<td><input type="submit" name="operator" value="ce"/></td>
				<td><input type="submit" name="operator" value="c"/></td>
				<td><input type="submit" name="operator" value="bs"/></td>
				<td><input type="submit" name="operator" value="+"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="7"/></td>
				<td><input type="submit" name="value" value="8"/></td>
				<td><input type="submit" name="value" value="9"/></td>
				<td><input type="submit" name="operator" value="*"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="4"/></td>
				<td><input type="submit" name="value" value="5"/></td>
				<td><input type="submit" name="value" value="6"/></td>
				<td><input type="submit" name="operator" value="-"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="1"/></td>
				<td><input type="submit" name="value" value="2"/></td>
				<td><input type="submit" name="value" value="3"/></td>
				<td><input type="submit" name="operator" value="/"/></td>
			</tr>
			<tr>
				<td class="zero" colspan="2"><input type="submit" name="value" value="0"/></td>
				<td><input type="submit" name="dot" value="."/></td>
				<td><input type="submit" name="operator" value="="/></td>
			</tr>
		</table>
	</form>
</body>
</html>