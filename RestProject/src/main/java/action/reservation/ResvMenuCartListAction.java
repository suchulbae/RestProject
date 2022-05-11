package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ResvLimitTableService;
import svc.reservation.ResvMenuCartListService;
import vo.ActionForward;

import vo.reservationDTO.RevCart;

public class ResvMenuCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		ResvMenuCartListService resvMenuCartListService = new ResvMenuCartListService();

		ArrayList<RevCart> cartList = resvMenuCartListService.getCartList(request);

		/*----------------*/
		int totalMoney = 0;

		if (cartList != null) { // 빈 장바구니 목록
			for (int i = 0; i < cartList.size(); i++) {
				totalMoney += cartList.get(i).getResvPRICE() * cartList.get(i).getQty(); // 가격과 수량을 누적 시켜야 한다.
			}
		}

		HttpSession session = request.getSession();

		String mID = (String) session.getAttribute("mID");

		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String now = simpleDateFormat.format(today);

		// 현재 시간 얻기
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

		Date now2 = new Date();
		String nowTime1 = sdf1.format(now2);

		//////////////////////////////////////////

		// 첫째날 얻기
		cal.set(y, m, 1);
		// 요일 가져오기
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);// 이번달의 첫째날 금요일 이므로 6
		int lastday = cal.getActualMaximum(Calendar.DATE); // 이번달의 마지막날

		if (mID == null) {// 로그아웃 상태이면

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();// 화면에 출력(★★주의 : jsp가 아니므로 직접 생성해야함 )
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href = 'memberLogin.RC';");// '로그인 폼보기' 요청
			out.println("</script>");
		} else {
			
			//오늘 예약 몇테이블인지 조회
			ResvLimitTableService limitTable = new ResvLimitTableService();
			
			int todaylimitTable2 = 12; 
			int resvOrder = limitTable.selectTable();
			//오늘 잔여테이블을 미리보여주기
			//어차피 결제시에 거르기때문에 잔여테이블만 보여주면된다
			int todaylimitTable	=todaylimitTable2-resvOrder; 
			
			
			
			
			
			
			request .setAttribute("todaylimitTable",todaylimitTable);
			
			request.setAttribute("y", y);
			request.setAttribute("m", m);
			request.setAttribute("dayOfweek", dayOfweek);
			request.setAttribute("lastday", lastday);
			request.setAttribute("now", now);

			request.setAttribute("nowTime1", nowTime1);

			request.setAttribute("totalMoney", totalMoney);

			session.setAttribute("cartList", cartList);

			request.setAttribute("reservationMenu", "/revMenuCartList.jsp");
			forward = new ActionForward("/reservationMenu/resvCart.jsp", false);

		}
		return forward;
	}

}
