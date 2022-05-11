package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.SteakListService;
import vo.ActionForward;
import vo.MealKit;

public class SteakListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SteakListService steakListService = new SteakListService();
		ArrayList<MealKit> steakList = steakListService.getSteakList();
		
		request.setAttribute("steakList", steakList);
		request.setAttribute("showMealKit", "/mealKit/steakList.jsp");
		
		return new ActionForward("/mealKit/mealKitTemplate.jsp", false);
	}

}
