package svc.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MealKitCartListService {
	// 멤버 변수
	// 기본생성자
	// 메서드
	
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		ArrayList<Cart> cartList2 = null;

		HttpSession session = request.getSession();
		cartList2 = (ArrayList<Cart>) session.getAttribute("cartList2");

		return cartList2;
	}

}
