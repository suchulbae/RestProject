package action.mealKit;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mealKit.MealKitCartAddService;
import vo.ActionForward;
import vo.MealKit;


public class MealKitCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// '장바구니 담기' 위해 로그인된 상태인지를 확인해야 함
		HttpSession session = request.getSession();
		String mID = (String) session.getAttribute("mID");

		if (mID == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요.');");
			out.println("location.href = 'memberLogin.RC'");
			out.println("</script>");
			
		} else {
			MealKitCartAddService mealKitCartAddService = new MealKitCartAddService();
			MealKit mealKitInfo = mealKitCartAddService.getMealKitView(request.getParameter("meal_id"));
			
			// request전송이유? 장바구니 항목을 유지하기 위해 session영역에 추가해야 하므로
			mealKitCartAddService.addCart(request, mealKitInfo);
			
			// ★ 반드시 리다이렉트로 포워딩: 장바구니 항목에 새롭게 추가했으므로
			forward = new ActionForward("mealKitCartList.KIOSK", true); // 장바구니 목록 보기
		}
		
		return forward;
	}

}
