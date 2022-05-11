package action.admin;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import svc.admin.MealDeleteService;
import vo.ActionForward;

public class MealKitDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String meal_id = request.getParameter("meal_id");
		String meal_category = request.getParameter("meal_category");

		if (meal_id != null) {
			MealDeleteService mealDeleteService = new MealDeleteService();
			boolean isMealDeleteSuccess = mealDeleteService.deleteMeal(meal_id);

			if (isMealDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('밀키트 삭제되었습니다.')");
				//out.println("history.back();");
				out.println("location.href='mealKitManage.ADM'");
				out.println("</script>");

				if (meal_category.equals("salad")) {
					forward = new ActionForward("salad.ADM", true);
				} else if (meal_category.equals("pasta")) {
					forward = new ActionForward("pasta.ADM", true);
				} else if (meal_category.equals("steak")) {
					forward = new ActionForward("steak.ADM", true);
				} else if (meal_category.equals("Tsteak")) {
					forward = new ActionForward("Tsteak.ADM", true);
				} else if (meal_category.equals("esca")) {
					forward = new ActionForward("esca.ADM", true);
				}

			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('밀키트 삭제가 실패했습니다.')");
				out.println("history.back();");
				out.println("</script>");
			}

		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제하려는 밀키트가 존재하지 않습니다.')");
			out.println("history.back();");
			out.println("</script>");

		}
		return forward;
	}

}
