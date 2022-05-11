package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class reservationMenuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ActionForward forward = null;

		// 먼저, 주문하기 위해 로그인된 상태인지를 확인
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");
		
		//달력 만들기
		Calendar cal=Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String now = simpleDateFormat.format(today);
		
		
		//첫째날 얻기 
		cal.set(y,m,1);
		//요일 가져오기
		int dayOfweek= cal.get(Calendar.DAY_OF_WEEK);//이번달의 첫째날 금요일 이므로 6 
		int lastday=cal.getActualMaximum(Calendar.DATE); // 이번달의 마지막날
	
		
		

		if (mID == null) {// 로그아웃 상태이면

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();// 화면에 출력(★★주의 : jsp가 아니므로 직접 생성해야함 )
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href = 'memberLogin.RC';");// '로그인 폼보기' 요청
			out.println("</script>");
		} else {
		
			
			
			
			
			
			
			
			
			request.setAttribute("y", y);
			request.setAttribute("m", m);
			request.setAttribute("dayOfweek", dayOfweek);
			request.setAttribute("lastday", lastday);
			request.setAttribute("now", now);
			
			
			
			
			
			
			
			
			
			
			forward = new ActionForward("reservationTemplate.jsp", false);
		}

		
		return forward;
	}

}
