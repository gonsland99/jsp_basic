package dog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.svc.DogCartRemoveService;
import dog.vo.ActionForward;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String[] kindArray = request.getParameterValues("remove"); //장바구니 항목
		DogCartRemoveService dogCartRemoveService = new DogCartRemoveService();
		dogCartRemoveService.cartRemove(request, kindArray);
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}
