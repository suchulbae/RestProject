package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.ResvOrderGetService;
import vo.ActionForward;

public class RestOrderGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		ResvOrderGetService resvOrderGetService = new ResvOrderGetService();
		
		boolean isOrderGetSuccess = resvOrderGetService.resvOrderGet(order_num);
		
		if(!isOrderGetSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("alert('주문승인 실패');");
			out.println("history.back()"); 
			out.println("</script>");
			
		}else {
			forward = new ActionForward("restManageOrder.ADM", true);
		}
		
		
		return forward;
	}

}
