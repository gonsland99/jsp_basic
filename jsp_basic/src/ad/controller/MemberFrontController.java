package ad.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.action.Action;
import ad.action.memberDeleteAction;
import ad.action.memberJoinAction;
import ad.action.memberListAction;
import ad.action.memberLoginAction;
import ad.action.memberViewAction;
import ad.vo.ActionForward;

@WebServlet("*.do2")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		System.out.println(requestURI);
		System.out.println(contextPath);
		System.out.println(command);

		if (command.equals("/memberLogin.do2")) {
			forward = new ActionForward();
			forward.setPath("/admin_loginForm.jsp");
		} else if (command.equals("/memberJoin.do2")) {
			forward = new ActionForward();
			forward.setPath("/admin_joinForm.jsp");
		} else if (command.equals("/memberLoginAction.do2")) {
			action = new memberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberJoinAction.do2")) {
			action = new memberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberListAction.do2")) {
			action = new memberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberViewAction.do2")) {
			action = new memberViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberDeleteAction.do2")) {
			action = new memberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
//		else {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('잘못된 경로입니다.')");
//			out.println("location.href='memberLogin.do'");
//			out.println("</script>");
//			forward = new ActionForward();
//		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}

