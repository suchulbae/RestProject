package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mealKit.MealKitCartListService;
import vo.ActionForward;
import vo.Cart;

public class MealKitCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		MealKitCartListService mealKitCartListService = new MealKitCartListService();
		ArrayList<Cart> cartList2 = mealKitCartListService.getCartList(request);
		

		/* ------------------- 지불할 총 금액 계산 ------------------- */
		int meal_totalMoney = 0;

		if (cartList2 != null) { // 빈 장바구니 목록
			for (int i = 0; i < cartList2.size(); i++) {
				meal_totalMoney += cartList2.get(i).getMeal_price() * cartList2.get(i).getMeal_qty(); // 가격과 수량을 누적 시켜야 한다.
			}
		}

		// 로그인된 상태동안 공유할 수 있도록 session영역에 저장함
		HttpSession session = request.getSession();
		
		request.setAttribute("meal_totalMoney", meal_totalMoney); // 공유 시켜서 보낸다.
		session.setAttribute("mealcartList", cartList2);

	

		forward = new ActionForward("/mealKit/mealKitCartList.jsp", false);

		return forward;
	}

}
