package svc.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MealKitCartRemoveService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public void cartRemove(String meal_id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList2");

		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMeal_id().equals(meal_id)) {
				cartList.remove(cartList.get(i)); // 장바구니 목록에서 삭제
				break;// 삭제시킨 후 반목문 빠져나감
			}
		}

	}

}
