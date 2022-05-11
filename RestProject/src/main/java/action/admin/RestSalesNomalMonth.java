package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.ResvNomalService;
import vo.ActionForward;
import vo.reservationDTO.ResvOrder;

public class RestSalesNomalMonth implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward= null;
		
		
		
		ResvNomalService resvNomalService = new ResvNomalService();
		
		int minusdayMoney = resvNomalService.getminusdayMoney();
		int minusdayMoney2 = resvNomalService.getminusdayMoney2();
		int minusdayMoney3 = resvNomalService.getminusdayMoney3();
		int minusdayMoney4 = resvNomalService.getminusdayMoney4();
		int minusdayMoney5 = resvNomalService.getminusdayMoney5();
		int minusdayMoney6 = resvNomalService.getminusdayMoney6();
		
		
		ArrayList <ResvOrder> resvTodayView = resvNomalService.getMonthView();
		ArrayList <ResvOrder> resvTotalview = resvNomalService.getMonthTotalView();
			
		
		
		
		
		int todayTotalMoney =0;
		for(int i = 0; i <resvTodayView.size();i++) {
			todayTotalMoney	+=resvTodayView.get(i).getTotalMoney();
		}
		
		
		
		int totalMoney =0;
		for(int i = 0; i <resvTotalview.size();i++) {
			totalMoney	+=resvTotalview.get(i).getTotalMoney();
		}
		HttpSession session = request.getSession();
		request.setAttribute("todayTotalMoney", todayTotalMoney);
		request.setAttribute("resvTotalview", resvTotalview);
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("resvTodayView", resvTodayView);
		session.setAttribute("totalMoney", totalMoney);
		request.setAttribute("minusdayMoney", minusdayMoney);
		request.setAttribute("minusdayMoney2", minusdayMoney2);
		request.setAttribute("minusdayMoney3", minusdayMoney3);
		request.setAttribute("minusdayMoney4", minusdayMoney4);
		request.setAttribute("minusdayMoney5", minusdayMoney5);
		request.setAttribute("minusdayMoney6", minusdayMoney6);
		
		forward = new ActionForward("resvMoneyCount.jsp", false);
		
		
		return forward;
	}

}
