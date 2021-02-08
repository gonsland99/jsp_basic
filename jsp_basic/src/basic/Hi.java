package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")	//어노테이션: 주소경로(xml외에도 mapping)값을 읽어옴
public class Hi extends HttpServlet{
	@Override
/*	
 	HttpServletRequest/Response: 클라이언트,서블릿을 연결하는 객체 
 	ServletException: 예외를 throw할 수 없는 .NET Framework 이외의 애플리케이션에 클라이언트가 연결할 때 오류를 알리기 위한 예외
 	IOException: 입력, 출력 작업이 실패하거나 해석 될 때마다 발생
*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");		//응답시 한글깨짐방지
		response.setContentType("text/html; charset=utf-8");	//html형식, utf-8로 해석
		
		PrintWriter out = response.getWriter();		//out 내장객체 생성
		String cnt_ = request.getParameter("cnt");	// 임시변수:null값 방지를 위함, getParameter: 요청된 name값을 읽음
		int cnt = 100;
		
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		for(int i=0; i<cnt; i++)
			out.println((i+1) + " : 안녕 Hello~~! <br>");
	}
}
