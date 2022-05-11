package action.admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.Action;
import svc.admin.EscaListService;
import vo.ActionForward;
import vo.MealKit;

public class EscaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String mGRADE = (String) session.getAttribute("mGRADE");

		if (mGRADE == null || !mGRADE.equalsIgnoreCase("Admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('CEO로 로그인해주세요');");
			out.println("location.href='memberLogin.RC'");
			out.println("</script>");

		} else {
			/********************************* [변경 부분 O] *********************************/
			EscaListService escaListService = new EscaListService();
			ArrayList<MealKit> escaList = escaListService.getEscaList();

			/********************************* [변경 부분 O] *********************************/
			request.setAttribute("mealKitAdminList", escaList);

			/********************************* [변경 부분 X] *********************************/
			request.setAttribute("adminMealKit", "/admin/mealKitAdminList.jsp");
			request.setAttribute("showAdmin", "/admin/adminTemplate.jsp");
			
			//forward = new ActionForward("adminMain.jsp", false);
			
			forward = new ActionForward("/admin/adminMain.jsp", false);
		}
		return forward;
	}

}
