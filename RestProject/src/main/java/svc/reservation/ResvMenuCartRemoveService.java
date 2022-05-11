package svc.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.reservationDTO.RevCart;

public class ResvMenuCartRemoveService {

	public void cartRemove(String menuID, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		ArrayList<RevCart> cartList = (ArrayList<RevCart>) session.getAttribute("cartList");

		for(int i=0;i<cartList.size();i++) {
			if(cartList.get(i).getMenuID().equals(menuID) ) {
				cartList.remove(cartList.get(i)); 
				break;
			}
		
		
	}

	}
}
