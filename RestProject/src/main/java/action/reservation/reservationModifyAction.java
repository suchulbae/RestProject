package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ResvModifyService;
import vo.ActionForward;
import vo.reservationDTO.ReservationDelete;

public class reservationModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		System.out.println(order_num);
		String resvDATE=request.getParameter("resvDATE");//요청 받은시간
		
		
String resvTIME2 = resvDATE; //따로 사용하기위해 변수에 요청값을 담고
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date resvTIME1=simpleDateFormat.parse(resvTIME2);
		LocalDateTime localDate = LocalDateTime.now();
		Date date = java.sql.Timestamp.valueOf(localDate);
		
		
		
		 long reservaionfailtime1 = (resvTIME1.getTime() - date.getTime()); // 요청시간과 로컬에서 받은 시간 연산
		 
		long reservaionfailtime = reservaionfailtime1 / (60 * 1000);   //분으로 변환
		
		if (reservaionfailtime <60  ) {//1시간 차이날경우 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이용시간 한시간전엔 예약변경이 불가능 합니다. 고객센터로 문의해주세요.')"); 
			out.println("history.back();"); 
			out.println("</script>");
		}else {
			
			
		//ReservationDelete 가 필요한 생성자가 같아서 시간단축을위해 그대로씀
		ReservationDelete modyfyDate = new ReservationDelete(order_num,resvDATE);
		
		ResvModifyService  resvModifyService = new ResvModifyService();
		boolean resvModifySuccess = resvModifyService.resvModify(modyfyDate);
		
		
		
		

		
		
		
		
		
		
		
		
		
		if(resvModifySuccess== false) {
			
		     response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('예약시간 수정에 실패 했습니다 .');");
	         out.println("history.back();");
	         out.println("</script>");
	         
	      }else {
	    	   	response.setContentType("text/html;charset=utf-8");
		         PrintWriter out = response.getWriter();
		         out.println("<script>");
		         out.println("alert('예약시간이 수정되었습니다 .');");
		    
		         out.println("</script>");
	    	  
	    	  
	    	   
	      }
		forward=new ActionForward("reservationInfoViewList.RSV",true);
		}
		
		return forward;
	}

}
