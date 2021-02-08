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
/* 상태 유지 방법
	application: was서버 시작부터 종료까지 전역에서 사용하는 저장공간, getServletContext()에 여러값을 담아 차례대로 불러옴
	session: 세션 시작부터 종료까지 세션공간에서 사용하는 저장공간, 세션id를 부여 같은id 브라우저간 데이터동일(크롬창 2개는 같은데이터, 크롬/파이어폭스는 다른데이터)
	cookie: 클라이언트에게 값을 전달(addCookie) 클라이언트에게 값을 가져옴(getCookies), path/만료시간 설정
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
	//결과값
		if(op_.equals("=")) {
			//int x = (int)application.getAttribute("value");	//getAttribute: Object값을 받아옴, setAttribute값 명시안하면 null값 받음
			//int x = (int)session.getAttribute("value");	
		//쿠키 내 value값 불러오기 
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y = num;
		//쿠키 내 operation값 불러오기 
			//String op = (String)application.getAttribute("oper");
			//String op = (String)session.getAttribute("oper");
			String op = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("oper")) {
					op = c.getValue();
					break;
				}
			}
		//연산	
			int result = 0;
			if(op.contentEquals("+"))
				result = x + y;
			else
				result = x - y;
			response.getWriter().printf("result : %d\n",result);
	//입력값
		} else {
			//application.setAttribute("value",num);
			//application.setAttribute("oper",op_);
			//session.setAttribute("value",num);
			//session.setAttribute("oper",op_);
			Cookie vCookie = new Cookie("value",String.valueOf(num)); //cookie 선언(String형태로만 값을 받음)
			Cookie oCookie = new Cookie("oper",op_);
			vCookie.setPath("/calc2");	//cookie가 적용되는 url 설정
			vCookie.setMaxAge(24*60*60);	//cookie가 만료되는 날짜
			oCookie.setPath("/calc2");
		//클라이언트에게 쿠키전달
			response.addCookie(vCookie);	
			response.addCookie(oCookie);
			
			response.sendRedirect("calc2.html");
		}
			
		
		
	}

}
