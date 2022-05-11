package svc.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import vo.reservationDTO.RevCart;

public class ResvMenuCartListService {

	public ArrayList<RevCart> getCartList(HttpServletRequest request) {
		ArrayList<RevCart> cartList =null;
		HttpSession session = request.getSession();
		cartList = (ArrayList<RevCart>) session.getAttribute("cartList");
		return cartList;
	}

}
