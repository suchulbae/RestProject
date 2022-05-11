package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.CalendarMonthSalesManageService;
import vo.ActionForward;

public class CalendarMonthSalesManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		// 파라미터로 전송된 year, month, Month로 sql문에서 사용하는 날짜 형식으로 변형
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String order_month = null;

		if (month.length() == 1) {
			order_month = year + "-0" + month;
		} else {
			order_month = year + "-" + month;
		}

		CalendarMonthSalesManageService calendarMonthSalesManageService = new CalendarMonthSalesManageService();
		int monthSalesTotalMoney = calendarMonthSalesManageService.getMonthSalesTotalMoney(order_month);

		if (monthSalesTotalMoney == -1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 불러오는데 실패했습니다. 다시 시도해주세요.');");
			out.println("history.back()'");
			out.println("</script>");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("order_month", order_month);
			session.setAttribute("monthSalesTotalMoney", monthSalesTotalMoney);

			// session 영역에 속성으로 공유시켰으므로 true나 false 둘 다 가능하다.
			forward = new ActionForward("admin/monthSalesTotalMoney.jsp", false);
		}

		return forward;
	}

}
