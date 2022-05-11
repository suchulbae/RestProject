package action.reservation;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.reservation.ReservationMenuService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;

public class reservationMenuListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		ReservationMenuService reservationMenuService = new ReservationMenuService();
		ArrayList<ResvMenuDTO> resvCourseMenuList = reservationMenuService.getResvMenuList(); // 상품 등록 될때마다 추가되기때문에
																								// arrayList 로 처리

	
	
		request.setAttribute("resvCourseMenuList", resvCourseMenuList);
		request.setAttribute("showRsvMenu", "/reservationMenu/rsvCourse.jsp");

		forward = new ActionForward("reservationTemplate.jsp", false);

		return forward;

	}

}
