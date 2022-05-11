package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import vo.ActionForward;


public class MealKitAddFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		request.setAttribute("adminMealKit", "/admin/mealKitAddForm.jsp");
		request.setAttribute("showAdmin", "/admin/adminTemplate.jsp");
		
		//forward = new ActionForward("adminMain.jsp", false);
		
		forward = new ActionForward("/admin/adminMain.jsp", false);

		return forward;
	}

}
