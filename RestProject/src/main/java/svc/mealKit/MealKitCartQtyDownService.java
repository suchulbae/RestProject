package svc.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MealKitCartQtyDownService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public void downCartQty(String meal_id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList2");

		// 장바구니 목록에서 해당 m_id를 찾아 수량 1 감소
		for (int i = 0; i < cartList.size(); i++) {
			if (meal_id.equals(cartList.get(i).getMeal_id()) && cartList.get(i).getMeal_qty() > 0) {
				cartList.get(i).setMeal_qty(cartList.get(i).getMeal_qty() - 1);
				break;
			}
		}

	}

}
