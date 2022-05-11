package action.reservation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ResvMenuCartRemoveAllService;
import svc.reservation.ResvMenuCartRemoveService;
import vo.ActionForward;

public class ResvMenuCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String menuID = request.getParameter("menuID");
		
		if(menuID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 할 메뉴를 선택해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			
		} else { 
			ResvMenuCartRemoveService resvMenuCartRemoveService = new ResvMenuCartRemoveService();
			resvMenuCartRemoveService.cartRemove(menuID,request);
			
			forward = new ActionForward("resvMenuCartList.RSV", true);

			
		}
		
		return forward;
	}

}
