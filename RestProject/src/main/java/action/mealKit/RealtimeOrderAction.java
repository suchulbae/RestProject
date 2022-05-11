package action.mealKit;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mealKit.MealKitCartOrderService;
import vo.ActionForward;
import vo.Order;

public class RealtimeOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");

		if (mID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 해주세요.')");
			out.println("location.href='memberLogin.RC'");
			out.println("</script>");

		} else {
			MealKitCartOrderService mealKitCartOrderService = new MealKitCartOrderService();
			Order latestOrder = mealKitCartOrderService.memberLastOrder(mID);

			// 다시 session영역에 같은 속성명인 latestOrder
			session.setAttribute("latestOrder", latestOrder);
			
			// successOrder.jsp로 돌아가 5초간격으로 계속 실행
			//forward = new ActionForward("mealKit/successOrder.jsp", true);
			forward = new ActionForward("successOrder.jsp", true);
		}
		return forward;
	}

}
