package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class ReservationModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		//한시간전엔 이미 예약요리가  진행되기때문에 앞당기거나 뒤로 미루기 불가
		
		String resvDATE=request.getParameter("resvDATE");
		
		String resvTIME2 = resvDATE; //따로 사용하기위해 변수에 요청값을 담고
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date resvTIME1=simpleDateFormat.parse(resvTIME2);
		LocalDateTime localDate = LocalDateTime.now();
		Date date = java.sql.Timestamp.valueOf(localDate);
		
		
		
		 long reservaionfailtime1 = (resvTIME1.getTime() - date.getTime()); // 요청시간과 로컬에서 받은 시간 연산

		long reservaionfailtime = reservaionfailtime1 / (60 * 1000);   //분으로 변환
		
		if (reservaionfailtime <60) {//1시간 차이날경우 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('규정상 예약한시간전엔 예약변경 불가능 합니다. 고객센터로 문의해주세요.')"); 
			out.println("history.back();"); 
			out.println("</script>");
		}else {
		
		
		
		
		
		
		
		

		request.setAttribute("order_num", order_num);

		request.setAttribute("resvDATE", resvDATE);
		
		
		forward = new ActionForward("reservationMenu/reservationModifyForm.jsp", false);

		}
		return forward;
	}

}
