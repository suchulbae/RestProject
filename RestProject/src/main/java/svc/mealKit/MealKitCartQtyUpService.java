package svc.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MealKitCartQtyUpService {

	public void upCartQty(String meal_id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList2");

		// 장바구니 목록에서 해당 m_id를 찾아 수량 1 증가
		for (int i = 0; i < cartList.size(); i++) {
			if (meal_id.equals(cartList.get(i).getMeal_id())) {
				cartList.get(i).setMeal_qty(cartList.get(i).getMeal_qty() + 1);;
				break;
			}
		}
		
	}

}
