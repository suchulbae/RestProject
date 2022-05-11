package svc.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.reservationDTO.RevCart;

public class ResvMenuCartRemoveAllService {

	public void cartRemoveAll(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ArrayList<RevCart> cartList = (ArrayList<RevCart>) session.getAttribute("cartList");

		session.removeAttribute("cartList");
	}

}
