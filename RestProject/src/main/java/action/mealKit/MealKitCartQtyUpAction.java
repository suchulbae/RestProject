package action.mealKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mealKit.MealKitCartQtyUpService;
import vo.ActionForward;

public class MealKitCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String meal_id = request.getParameter("meal_id");

		// 장바구니 목록에서 해당 m_id를 찾아 수량 1 증가
		MealKitCartQtyUpService mealKitCartQtyUpService = new MealKitCartQtyUpService();
		mealKitCartQtyUpService.upCartQty(meal_id, request);

		// 다시 '장바구니 목록보기' 요청
		forward = new ActionForward("mealKitCartList.KIOSK", true);
		
		return forward;
	}

}
