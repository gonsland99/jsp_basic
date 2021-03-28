package mvc2.action;
import javax.servlet.http.*;

import mvc2.vo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
