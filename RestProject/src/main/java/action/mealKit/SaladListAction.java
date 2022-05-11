package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.SaladListService;
import vo.ActionForward;
import vo.MealKit;


public class SaladListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ActionForward forward = null;
		
		SaladListService saladListService = new SaladListService();
		ArrayList<MealKit> saladList = saladListService.getSaladList();
		
		request.setAttribute("saladList", saladList);
		request.setAttribute("showMealKit", "/mealKit/saladList.jsp");


		return new ActionForward("/mealKit/mealKitTemplate.jsp", false);
	}

}
