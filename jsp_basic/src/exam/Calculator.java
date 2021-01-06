package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		String exp = "0";
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>계산기</title>");
		out.write("<style>");
		out.write("*{");
		out.write("	margin: 0; padding: 0;");
		out.write("}");
		out.write("table{");
		out.write("	border: 5px solid #999;");
		out.write("	padding: 10px;");
		out.write("	background: #eee;");
		out.write("}");
		out.write(".output{");
		out.write("	background: #ccc;");
		out.write("	font-size: 30px;");
		out.write("		font-weight: bold;");
		out.write("	text-align: right;");
		out.write("	padding: 10px;");
		out.write("}");
		out.write("input{");
		out.write("		width: 50px;");
		out.write("		height: 50px;");
		out.write("		margin: 2px;");
		out.write("	border: 1px solid #aaa;");
		out.write("	background: #ddd;");
		out.write("	border-radius: 5px;");
		out.write("	font-size: 18px;");
		out.write("}");
		out.write(".zero input{");
		out.write("	width: 110px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form method=\"post\">");
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td class=\"output\" colspan=\"4\">%.12s</td>",exp);	//12자리까지 값만 받음
		out.write("		</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"ce\"/></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"c\"/></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"bs\"/></td>");
		out.write("			<td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
		out.write("		</tr>");
		out.write("		<tr>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
		out.write("			<td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("					<td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
		out.write("				<td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td class=\"zero\" colspan=\"2\"><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
		out.write("				<td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
		out.write("				<td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("		</form>");
		out.write("</body>");
		out.write("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies = request.getCookies();
		
		String num = request.getParameter("value");
		String op = request.getParameter("operator");
		String dot = request.getParameter("dot");
		String exp = "";
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		if(op != null && op.equals("=")) {
			ScriptEngine en = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(en.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(op!=null && op.equals("c")){
			exp = "";
		}else {
			exp += (num == null)?"": num;
			exp += (op == null)?"": op;
			exp += (dot == null)?"": dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		if(op!=null && op.equals("c")||exp.startsWith("0"))	//0으로 시작하는 값은 쿠키초기화
			expCookie.setMaxAge(0);
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		response.sendRedirect("calculator");
	}

}
