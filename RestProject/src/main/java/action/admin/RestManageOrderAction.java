package action.admin;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.ResvOrderManageService;
import vo.ActionForward;
import vo.reservationDTO.ResvOrder;

public class RestManageOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		

		Date today2 = new Date(); // 현재 날짜 불러오기
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// MM:월, mm:시간의 분
		String today = simpleDateFormat.format(today2);
		
		HttpSession session = request.getSession();
		String mGRADE = (String) session.getAttribute("mGRADE");
		
		if(!mGRADE.equals("Admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인해주세요.');");
			out.println("location.href='memberLogin.RC';");
			out.println("</script>");
			
			
			
			
		}else {
			ResvOrderManageService resvOrderManageService = new ResvOrderManageService();
			ArrayList<ResvOrder> todayResvList	 = resvOrderManageService.getTodayResvOrder(today);
			

			
			
			request.setAttribute("todayResvList", todayResvList);
			
			session.setMaxInactiveInterval(60 * 60 * 12);
			
			request.setAttribute("showAdmin","/reservationMenu/adminResvOrderManage.jsp" );
			forward = new ActionForward("/reservationMenu/adminMain.jsp", false);
			
			
			
			
		}
		
		
		
		
		
		
		return forward;
	}

}
