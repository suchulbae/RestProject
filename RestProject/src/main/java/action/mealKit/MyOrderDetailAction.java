package action.mealKit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mealKit.MyOrderDetailService;
import vo.ActionForward;
import vo.OrderDetail;

public class MyOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		int meal_order_num = Integer.parseInt(request.getParameter("meal_order_num"));
		//totalMoney를 int type으로 변환 이유? 이 후 연산을 위해('beforeSaleTotalMoney-saleTotalMoney = 할인 금액'
		int meal_totalmoney = Integer.parseInt(request.getParameter("meal_totalmoney"));

		MyOrderDetailService myOrderDetailService = new MyOrderDetailService();
		ArrayList<OrderDetail> myOrderDetailList = myOrderDetailService.getMyOrderDetailList(meal_order_num);

		// 할인이 적용되기 전 금액을 구함
		int beforeSaleTotalMoney = 0;

		for (OrderDetail orderDetail : myOrderDetailList) {
			beforeSaleTotalMoney += orderDetail.getMeal_price() * orderDetail.getMeal_quantity();
		}

		//System.out.println("beforeSaleTotalMoney: " + beforeSaleTotalMoney);

		request.setAttribute("myOrderDetailList", myOrderDetailList);
		request.setAttribute("beforeSaleTotalMoney", beforeSaleTotalMoney);// 할인되기 전 총금액
		request.setAttribute("saleTotalMoney", meal_totalmoney);	// 할인된 총 금액
		
		request.setAttribute("showPage", "/member/myOrderDetailView.jsp");
		
		forward = new ActionForward("mealKit/memberTemplate.jsp", false);
		
		return forward;
	}

}
