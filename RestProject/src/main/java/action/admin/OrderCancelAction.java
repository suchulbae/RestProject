package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.OrderCancelService;
import vo.ActionForward;

public class OrderCancelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		// 주문번호로 해당주문을 찾아서 order -> cancel 상태로 변경
		int meal_order_num = Integer.parseInt(request.getParameter("meal_order_num"));
		OrderCancelService orderCancelService = new OrderCancelService();
		boolean isOrderCancelSuccess = orderCancelService.orderCancel(meal_order_num);

		if (!isOrderCancelSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문취소 실패');");
			out.println("history.back()");
			out.println("</script>");
			
		} else {// get(주문승인)상태로 변경 성공하면
			forward = new ActionForward("dayOrderManage.ADM", true);// 리다이렉트 방식으로 다시 '실시간 주문 관리'요청
		}

		return forward;
	}

}
