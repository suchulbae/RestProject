package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.ResvOrderDetailService;
import svc.memberSVC.MemberViewService;
import vo.ActionForward;
import vo.Address;
import vo.MemberDTO;
import vo.reservationDTO.ResvOrderDetail;


public class RestManageOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
	

		int order_num = Integer.parseInt(request.getParameter("order_num"));
		ResvOrderDetailService resvOrderDetailService = new ResvOrderDetailService();
		ArrayList<ResvOrderDetail> resvOrderDetail = resvOrderDetailService.getResvDetail(order_num);
		
		String mID= request.getParameter("mID");
		
		MemberViewService memberViewService = new MemberViewService();
		MemberDTO memberInfo = memberViewService.getMemberInfo(mID);
		Address memberAddressInfo  = memberViewService.getAddressInfo(mID);
		
	
		request.setAttribute("order_num", order_num);
		request.setAttribute("resvOrderDetailList", resvOrderDetail);
		
		request.setAttribute("memberInfo", memberInfo);
		request.setAttribute("memberAddressInfo", memberAddressInfo);
		

		request.setAttribute("showAdmin", "/reservationMenu/ResvOrderDetailList.jsp");

		forward = new ActionForward("/reservationMenu/adminMain.jsp", false);
		
		return forward;
	}

}
