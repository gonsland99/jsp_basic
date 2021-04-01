package dog.action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog.svc.DogCartListService;
import dog.vo.ActionForward;
import dog.vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartListService dogCartListService = new DogCartListService();
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		//총금액계산
		int totalMoney = 0;
		int money = 0 ;
		
		if(cartList != null) {
			for (int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getPrice() * cartList.get(i).getQty();
				totalMoney += money;
			}
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}

}
