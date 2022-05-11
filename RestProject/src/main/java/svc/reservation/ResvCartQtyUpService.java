package svc.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.reservationDTO.RevCart;



public class ResvCartQtyUpService {

	public void upCartQty(String menuID, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<RevCart> cartList = (ArrayList<RevCart>) session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			if(menuID.equals(cartList.get(i).getMenuID())) {
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
				break;
			}
		}
		
	}

}
