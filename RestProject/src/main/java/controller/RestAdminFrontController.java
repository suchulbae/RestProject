package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.admin.CalendarDaySalesManageAction;
import action.admin.CalendarMonthSalesManageAction;
import action.admin.CalendarSalesManageAction;
import action.admin.DayOrderManageAction;
import action.admin.EscaListAction;
import action.admin.MealKitAddAction;
import action.admin.MealKitAddFormAction;
import action.admin.MealKitConfirmAction;
import action.admin.MealKitDeleteAction;
import action.admin.MealKitManageAction;
import action.admin.MealKitUpdateAction;
import action.admin.MealKitUpdateFormAction;
import action.admin.OrderCancelAction;
import action.admin.OrderDetailAction;
import action.admin.OrderGetAction;
import action.admin.PastaListAction;
import action.admin.RestManageOrderAction;
import action.admin.RestManageOrderDetailAction;
import action.admin.RestMenuAddAction;
import action.admin.RestMenuAddFormAction;
import action.admin.RestOrderCancleAction;
import action.admin.RestOrderGetAction;
import action.admin.RestSalesDayAction;
import action.admin.RestSalesMonthAction;
import action.admin.RestSalesNomalMonth;
import action.admin.SaladListAction;
import action.admin.ServiceAction;
import action.admin.SteakListAction;
import action.admin.TotalOrderManageAction;
import action.admin.TsteakListAction;
import vo.ActionForward;

/**
 * Servlet implementation class MenuSaleFrontController
 */
@WebServlet("*.ADM")
public class RestAdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestAdminFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response); // doGet이든 doPost든 doProcess에서 처리함
	}

	// 이 서블릿으로 들어오는 모든 요청은 doProcess()를 호출하여 처리
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // ★ 반드시 첫줄

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();

		String command = requestURI.substring(contextPath.length()); // 시작인덱스(index : 8 (두번째 / )) ~ 끝까지 부분문자열 생성

		Action action = null;
		ActionForward forward = null;
		
		System.out.println("[Admin]command: " + command);
		
		
		if (command.equals("/adminMain.ADM")) {
			forward = new ActionForward("adminMain.jsp", false);
		}

		/* ----------------------- '밀키트 관리' 처리 (시작) ----------------------- */
		else if (command.equals("/mealKitManage.ADM")) {// '밀키트 관리'요청이면
			action = new MealKitManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 'salad 밀키트 관리' -> salad 요청처리 ----------------------- */
		else if (command.equals("/salad.ADM")) {
			action = new SaladListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 'pasta 밀키트 관리' -> pasta 요청처리 ----------------------- */
		else if (command.equals("/pasta.ADM")) {
			action = new PastaListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 'steak 밀키트 관리' -> steak 요청처리 ----------------------- */
		else if (command.equals("/steak.ADM")) {
			action = new SteakListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 'Tsteak 밀키트 관리' -> Tsteak 요청처리 ----------------------- */
		else if (command.equals("/Tsteak.ADM")) {
			action = new TsteakListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 'Esca 밀키트 관리' -> Esca 요청처리 ----------------------- */
		else if (command.equals("/esca.ADM")) {
			action = new EscaListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '밀키트 관리 안에 ' -> '밀키트 추가 폼 보기 요청 -> 처리'이면 ----------------------- */
		else if (command.equals("/mealKitAddForm.ADM")) { // '밀키트 관리' 안에 -> '밀키트 관리 추가' 폼 보기 요청 이면
			action = new MealKitAddFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '밀키트 관리 안에 ' -> 추가 요청처리 ----------------------- */
		else if (command.equals("/mealKitAdd.ADM")) { // '밀키트 관리' 안에 -> 추가 요청처리
			action = new MealKitAddAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '밀키트 수정 ' -> 추가 요청처리 ----------------------- */
		else if (command.equals("/mealKitUpdateForm.ADM")) { // '밀키트 관리 수정' 안에 -> 추가 요청처리
			action = new MealKitUpdateFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '밀키트 수정 처리' -> 추가 요청처리 ----------------------- */
		else if (command.equals("/mealKitUpdate.ADM")) { // '밀키트 수정 처리' 안에 -> 추가 요청처리
			action = new MealKitUpdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		
		/* ----------------------- '밀키트 삭제' 처리 -> 삭제 요청처리 ----------------------- */
		else if (command.equals("/mealKitDelete.ADM")) { // '밀키트 삭제 처리-> 요청이면
			action = new MealKitDeleteAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		
	      
	      else if (command.equals("/restMenuAddForm.ADM")) { // '메뉴관리' 안에 -> '메뉴추가' 폼 보기 요청 이면
	         action = new RestMenuAddFormAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated method stub
	            e.printStackTrace();
	         }
	      }
	      else if (command.equals("/RestMenuAdd.ADM")) { // '메뉴 추가 처리-> 요청이면
	         action = new RestMenuAddAction();

	         try {
	            forward = action.execute(request, response);
	         } catch (Exception e) {
	            // TODO Auto-generated method stub
	            e.printStackTrace();
	         }
	      }

		//예약 주문관리 
	      else if (command.equals("/restManageOrder.ADM")) { 
		         action = new RestManageOrderAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
		//
		
	      else if (command.equals("/restManageOrderDetail.ADM")) { 
		         action = new RestManageOrderDetailAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
		
	      else if (command.equals("/restOrderGet.ADM")) { 
		         action = new RestOrderGetAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
	      else if (command.equals("/restOrderCancle.ADM")) { 
		         action = new RestOrderCancleAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
		
		
		
		
			///클릭시 월매출
	      else if (command.equals("/restSalesMonth.ADM")) { 
		         action = new RestSalesMonthAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
		
		
	      else if (command.equals("/restSalesNomalMonth.ADM")) { 
		         action = new RestSalesNomalMonth();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
		
		
		
		
		
	   
		
	      else if (command.equals("/restSalesDay.ADM")) { 
		         action = new RestSalesDayAction();

		         try {
		            forward = action.execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated method stub
		            e.printStackTrace();
		         }
		      }
		
	   
		/* --------------------------------------------------- 실시간 밀키트 주문 부분 시작 --------------------------------------------------- */
		else if (command.equals("/mealKitConfirm.ADM")) {
			action = new MealKitConfirmAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '고객센터' 처리 -> 코스 예약처리 ----------------------- */	
		else if (command.equals("/service.ADM")) {
			action = new ServiceAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/dayOrderManage.ADM")) {
			action = new DayOrderManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '실시간 주문관리, 전체 주문관리'에서 주문번호 클릭하면 '주문번호 상세 정보 보기' 요청 ----------------------- */
		else if (command.equals("/orderDetail.ADM")) {// '주문번호 상세 정보 보기' 요청이면
			action = new OrderDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '실시간 주문관리'에서 밀키트 주문상태를(meal_order_num)를 order(주문대기)에서 'get(주문승인)'으로 변경하기 위해서, ' 처리 요청 ----------------------- */
		else if (command.equals("/orderGet.ADM")) {// '주문 승인'요청 이면
			action = new OrderGetAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '실시간 주문관리'에서 밀키트 주문상태를(meal_order_num)를 order(주문대기)에서 'get(주문승인)'으로 변경하기 위해서' 처리 요청 ----------------------- */
		else if (command.equals("/orderCancel.ADM")) {// '주문 실패'요청 이면
			action = new OrderCancelAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '전체 주문관리' 요청 ----------------------- */
		else if (command.equals("/totalOrderManage.ADM")) {// '전체 주문관리'요청 이면
			action = new TotalOrderManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- '매출관리' 요청 ----------------------- */
		else if (command.equals("/calendarSalesManage.ADM")) {// '매출관리'요청 이면
			action = new CalendarSalesManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 매출관리'-> 달력에서 '[일]을 클릭'하면 팝업창에서 '일매출 합계'보기 요청 ----------------------- */
		else if (command.equals("/calendarDaySalesManage.ADM")) {// '일매출 합계' 보기 요청 이면
			action = new CalendarDaySalesManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* ----------------------- 매출관리'-> 달력에서 '[월 매출조회] 버튼 클릭'하면 팝업창에서 '월 매출조회'보기 요청 ----------------------- */
		else if (command.equals("/calendarMonthSalesManage.ADM")) {// '월 매출조회' 보기 요청 이면
			action = new CalendarMonthSalesManageAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}
		
		/* --------------------------------------------------- 실시간 밀키트 주문 부분 끝 --------------------------------------------------- */	
		
		
		
		
		
		
		
		if (forward != null) {
			if (forward.isRedirect() == true) {
				response.sendRedirect(forward.getPath());
				
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response); 
			}
		}
	}
}
