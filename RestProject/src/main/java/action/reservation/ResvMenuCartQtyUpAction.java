package action.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ResvCartQtyUpService;
import vo.ActionForward;

public class ResvMenuCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String menuID = request.getParameter("menuID");
		
		ResvCartQtyUpService resvCartQtyUpService = new ResvCartQtyUpService();
		resvCartQtyUpService.upCartQty(menuID, request);
		
		forward = new ActionForward("resvMenuCartList.RSV", true);
		return forward;
	}

}
