package action.mealKit;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mealKit.MealKitCartRemoveService;
import vo.ActionForward;

public class MealKitCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String meal_id = request.getParameter("meal_id");

		if (meal_id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 할 메뉴를 선택해주세요.');");
			out.println("history.back();");
			out.println("</script>");

		} else { // 해당 m_id가 있으면
			MealKitCartRemoveService mealKitCartRemoveService = new MealKitCartRemoveService();
			mealKitCartRemoveService.cartRemove(meal_id, request);

			forward = new ActionForward("mealKitCartList.KIOSK", true);
		}

		return forward;
	}

}
