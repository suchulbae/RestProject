package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.TsteakListService;
import vo.ActionForward;
import vo.MealKit;

public class TsteakListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TsteakListService tSteakListService = new TsteakListService();
		ArrayList<MealKit> tSteakList = tSteakListService.getTsteakList();
		
		request.setAttribute("tSteakList", tSteakList);
		request.setAttribute("showMealKit", "/mealKit/tSteakList.jsp");
		
		return new ActionForward("/mealKit/mealKitTemplate.jsp", false);
	}

}
