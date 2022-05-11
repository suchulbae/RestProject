package action.admin;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.admin.MealKitUpdateService;
import vo.ActionForward;
import vo.MealKit;

public class MealKitUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int maxSize = 1024 * 1024 * 5;// 한번에 올릴 수 있는 최대 용량 5M로 제한

		String uploadFolder = "/assets/img/mealKit";
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
		
		
		MealKit newMealKit = new MealKit(meal_id, meal_category, meal_name, meal_price, meal_detail, meal_status, meal_image);

		MealKitUpdateService mealKitUpdateService = new MealKitUpdateService();
		boolean isUpdateMealKitSuccess =  mealKitUpdateService.updateMealKit(newMealKit);
		
		
		if (isUpdateMealKitSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('밀키트 수정이 성공하였습니다.)");
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
			out.println("alert('밀키트 수정이 실패했습니다. 다시 한 번 확인해 주세요.')");
			out.println("history.back();"); 
			out.println("</script>");
		}
		
		return forward;
	}

}
