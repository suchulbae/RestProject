package action.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ReservationDetailInfoViewService;
import vo.ActionForward;
import vo.reservationDTO.ResvOrderDetail;

public class ReservationDetailInfoViewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		//넘어올때 String 문자로 넘어오기때문에 인트로 캐스팅
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
		String resvDATE= request.getParameter("resvDATE");
		String order_status= request.getParameter("order_status");
		ReservationDetailInfoViewService rservationDetailInfoViewService = new ReservationDetailInfoViewService();
		ArrayList<ResvOrderDetail> reservationDetailInfoView = rservationDetailInfoViewService.getResvDetailView(order_num);

		int beforeSaleTotalMoney=0;
		
		for(ResvOrderDetail resvOrderDetail:reservationDetailInfoView) {
			beforeSaleTotalMoney += resvOrderDetail.getResvPRICE() * resvOrderDetail.getQuantity();
		}
	
		
		request.setAttribute("resvDetailList", reservationDetailInfoView);
		request.setAttribute("beforeSaleTotalMoney", beforeSaleTotalMoney);// 할인되기 전 총금액
		request.setAttribute("saleTotalMoney", totalMoney);
		request.setAttribute("resvDATE", resvDATE);
		request.setAttribute("order_status", order_status);
		forward = new ActionForward("resvDetail.jsp", false);
		
		return forward;
	}

}
