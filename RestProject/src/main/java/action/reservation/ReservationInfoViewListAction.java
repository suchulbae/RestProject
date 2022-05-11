package action.reservation;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ReservationViewService;
import vo.ActionForward;
import vo.reservationDTO.ResvOrder;

public class ReservationInfoViewListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session =request.getSession();
		String mID = (String) session.getAttribute("mID"); //세션에있는 아이디 가져오기 오브젝트 타입이라 스트링으로 형변환
		String mEMAIL = (String) session.getAttribute("mEMAIL");
		
		//로그인 확인
		
		if(mID == null) { //  세션에 id 가없는상태
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.');"); 
			out.println("location.href ='memberLogin.RC'");
			out.println("</script>");
			
		}else {
			ReservationViewService reservationViewService = new ReservationViewService ();
			ArrayList<ResvOrder> resvOrder = reservationViewService.getresvOrder(mID,mEMAIL);
			
			
			request.setAttribute("resvOrder", resvOrder);
			
			forward = new ActionForward("reservationMenu/resvOrder.jsp", false);
		}
		
		
		
		
		
		
		return forward;
	}

}
