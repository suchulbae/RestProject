package action.reservation;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.memberSVC.MemberGradeService;
import svc.reservation.ResvLimitTableService;
import svc.reservation.ResvMenuCartOrderService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.ResvOrder;
import vo.reservationDTO.RevCart;

public class ResvMenuCartOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		

		
		
		int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
		
		HttpSession session = request.getSession();
		
		ArrayList<RevCart> cartList = (ArrayList<RevCart>) session.getAttribute("cartList");
		String resvDATE = request.getParameter("resvDATE");
		
		System.out.println("[ResvMenuCartOrderAction] resvDATE : " + resvDATE);
		
		//예외 거르기
		if(cartList == null ) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문할 코스나 메뉴를  선택해주세요.')");
			out.println("history.back()"); 
			out.println("</script>");
			
		}else {
			
			ArrayList<ResvMenuDTO> rsvMenuList = new ArrayList<ResvMenuDTO>();
			
			for (int i =0; i< cartList.size();i++) {
				
				RevCart cart = cartList.get(i);	
				
				ResvMenuDTO rsvMenu = new ResvMenuDTO(cart.getMenuID(), cart.getCategory(), cart.getMenuNAME(),cart.getResvPRICE(), cart.getQty());
				
				
				rsvMenuList.add(rsvMenu);//카트에서 가져온걸 add
			}

			
			
			
			
			
			
			
			
			
			// 오브젝트 타입이라 스트링으로 형변환
			String mID=(String) session.getAttribute("mID");
			System.out.println(mID);
			String mEMAIL = (String) session.getAttribute("mEMAIL");
			
			
			
	
			
			//1시간전 예약 못하게 막는 부분 // 참고 x 풀어본  부분 검색해서 안나와서 직접한부분
			 //성공 코드!
			
			
			// request 로 들어왔을경우
	
		
		
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
				out.println("alert('규정상 한시간전에만 예약가능합니다. 다시 시도해주세요.')"); 
				out.println("history.back();"); 
				out.println("</script>");
			}else {
				
				
				
				
				//새로운기능 테이블제한 서비스 로직 생성
				String limitTime =new SimpleDateFormat("yyyy-MM-dd").format(resvTIME1);
			
				//sql 에서 필요한부분부터 생각 select로 몇명인지 카운트 조건은 예약이아닌 상태 즉 'order'상태이고 매개로받은 예약일이여야함 
				ResvLimitTableService limitTable = new ResvLimitTableService();
				//테이블 몇개인지 확인할 카운트 메서드 생성 
				int resvOrder = limitTable.selectTable(limitTime);
				System.out.println(resvOrder);
			
				//if 로 판별
				if(resvOrder >12) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('예약 실패했습니다. 현재 12좌석이 전부 예약이 되었습니다.')"); 
					out.println("history.back();"); 
					out.println("</script>");
					
					
					
					
					
				}else {
				
				
				
			//////////////////////////////////////////
			
			if(mID== null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 해주세요.')");
				out.println("location.href='memberLogin.RC';");
				out.println("</script>");
			}else {
				//등급을 얻어와서
				String mGRADE = (String) session.getAttribute("mGRADE");
				//기존에 만든 그레이드 서비스 사용
				MemberGradeService memberGradeService = new MemberGradeService();
				
				
				double saleRate = memberGradeService.getSaleRate(mGRADE);
				
				
				int saleTotalMoney = (int) (totalMoney *(1.0-saleRate));
				
				ResvMenuCartOrderService resvMenuCartOrderService = new ResvMenuCartOrderService();
				boolean isOrderMenuSuccess = resvMenuCartOrderService.orderMenu(mID,mEMAIL,rsvMenuList,saleTotalMoney,resvDATE);
				
				
				if(!isOrderMenuSuccess) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('주문 실패했습니다. 다시 시도해주세요.')"); 
					out.println("history.back();"); 
					out.println("</script>");
					
					
					
				}else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('예약 완료되었습니다.')"); 
					out.println("</script>");
					//세션에 정보저장
					session.setAttribute("rsvMenuList", rsvMenuList);
					session.setAttribute("totalMoney", totalMoney);
					session.setAttribute("saleTotalMoney", saleTotalMoney);
					session.setAttribute("resvDATE", resvDATE);
				
								
					
					//장바구니 다썼으니 지우기
					session.removeAttribute("cartList");
					
					ResvOrder latestResvOrder = resvMenuCartOrderService.memberResvLastOrder(mID);
					
					session.setAttribute("latestResvOrder", latestResvOrder);
					
					
					forward = new ActionForward("resvSuccessOrder.jsp", true);
					
					
					
				}
					
				}
				
				
				
				
			}
			
			
			
			}
			
			
			
		}
		
		
		
		
		
		
		return forward;
	}

}
