package action.mealKit;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mealKit.MealKitCartOrderService;
import svc.memberSVC.MemberGradeService;
import vo.ActionForward;
import vo.Cart;
import vo.MealKit;
import vo.Order;
import vo.Order;

public class MealKitCartOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		// 파라미터로 전송된 totalMoney를 아래에서 세일된 값을 계산하기 위해
		int meal_totalMoney = Integer.parseInt(request.getParameter("meal_totalMoney"));

		HttpSession session = request.getSession();

		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList2");

		if (cartList == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문할 밀키트를 선택해주세요.')");
			out.println("history.back()");
			out.println("</script>");

		} else {// cartList(장바구니 목록) 있으면
			ArrayList<MealKit> mealKitList = new ArrayList<MealKit>();
			for (int i = 0; i < cartList.size(); i++) {
				Cart cart = cartList.get(i);
				MealKit mealKit = new MealKit(cart.getMeal_id(), cart.getMeal_category(), cart.getMeal_name(),
						cart.getMeal_price(), cart.getMeal_qty());
				mealKitList.add(mealKit);
			}

			String mID = (String) session.getAttribute("mID");
			String mEMAIL = (String) session.getAttribute("mEMAIL");

			if (mID == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 해주세요.')");
				out.println("location.href='memberLogin.RC'");
				out.println("</script>");

			} else {
				// session영역에 공유한 u_grade를 얻어와 등급별 세율비율을 얻어옴
				String mGRADE = (String) session.getAttribute("mGRADE");

				MemberGradeService memberGradeService = new MemberGradeService();
				double saleRate = memberGradeService.getSaleRate(mGRADE);

				// 정상적으로 값을 가져왔는지 확인한다.
				System.out.println("mGRADE : " + mGRADE + ", saleRate : " + saleRate);

				// 얻어온 등급별 세일비율로 세일된 가격을 계산(이때, 실수 -> 정수)
				int saleTotalMoney = (int) (meal_totalMoney * (1.0 - saleRate));// 10000*(1.0-0.1)/10000*0.9=9000.0
				System.out.println("totalMoney : " + meal_totalMoney + ", saleTotalMoney : " + saleTotalMoney);

				MealKitCartOrderService mealKitCartOrderService = new MealKitCartOrderService();
				boolean isOrderMealKitSuccess = mealKitCartOrderService.orderMealKit(mID, mEMAIL, mealKitList,
						saleTotalMoney);

				if (!isOrderMealKitSuccess) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('밀키트 주문에 실패했습니다. 다시 시도해주세요.')");
					out.println("history.back();"); // 이전 상태로 돌아가고
					out.println("</script>");

				} else {// 주문을 성공하면
					// session영역에 주문한 상세 내역(mealKitList)을 추가하고
					session.setAttribute("mealKitList", mealKitList);
					session.setAttribute("meal_totalMoney", meal_totalMoney);
					session.setAttribute("saleTotalMoney", saleTotalMoney);

					// [구매하기]가 끝나면 session영역에 '장바구니 목록(cartList)'은 삭제해야 함
					session.removeAttribute("cartList2");

					// u_id로 해당 사용자의 '가장 마지막 주문내역'을 조회한 결과를 반환
					Order latestOrder = mealKitCartOrderService.memberLastOrder(mID);
					// 같은 속성명인 latestOrder로 덮어씌워 새로운 값으로 변경됨
					session.setAttribute("latestOrder", latestOrder);

					forward = new ActionForward("successOrder.jsp", true);// 새요청

				}

			}
		}

		return forward;
	}

}
