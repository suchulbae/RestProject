package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.mealKit.EscaListAction;
import action.mealKit.MealKitAction;
import action.mealKit.MealKitCartAddAction;
import action.mealKit.MealKitCartListAction;
import action.mealKit.MealKitCartOrderAction;
import action.mealKit.MealKitCartQtyDownAction;
import action.mealKit.MealKitCartQtyUpAction;
import action.mealKit.MealKitCartRemoveAction;
import action.mealKit.MealKitCartRemoveAllAction;
import action.mealKit.MealKitViewAction;
import action.mealKit.MyOrderAction;
import action.mealKit.MyOrderDetailAction;
import action.mealKit.PastaListAction;
import action.mealKit.RealtimeOrderAction;
import action.mealKit.SaladListAction;
import action.mealKit.SteakListAction;
import action.mealKit.TsteakListAction;
import vo.ActionForward;

/**
 * Servlet implementation class UserFrontController
 */
@WebServlet("*.KIOSK")
public class ResKioskFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResKioskFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	// 이 서블릿으로 들어오는 모든 요청은 doProcess()를 호출하여 처리
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 반드시 첫줄

		// '프로젝트명+파일경로' 예)/project/index.do
		String requestURI = request.getRequestURI();

		// 예)/project
		String contextPath = request.getContextPath();

		/*
		 * /project/index.do - /project = /index.do
		 */
		String command = requestURI.substring(contextPath.length());// (index8 ~ 끝까지) 부분문자열 반환

		/*
		 * 컨트롤러에서 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리 각 요청에 해당하는 Action클래스 객체들을
		 * 다형성을 이용해서 동일한 타입인 Action으로 참조하기 위해
		 */
		Action action = null;// Action부모 인터페이스 = Action을 구현한 객체
		ActionForward forward = null;
		
		System.out.println("[Kiosk] command " + command);

		/* ------------------- [회원 모드] '주문하기' 요청 ----------------------- */
		if (command.equals("/mealKit.KIOSK")) { // '밀키트 주문하기 '요청이면
			action = new MealKitAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}
		}

		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 'salad' 클릭하면 ------------------- */
		else if (command.equals("/salad.KIOSK")) { // '사용자모드: salad 주문하기' 요청이면
			action = new SaladListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 'pasta' 클릭하면 ------------------- */
		else if (command.equals("/pasta.KIOSK")) { // '사용자모드: pasta 주문하기' 요청이면
			action = new PastaListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 'steak' 클릭하면 ------------------- */
		else if (command.equals("/steak.KIOSK")) { // '사용자모드: steak 주문하기' 요청이면
			action = new SteakListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 'Tsteak' 클릭하면 ------------------- */
		else if (command.equals("/Tsteak.KIOSK")) { // '사용자모드: Tsteak 주문하기' 요청이면
			action = new TsteakListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 'esca' 클릭하면 ------------------- */
		else if (command.equals("/esca.KIOSK")) { // '사용자모드: esca 주문하기' 요청이면
			action = new EscaListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		
		/* ------------------- [회원 모드] '주문하기' 뷰페이지(menuTemplate.jsp)에서 '해당상품이미지를' 클릭하면 -> '해당상품의 자세한 정보보기' + '해당 상품의 리뷰' ------------------- */
		else if (command.equals("/mealKitView.KIOSK")) { // 사용자모드: '주문하기'의 '해당상품의 자세한 정보보기' + '해당 상품의 리뷰' 요청이면
			action = new MealKitViewAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 뷰페이지(menuView.jsp)에서 '장바구니 담기' 클릭하면 ------------------- */
		else if (command.equals("/mealKitCartAdd.KIOSK")) { // 사용자모드: '장바구니 담기'
			action = new MealKitCartAddAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] '장바구니 목록보기' 클릭하면 ------------------- */
		else if (command.equals("/mealKitCartList.KIOSK")) { // 사용자모드: '장바구니 목록보기' 요청이면
			action = new MealKitCartListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'mealKitCartList.jsp'에서 '▲수량 1증가' 요청이면 ------------------- */
		else if (command.equals("/mealKitCartQtyUp.KIOSK")) { // 사용자모드: '▲수량 1증가' 요청이면
			action = new MealKitCartQtyUpAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'mealKitCartList.jsp'에서 '▼수량 1감소' 요청이면 ------------------- */
		else if (command.equals("/mealKitCartQtyDown.KIOSK")) { // 사용자모드: '▼수량 1감소' 요청이면
			action = new MealKitCartQtyDownAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}

		/* ------------------- [회원 모드] 'menuCartList.jsp'에서 '전체 삭제' 요청이면 ------------------- */
		else if (command.equals("/mealKitCartRemoveAll.KIOSK")) { // 사용자모드: '전체 삭제' 요청이면
			action = new MealKitCartRemoveAllAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'menuCartList.jsp'에서 '하나의 메뉴삭제' 요청이면 ------------------- */
		else if (command.equals("/mealKitCartRemove.KIOSK")) { // 사용자모드: '하나의 메뉴삭제' 요청이면
			action = new MealKitCartRemoveAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'menuCartList.jsp'에서 '[구매하기]' 요청이면 ------------------- */
		else if (command.equals("/mealKitCartOrder.KIOSK")) { // 사용자모드: [구매하기] 요청이면
			action = new MealKitCartOrderAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'orderStatus.jsp'에서 '실시간주문' 요청이면 ------------------- */
		else if (command.equals("/realtimeOrder.KIOSK")) { // 사용자모드: '실시간주문' 요청이면
			action = new RealtimeOrderAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'userHeader.jsp'에서 '주문내역보기' 요청이면 ------------------- */
		else if (command.equals("/myOrder.KIOSK")) { // 사용자모드: '주문내역보기' 요청이면
			action = new MyOrderAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		
		/* ------------------- [회원 모드] 'myOrderView.jsp'에서 '주문번호 클릭하면' '주문상세정보' 요청이면 ------------------- */
		else if (command.equals("/myOrderDetail.KIOSK")) { // 사용자모드: '주문상세정보' 요청이면
			action = new MyOrderDetailAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated method stub
				e.printStackTrace();
			}

		}
		/************************************************
		 * 포워딩
		 ************************************************/
		if (forward != null) {
			if (forward.isRedirect() == true) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
				
			}
		}
	}

}
