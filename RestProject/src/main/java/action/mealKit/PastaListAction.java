package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.PastaListService;
import vo.ActionForward;
import vo.MealKit;

public class PastaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PastaListService pastaListService = new PastaListService();
		ArrayList<MealKit> pastaList = pastaListService.getPastaList();
		
		request.setAttribute("pastaList", pastaList);
		request.setAttribute("showMealKit", "/mealKit/pastaList.jsp");
		
		return new ActionForward("/mealKit/mealKitTemplate.jsp", false);
	}

}
