package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
//		���� Ǯ��
//		PrintWriter out = response.getWriter();
//		
//		int n1 = Integer.parseInt(request.getParameter("num1"));
//		int n2 = Integer.parseInt(request.getParameter("num2"));
//		
//		int sum = n1 + n2;
//		out.println("��� : " + sum);
		
//		����ó Ǯ��
		String n1_ = request.getParameter("num1");
		String n2_ = request.getParameter("num2");
		String op = request.getParameter("operator");
		
		int n1 = 0;
		int n2 = 0;
		
		if(!n1_.equals("")) n1 = Integer.parseInt(n1_);
		if(!n2_.equals("")) n2 = Integer.parseInt(n2_);
		
		if(op.equals("���ϱ�"))
			response.getWriter().printf("result : %d\n",n1 + n2);
		else
			response.getWriter().printf("result : %d\n",n1 - n2);
			
		
		
	}

}
