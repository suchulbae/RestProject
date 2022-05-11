package action.admin;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import action.Action;
import svc.admin.MealAddService;
import svc.admin.MealViewService;
import vo.ActionForward;
import vo.MealKit;

public class MealKitAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		System.out.println(12);
		
		
		int maxSize = 1024 * 1024 * 5;

		String uploadFolder = "assets/img/mealKit";
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath(uploadFolder);

		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String meal_id = multi.getParameter("meal_id");
		String meal_category = multi.getParameter("meal_category");
		String meal_name = multi.getParameter("meal_name");
		int meal_price = Integer.parseInt(multi.getParameter("meal_price"));
		String meal_detail = multi.getParameter("meal_detail");
		String meal_status = multi.getParameter("meal_status");
		String meal_image = multi.getOriginalFileName("meal_image");

		MealViewService mealViewService = new MealViewService();
		MealKit checkMeal = mealViewService.getMealView(meal_id);

		if (checkMeal == null) {
			MealKit newMeal = new MealKit(meal_id, meal_category, meal_name, meal_price, meal_detail, meal_status,
					meal_image);
			MealAddService mealAddService = new MealAddService();
			boolean isAddMealSuccess = mealAddService.addMeal(newMeal);

			
			if (isAddMealSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('밀키트 추가되었습니다.')");
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
				out.println("alert('밀키트 추가에 실패했습니다. 확인 후 다시 추가해 주세요.')");
				out.println("history.back();");
				out.println("</script>");
			}
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록하려는 밀키트가 이미 존재합니다. 확인 후 다시 추가해 주세요.')");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
	}

}
