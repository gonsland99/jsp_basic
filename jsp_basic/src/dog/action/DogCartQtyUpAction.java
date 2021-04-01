package dog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.svc.DogCartQtyUpService;
import dog.vo.ActionForward;

public class DogCartQtyUpAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");	//장바구니 항목의 수량
		DogCartQtyUpService dogCartQtyUpService = new DogCartQtyUpService();
		dogCartQtyUpService.upCartQty(kind, request);
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}
