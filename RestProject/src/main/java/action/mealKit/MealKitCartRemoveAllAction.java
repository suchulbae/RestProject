package action.mealKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mealKit.MealKitCartRemoveAllService;
import vo.ActionForward;

public class MealKitCartRemoveAllAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		MealKitCartRemoveAllService mealKitCartRemoveAllService = new MealKitCartRemoveAllService();
		mealKitCartRemoveAllService.cartRemoveAll(request);

		forward = new ActionForward("mealKitCartList.KIOSK", true);

		return forward;
	}

}
