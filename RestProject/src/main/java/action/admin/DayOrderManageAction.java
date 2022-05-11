package action.admin;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.DayOrderManageService;
import vo.ActionForward;
import vo.Order;

public class DayOrderManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String simpleDate_today = simpleDateFormat.format(today);

		/* 실시간 주문 관리 요청은 Admin만 할 수 있도록 mGRADE으로 등급을 구분했습니다. */
		HttpSession session = request.getSession();
		String mGRADE = (String) session.getAttribute("mGRADE");

		if (mGRADE == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인해주세요.');");
			out.println("location.href = 'memberLogin.RC'");
			out.println("</script>");

		} else {
			DayOrderManageService dayOrderManageService = new DayOrderManageService();
			ArrayList<Order> dayOrderList = dayOrderManageService.getDayOrderList(simpleDate_today);

			request.setAttribute("dayOrderList", dayOrderList);
			session.setMaxInactiveInterval(60 * 60 * 12);

			request.setAttribute("showAdmin", "/admin/dayOrderList.jsp");
			forward = new ActionForward("admin/mealKitConfirm/adminMain.jsp", false);
		}

		return forward;
	}

}
