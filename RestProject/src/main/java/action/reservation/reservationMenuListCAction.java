package action.reservation;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.reservation.ReservationMenuListCService;
import svc.reservation.ReservationMenuService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;

public class reservationMenuListCAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		
		
		ReservationMenuListCService reservationMenuCService = new ReservationMenuListCService();
		ArrayList<ResvMenuDTO> resvMenuList3= reservationMenuCService.getResvMenu3List(); // 상품 등록 될때마다 추가되기때문에 arrayList 로 처리
		
		
		ArrayList<String> todayview = new ArrayList<String>();//오늘본상품 저장할 리스트
		//본게있다면 쿠키에 저장하면 간단
		Cookie[]cookieArray =request.getCookies();
		
		if(cookieArray != null) {
			for(int i=0;i<cookieArray.length;i++){	//배열은 for와 친하다
			if(cookieArray[i].getName().startsWith("today")) {// cookieArray[i].getName()이 today로 시작하니
				todayview.add(cookieArray[i].getValue());
			}
				
				
				
				
			}
		}
		request.setAttribute("resvMenuList3", resvMenuList3);
		request.setAttribute("showRsvMenu", "/reservationMenu/revSalad.jsp");
	
		forward=new ActionForward("reservationTemplate.jsp",false);
		
		return forward;
	}

}
