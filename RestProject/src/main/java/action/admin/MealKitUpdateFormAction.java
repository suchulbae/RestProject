package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import svc.admin.MealViewService;
import vo.ActionForward;
import vo.MealKit;

public class MealKitUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String meal_id = request.getParameter("meal_id");
		MealViewService mealViewService = new MealViewService();
		MealKit mealKitUpdate = mealViewService.getMealView(meal_id);

		request.setAttribute("mealKitUpdate", mealKitUpdate);
		request.setAttribute("adminMealKit", "/admin/mealKitUpdateForm.jsp");
		request.setAttribute("showAdmin", "/admin/adminTemplate.jsp");

		forward = new ActionForward("admin/adminMain.jsp", false);
		//forward = new ActionForward("adminMain.jsp", false);
		
		return forward;
	}

}
