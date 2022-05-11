package action.mealKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import svc.mealKit.MealKitViewService;
import vo.ActionForward;
import vo.MealKit;

public class MealKitViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String mID = request.getParameter("mID");

		/*------------------- [메뉴 정보 상세 보기] -------------------*/
		MealKitViewService mealKitViewService = new MealKitViewService();
		MealKit mealKitInfo = mealKitViewService.getMealKitView(mID);

		request.setAttribute("mealKitInfo", mealKitInfo);

		/*------------------- [리뷰] -------------------*/
		/*
		ReviewListService reviewListService = new ReviewListService();
		ArrayList<Review> reviewList = reviewListService.getReviewList(mID);

		request.setAttribute("m_id", mID);// reviewTemplate.jsp, writeReview.jsp에서 사용

		request.setAttribute("reviewList", reviewList);
		request.setAttribute("reviewPage", "/review/reviewTemplate.jsp");
		request.setAttribute("showReview", "/review/showReview.jsp");// reviewList에 대한 정보 출력
		*/
		
		request.setAttribute("showMealKit", "/mealKit/mealKitView.jsp");// menuInfo에 대한 정보 출력

		forward = new ActionForward("mealKit/mealKitTemplate.jsp", false);
		
		return forward;
	}

}
