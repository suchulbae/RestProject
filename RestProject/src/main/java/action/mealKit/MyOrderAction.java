package action.mealKit;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mealKit.MyOrderService;
import vo.ActionForward;
import vo.Order;

public class MyOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");
		String mEMAIL = (String) session.getAttribute("mEMAIL");

		System.out.println("[MyOrderAction] mID:" + mID);
		System.out.println("[MyOrderAction] mEMAIL:" + mEMAIL);

		if (mID == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용가능한 서비스입니다.')");
			out.println("location.href='memberLogin.RC';");
			out.println("</script>");

		} else {
			MyOrderService myOrderService = new MyOrderService();
			ArrayList<Order> myOrderList = myOrderService.getMyOrderList(mID, mEMAIL);

			request.setAttribute("myOrderList", myOrderList);
			request.setAttribute("showPage", "/member/myOrderView.jsp");

			forward = new ActionForward("mealKit/memberTemplate.jsp", false);
			//forward = new ActionForward("memberTemplate.jsp", false);
		}

		return forward;
	}

}
