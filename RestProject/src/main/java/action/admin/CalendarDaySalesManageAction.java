package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.CalendarDaySalesManageService;
import vo.ActionForward;

public class CalendarDaySalesManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String meal_order_date = year + "-" + month + "-" + day;

		CalendarDaySalesManageService calendarDaySalesManageService = new CalendarDaySalesManageService();
		int daySalesTotalMoney = calendarDaySalesManageService.getDaySalesTotalMoney(meal_order_date);

		System.out.println("daySalesTotalMoney = "+ daySalesTotalMoney);
		
		
		
		if (daySalesTotalMoney == -1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 불러오는데 실패했습니다. 다시 시도해주세요.');");
			out.println("history.back()';");
			out.println("</script>");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("meal_order_date", meal_order_date);
			session.setAttribute("daySalesTotalMoney", daySalesTotalMoney);

			forward = new ActionForward("/admin/daySalesTotalMoney.jsp", false);
		}

		return forward;
	}

}
