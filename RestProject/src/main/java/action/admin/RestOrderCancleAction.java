package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import svc.admin.ResvOrderCancelService;
import vo.ActionForward;

public class RestOrderCancleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		ResvOrderCancelService resvOrderCancelService = new ResvOrderCancelService();
		
		boolean isOrderCancelSuccess = resvOrderCancelService.orderCancel(order_num);
		
		if(!isOrderCancelSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('관리자 예약 취소 실패');");
			out.println("history.back()"); 
			out.println("</script>");
			
		}else {
			forward = new ActionForward("restManageOrder.ADM", true);
		}
		
		
		return forward;
	}

}
