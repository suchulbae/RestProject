package action.mealKit;

//import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import action.Action;
import vo.ActionForward;

public class MealKitAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		request.setAttribute("showMealKit", "/mealKit/mealKitKisokMainImage.jsp");

		forward = new ActionForward("mealKit/mealKitMain.jsp", false);
		
		/*
		if (mID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href='memberLogin.RC';");
			out.println("</script>");

		} else {
			
			request.setAttribute("showMealKit", "/mealKit/mealKitKisokMainImage.jsp");
			
			//request.setAttribute("showMealKit", "/mealKit/mealKitTemplate.jsp");
			
			forward = new ActionForward("mealKit/mealKitMain.jsp", false);
			//forward = new ActionForward("/mealKit/mealKitTemplate.jsp", false);
			
		}
		*/
		return forward;
	}

}
