package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ReservationDeleteService;
import vo.ActionForward;
import vo.reservationDTO.ReservationDelete;

public class ReservationDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		//사용자 이름 order_num 받아서 내역삭제
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		//주문시간도 부가적으로 확인해서 그시간삭제
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
			out.println("alert('규정상 예약한시간전엔 예약취소 불가능 합니다. 고객센터로 문의해주세요.')"); 
			out.println("history.back();"); 
			out.println("</script>");
		}else {
		
		ReservationDelete delete =new ReservationDelete(order_num, resvDATE) ;
		
		ReservationDeleteService reservationDeleteService =new ReservationDeleteService();
		boolean isDELETEsuccess = reservationDeleteService.deleteResv(delete);
		
		
		
		
		
		
		if(isDELETEsuccess== false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('삭제를 실패했습니다. 다시 시도해주세요');");
			out.println("history.back();");
			out.println("</script>");
			
		}else {
			
			
			
			
			
			response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('예약취소에  성공했습니다. ');");
	     	out.println("location.href = 'reservationInfoViewList.RSV';");
	         out.println("</script>");
			
			
			
			
		}
		
		
		}
		
		
		
		
		return forward;
	}

}
