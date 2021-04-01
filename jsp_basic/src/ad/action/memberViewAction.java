package ad.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ad.svc.MemberViewService;
import ad.vo.ActionForward;
import ad.vo.MemberBean;

public class memberViewAction implements Action {

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
   			response.setContentType("text/html;charset=utf-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('관리자가 아닙니다.');");
	   		out.println("location.href='memberLogin.do2';");
	   		out.println("</script>");
   		}else{
	   		forward = new ActionForward();
	   		String viewId=request.getParameter("id");
	   		MemberViewService memberViewService = new MemberViewService();
	   		MemberBean member=memberViewService.getMember(viewId);
	   		request.setAttribute("member", member);
	   		forward.setPath("admin_memberInfo.jsp");
   		}
   		return forward;
	}

}
