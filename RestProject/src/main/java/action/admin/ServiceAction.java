package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class ServiceAction implements Action {

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
			out.println("location.href = 'memberLogin.RC'");
			out.println("</script>");

		} else {
			request.setAttribute("adminMealKit", "/admin/mealKitConfirm/loading.jsp");

			request.setAttribute("showAdmin", "/admin/adminTemplate.jsp");

			forward = new ActionForward("/admin/mealKitConfirm/adminMain.jsp", false);
		}

		return forward;
	}

}
