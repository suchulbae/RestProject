package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.OrderDetailService;
import svc.memberSVC.MemberViewService;

import vo.ActionForward;
import vo.Address;
import vo.MemberDTO;
import vo.OrderDetail;


public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 주문 번호 '주문 상세 정보 리스트'를 얻어와 request에 속성값으로 공유
		int meal_order_num = Integer.parseInt(request.getParameter("meal_order_num"));
		OrderDetailService orderDetailService = new OrderDetailService();
		ArrayList<OrderDetail> orderDetailList = orderDetailService.getOrderDetailList(meal_order_num);

		// request.setAttribute("orderDetailList", orderDetailList); 아래의 위치가 좀 더 해석하기 좋다.

		// u_id '회원정보와 주소정보'를 얻어와 request에 속성값으로 공유
		String mID = request.getParameter("mID");
		MemberViewService memberViewService = new MemberViewService();
		MemberDTO memberInfo = memberViewService.getMemberInfo(mID);// 회원정보
		Address memberAddrInfo = memberViewService.getAddressInfo(mID);// 회원주소정보

		// request에 속성값으로 공유
		request.setAttribute("orderDetailList", orderDetailList);
		request.setAttribute("userInfo", memberInfo);
		request.setAttribute("userAddrInfo", memberAddrInfo);

		request.setAttribute("showAdmin", "/admin/orderDetailList.jsp");

		forward = new ActionForward("admin/mealKitConfirm/adminMain.jsp", false);
		
		return forward;
	}

}
