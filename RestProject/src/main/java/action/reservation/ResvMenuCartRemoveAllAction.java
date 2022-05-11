package action.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ResvMenuCartRemoveAllService;
import vo.ActionForward;

public class ResvMenuCartRemoveAllAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		ResvMenuCartRemoveAllService resvMenuCartRemoveAllService = new ResvMenuCartRemoveAllService();
		resvMenuCartRemoveAllService.cartRemoveAll(request);
		
		
		forward = new ActionForward("resvMenuCartList.RSV", true);
		return forward;
	}

}
