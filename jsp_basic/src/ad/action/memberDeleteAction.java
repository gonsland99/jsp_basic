package ad.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ad.svc.MemberDeleteService;
import ad.vo.ActionForward;

public class memberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");

		ActionForward forward = null;
		if(id==null){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("memberLogin.do2");
		}else if(!id.equals("admin")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='memberLogin.do2';");
			out.println("</script>");
		}else{
			String deleteId=request.getParameter("id");
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean deleteResult=memberDeleteService.deleteMember(deleteId);

			if(deleteResult){
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("memberListAction.do2");
			}
			else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보삭제 실패.');");
				out.println("location.href='memberLogin.do2';");
				out.println("</script>");
			}
		}
		return forward;
	}

}
