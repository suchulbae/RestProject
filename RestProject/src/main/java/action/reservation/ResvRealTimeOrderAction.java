package action.reservation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ResvMenuCartOrderService;
import vo.ActionForward;
import vo.reservationDTO.ResvOrder;

public class ResvRealTimeOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");
		// 로그인 확인부터
		if (mID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 해주세요.');");
			out.println("location.href='memberLogin.RC';");
			out.println("</script>");

		} else {
			
			
			ResvMenuCartOrderService resvMenuCartOrderService = new ResvMenuCartOrderService();
			
			//위에 선언한 mID 사용
			ResvOrder latestResvOrder=resvMenuCartOrderService.memberResvLastOrder(mID);
			
			session.setAttribute("latestResvOrder", latestResvOrder);
			
			
			forward   = new ActionForward("resvSuccessOrder.jsp", true);
			
			
		}
		
		
		
		
		
		
		
		return forward;
	}

}
