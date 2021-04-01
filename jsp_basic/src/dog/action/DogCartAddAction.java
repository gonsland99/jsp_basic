package dog.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dog.svc.DogCartAddService;
import dog.vo.ActionForward;
import dog.vo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog cartDog = dogCartAddService.getCartDog(id);
		dogCartAddService.addCart(request, cartDog);
		ActionForward forward = new ActionForward("dogCartList.dog", true);
		return forward;
	}

}
