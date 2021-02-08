package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")	//������̼�: �ּҰ��(xml�ܿ��� mapping)���� �о��
public class Hi extends HttpServlet{
	@Override
/*	
 	HttpServletRequest/Response: Ŭ���̾�Ʈ,������ �����ϴ� ��ü 
 	ServletException: ���ܸ� throw�� �� ���� .NET Framework �̿��� ���ø����̼ǿ� Ŭ���̾�Ʈ�� ������ �� ������ �˸��� ���� ����
 	IOException: �Է�, ��� �۾��� �����ϰų� �ؼ� �� ������ �߻�
*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");		//����� �ѱ۱�������
		response.setContentType("text/html; charset=utf-8");	//html����, utf-8�� �ؼ�
		
		PrintWriter out = response.getWriter();		//out ���尴ü ����
		String cnt_ = request.getParameter("cnt");	// �ӽú���:null�� ������ ����, getParameter: ��û�� name���� ����
		int cnt = 100;
		
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		for(int i=0; i<cnt; i++)
			out.println((i+1) + " : �ȳ� Hello~~! <br>");
	}
}
