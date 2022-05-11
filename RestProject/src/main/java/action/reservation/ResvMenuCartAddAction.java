package action.reservation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ResvMenuCartAddService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;

public class ResvMenuCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");
		
		
		if(mID==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href = 'memberLogin.RC';");
			out.println("</script>");
			
			
			
			
			
		}else {
			ResvMenuCartAddService resvMenuCartAddService = new ResvMenuCartAddService();
			
			ResvMenuDTO resMenuInfo = resvMenuCartAddService.getResvMenuView(request.getParameter("menuID"));
			
			
			resvMenuCartAddService.addCart(request,resMenuInfo);
			
			forward = new ActionForward("resvMenuCartList.RSV", true);
			
		}
		
		
		
		
		
		
		
		
		
		return forward;
	}

}
