package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.reservation.ReservationDeleteAction;
import action.reservation.ReservationDetailInfoViewListAction;
import action.reservation.ReservationInfoViewListAction;
import action.reservation.ReservationModifyFormAction;
import action.reservation.ResvMenuCartAddAction;
import action.reservation.ResvMenuCartListAction;
import action.reservation.ResvMenuCartOrderAction;
import action.reservation.ResvMenuCartQtyDownAction;
import action.reservation.ResvMenuCartQtyUpAction;
import action.reservation.ResvMenuCartRemoveAction;
import action.reservation.ResvMenuCartRemoveAllAction;
import action.reservation.ResvRealTimeOrderAction;
import action.reservation.reservationMenuAction;
import action.reservation.reservationMenuListAction;
import action.reservation.reservationMenuListBAction;
import action.reservation.reservationMenuListCAction;
import action.reservation.reservationModifyAction;
import action.reservation.reservationOrderAction;
import vo.ActionForward;

/**
 * Servlet implementation class MenuSaleFrontController
 */
@WebServlet("*.RSV") // reservation 약자 reservation=예약
public class ReservationMenuFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationMenuFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}
	
	// 이 서블릿으로 들어오는 모든 요청은 doProcess()를 호출하여 처리
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8"); // ★ 반드시 첫줄
			

			String requestURI = request.getRequestURI();
			
	
			String contextPath = request.getContextPath();
			
	
			
			String command = requestURI.substring(contextPath.length()); // 시작인덱스(index : 8 (두번째 / )) ~ 끝까지 부분문자열 생성
			
	
			Action action = null; 
			ActionForward forward = null;
			
			if(command.equals("/reservationMenu.RSV")) { //'메뉴 주문하기 '요청이면
				action = new reservationMenuAction();
					
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			//예약 코스 메뉴 보기  
			else if(command.equals("/reservationMenuList.RSV")) {
				action = new reservationMenuListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
		//	예약 메뉴 보기  프리미엄 사이드
			else if(command.equals("/reservationMenuListB.RSV")) {
				action = new reservationMenuListBAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			//예약 메뉴 보기  프리미엄 사이드 샐러드
			else if(command.equals("/reservationMenuListC.RSV")) {
				action = new reservationMenuListCAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			
			
	
			
			//예약 메뉴 상세보기 
			else if(command.equals("/reservationOrder.RSV")) {
				action = new reservationOrderAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			//예약 장바구니에 추가
			
			else if(command.equals("/resvMenuCartAdd.RSV")) {
				action = new ResvMenuCartAddAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			else if(command.equals("/resvMenuCartList.RSV")) {
				action = new ResvMenuCartListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			else if(command.equals("/resvMenuCartQtyUp.RSV")) {
				action = new ResvMenuCartQtyUpAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			
			else if(command.equals("/resvMenuCartQtyDown.RSV")) {
				action = new ResvMenuCartQtyDownAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			
			//장바구니 전부 지우기
			else if(command.equals("/resvMenuCartRemoveAll.RSV")) {
				action = new ResvMenuCartRemoveAllAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			//장바구니 지우기
			else if(command.equals("/resvMenuCartRemove.RSV")) {
				action = new ResvMenuCartRemoveAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
		//예약 화면 	
			else if(command.equals("/resvMenuCartOrder.RSV")) {
				action = new ResvMenuCartOrderAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			//실시간 예약확인

			else if(command.equals("/resvRealTimeOrder.RSV")) {
				action = new ResvRealTimeOrderAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
			
			
			

			
			
			
			//예약 정보 보기
			
			else if(command.equals("/reservationInfoViewList.RSV")) { 
				action = new ReservationInfoViewListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		} // 예약정보 자세히보기
			else if(command.equals("/reservationDetailInfoViewList.RSV")) { 
				action = new ReservationDetailInfoViewListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		}
			//예약 취소
			
			
			else if(command.equals("/reservationDelete.RSV")) { 
				action = new ReservationDeleteAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		}
			 //예약 수정
				else if(command.equals("/reservationModifyForm.RSV")) { 
					action = new ReservationModifyFormAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
			
				
			}
			
			else if(command.equals("/reservationModify.RSV")) { 
				action = new reservationModifyAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
					if(forward != null) {
			
				if(forward.isRedirect() == true) { // isRedirect() == true이면 리다이렉트(새요청) 방식 -> 기존 request 공유 못함
					response.sendRedirect(forward.getPath()); // memberMain.jsp
				}else {
					
					request.getRequestDispatcher(forward.getPath()).forward(request, response); // dogView.jsp로 이동 (한줄로 표현하기)
				}
			}
}
}
