package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.EscaListService;
import vo.ActionForward;
import vo.MealKit;

public class EscaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EscaListService escaListService = new EscaListService();
		ArrayList<MealKit> escaList = escaListService.getEscaList();
		
		request.setAttribute("escaList", escaList);
		request.setAttribute("showMealKit", "/mealKit/escaList.jsp");
		
		return new ActionForward("/mealKit/mealKitTemplate.jsp", false);
	}

}
