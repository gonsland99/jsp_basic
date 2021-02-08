package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
/* ���� ���� ���
	application: was���� ���ۺ��� ������� �������� ����ϴ� �������, getServletContext()�� �������� ��� ���ʴ�� �ҷ���
	session: ���� ���ۺ��� ������� ���ǰ������� ����ϴ� �������, ����id�� �ο� ����id �������� �����͵���(ũ��â 2���� ����������, ũ��/���̾������� �ٸ�������)
	cookie: Ŭ���̾�Ʈ���� ���� ����(addCookie) Ŭ���̾�Ʈ���� ���� ������(getCookies), path/����ð� ����
	hidden input
	querystring
*/		
		
		//ServletContext application = request.getServletContext();	//application
		//HttpSession session = request.getSession();	//session
		Cookie [] cookies = request.getCookies();	
		
		String num_ = request.getParameter("num");	
		String op_ = request.getParameter("operator");
		int num = 0;
		if(!num_.equals("")) num = Integer.parseInt(num_);
	//�����
		if(op_.equals("=")) {
			//int x = (int)application.getAttribute("value");	//getAttribute: Object���� �޾ƿ�, setAttribute�� ��þ��ϸ� null�� ����
			//int x = (int)session.getAttribute("value");	
		//��Ű �� value�� �ҷ����� 
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y = num;
		//��Ű �� operation�� �ҷ����� 
			//String op = (String)application.getAttribute("oper");
			//String op = (String)session.getAttribute("oper");
			String op = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("oper")) {
					op = c.getValue();
					break;
				}
			}
		//����	
			int result = 0;
			if(op.contentEquals("+"))
				result = x + y;
			else
				result = x - y;
			response.getWriter().printf("result : %d\n",result);
	//�Է°�
		} else {
			//application.setAttribute("value",num);
			//application.setAttribute("oper",op_);
			//session.setAttribute("value",num);
			//session.setAttribute("oper",op_);
			Cookie vCookie = new Cookie("value",String.valueOf(num)); //cookie ����(String���·θ� ���� ����)
			Cookie oCookie = new Cookie("oper",op_);
			vCookie.setPath("/calc2");	//cookie�� ����Ǵ� url ����
			vCookie.setMaxAge(24*60*60);	//cookie�� ����Ǵ� ��¥
			oCookie.setPath("/calc2");
		//Ŭ���̾�Ʈ���� ��Ű����
			response.addCookie(vCookie);	
			response.addCookie(oCookie);
			
			response.sendRedirect("calc2.html");
		}
			
		
		
	}

}
