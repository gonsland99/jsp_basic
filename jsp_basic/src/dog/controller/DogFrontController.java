package dog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.action.*;
import dog.vo.*;

@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1. 요청파악
		String requestURI = request.getRequestURI();
		//요청 URL : http://localhost:8088/boardProject/boardWriteFrom.bo
		//requestURI : /boardProject/boardWriteForm.bo 반환
		
		String contextPath = request.getContextPath();
		//   /boardProject 반환
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		//2.각 요청별로 비지니스로직 호출
		if(command.equals("/dogList.dog")){
			action = new DogListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogView.dog")) {
			action = new DogViewAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartAdd.dog")) {
			action = new DogCartAddAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartList.dog")) {
			action = new DogCartListAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/cookieRemove.dog")) {
			action = new cookieRemoveAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartSearch.dog")) {
			action = new DogCartSearchAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartRemove.dog")) {
			action = new DogCartRemoveAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartQtyUp.dog")) {
			action = new DogCartQtyUpAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogCartQtyDown.dog")) {
			action = new DogCartQtyDownAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogRegist.dog")) {
			action = new DogRegistAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dogRegistForm.dog")) {
			action = new DogRegistFormAction();
			try {
				forward = action.excute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
