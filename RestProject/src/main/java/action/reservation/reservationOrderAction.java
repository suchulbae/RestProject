package action.reservation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ResMenuViewService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;

public class reservationOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		//주문전 한번더 확인
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");//오브젝트 타입이므로 형변환
		
		String menuID = request.getParameter("menuID");
		
		
		if (mID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href = 'memberLogin.RC';");
			out.println("</script>");
		} else {
			
			
			//예약메뉴 구매전 상세보기
			ResMenuViewService resMenuViewService = new ResMenuViewService();
			ResvMenuDTO rsvMenuInfo =resMenuViewService.getResvMenuView(menuID);
		
			
			//예약 화면으로 forward
			request.setAttribute("rsvMenuInfo", rsvMenuInfo);
			request.setAttribute("showRsvMenu", "/reservationMenu/reservationView.jsp");
			
			forward = new ActionForward("reservationTemplate.jsp", false);
			
			
			
		}
		return forward;
	}

}
