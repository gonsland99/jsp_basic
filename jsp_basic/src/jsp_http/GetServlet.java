package jsp_http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp_http/get")
public class GetServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String i = req.getParameter("id");
		String p = req.getParameter("pass");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("??????: "+i);
		out.println("ë¹?ë²?: "+p);
	}
}
