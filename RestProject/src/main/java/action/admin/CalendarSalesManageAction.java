package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class CalendarSalesManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		/* '매출관리' 요청은 admin만 할 수 있도록 */
		HttpSession session = request.getSession();
		String mGRADE = (String) session.getAttribute("mGRADE");

		if (mGRADE == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인해주세요');");
			out.println("location.href = 'memberLogin.RC'");
			out.println("</script>");

		} else if (!mGRADE.equalsIgnoreCase("Admin")) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 사용가능합니다.');");
			out.println("location.href = 'memberLogin.RC'");
			out.println("</script>");

		} else {
			request.setAttribute("showAdmin", "/admin/calendarSalesView.jsp");

			forward = new ActionForward("admin/mealKitConfirm/adminMain.jsp", false);

		}

		return forward;
	}

}
