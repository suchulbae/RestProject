package svc.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MealKitCartRemoveAllService {
	// 멤버변수
	// 기본 생성자
	// 메서드
	
	public void cartRemoveAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList2");

		session.removeAttribute("cartList");
		
	}

}
