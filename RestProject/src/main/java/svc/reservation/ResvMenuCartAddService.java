package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.RevCart;

public class ResvMenuCartAddService {

	
		public ResvMenuDTO getResvMenuView(String menuID) {
			Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		ResvMenuDTO rsvMenuInfo = memberDAO.selectRsvMenuInfo(menuID);
	
		
		close(con);
		
		
		
		
		
		return rsvMenuInfo;
		
	}

		public void addCart(HttpServletRequest request, ResvMenuDTO resMenuInfo) {
			HttpSession session = request.getSession();
			ArrayList<RevCart>cartList = (ArrayList<RevCart>)session.getAttribute("cartList");
			
			if(cartList == null) {
				cartList = new ArrayList<RevCart>();
				session.setAttribute("cartList", cartList);
			}
			
			boolean isNewCart = true;
			for(int i = 0; i < cartList.size(); i++) {
				if(resMenuInfo.getMenuID().equals(cartList.get(i).getMenuID())) {
					isNewCart = false;
					cartList.get(i).setQty(cartList.get(i).getQty() + 1);
					break;
				}
			}
			
			if(isNewCart) {
				RevCart	revCart = new RevCart();
				
				revCart.setMenuID(resMenuInfo.getMenuID());
				revCart.setCategory(resMenuInfo.getCategory());
				revCart.setMenuNAME(resMenuInfo.getMenuNAME());
				revCart.setResvPRICE(resMenuInfo.getResvPRICE());
				revCart.setImage(resMenuInfo.getImage());
				revCart.setResvORDERDATE(resMenuInfo.getResvORDERDATE());
				revCart.setQty(1);
				
				cartList.add(revCart);// cartList에 추가
			}
			
			
			
		}

}
