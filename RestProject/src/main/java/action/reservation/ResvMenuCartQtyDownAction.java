package action.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ResvCartQtyDownService;

import vo.ActionForward;

public class ResvMenuCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String menuID = request.getParameter("menuID");
	
		
		ResvCartQtyDownService resvCartQtyDownService = new ResvCartQtyDownService();
		resvCartQtyDownService.downCartQty(menuID, request);
		
		forward = new ActionForward("resvMenuCartList.RSV", true);
		return forward;
	}

}
