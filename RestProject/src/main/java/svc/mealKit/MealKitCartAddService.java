package svc.mealKit;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MealKitDAO;
import vo.Cart;
import vo.MealKit;

public class MealKitCartAddService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public MealKit getMealKitView(String meal_id) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 MealKitDAO 객체 생성
		MealKitDAO mealKitDAO = MealKitDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 MealKitDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		mealKitDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		MealKit mealKitInfo = mealKitDAO.selectMealKitInfo(meal_id);

		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/

		// 4. 해제
		close(con); // Connection 객체 해제

		return mealKitInfo;
	}

	// 장바구니에 담기
	public void addCart(HttpServletRequest request, MealKit mealKitInfo) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList2 = (ArrayList<Cart>) session.getAttribute("cartList22");

		if (cartList2 == null) {
			cartList2 = new ArrayList<Cart>();
			session.setAttribute("cartList2", cartList2);
		}

		// 지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		boolean isNewCart = true;

		// 기존에 장바구니에 항목이 존재하면 같은 상품을 찾아서 수량을 1증가
		for (int i = 0; i < cartList2.size(); i++) {
			if (mealKitInfo.getMeal_id().equals(cartList2.get(i).getMeal_id())) {
				isNewCart = false;
				cartList2.get(i).setMeal_qty(cartList2.get(i).getMeal_qty() + 1);
				break;
			}
		}

		if (isNewCart) {// 지금 장바구니에 담는 항목이 새로 추가되는 항목이면
			Cart cart1 = new Cart(); // 기본값으로 채워진 Cart 객체를

			// 매개값으로 전송된 mealKitInfo값으로 채운 후
			cart1.setMeal_id(mealKitInfo.getMeal_id());
			cart1.setMeal_category(mealKitInfo.getMeal_category());
			cart1.setMeal_name(mealKitInfo.getMeal_name());
			cart1.setMeal_price(mealKitInfo.getMeal_price());
			cart1.setMeal_image(mealKitInfo.getMeal_image());
			cart1.setMeal_date(mealKitInfo.getMeal_date());
			cart1.setMeal_qty(1);

			cartList2.add(cart1);

		}

	}

}
