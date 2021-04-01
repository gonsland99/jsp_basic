package dog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dog.vo.ActionForward;

public interface Action {
	ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
