package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.xml.internal.ws.api.pipe.Engine;

@WebServlet("/calc4")
public class Calc4 extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		Cookie [] cookies = request.getCookies();
		
		String num = request.getParameter("value");
		String op = request.getParameter("operator");
		String dot = request.getParameter("dot");
		String exp = "0";
		
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
			exp += (num == null)? "": num;
			exp += (op == null)? "": op;
			exp += (dot == null)? "": dot;
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		
		response.addCookie(expCookie);
		if(op!=null && op.equals("c")||exp.startsWith("0"))
			expCookie.setMaxAge(0);
//		response.sendRedirect("calculator.jsp");
		request.setAttribute("exp", exp);
		request.getRequestDispatcher("calculator.jsp").forward(request, response);
	};
}
