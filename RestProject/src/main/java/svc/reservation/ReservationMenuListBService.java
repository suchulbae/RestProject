package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;

public class ReservationMenuListBService {

	public ArrayList<ResvMenuDTO> getResvMenu2List() {
			Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		
		ArrayList<ResvMenuDTO> resvMenuList2= memberDAO.selectReservationMenu2List();
		
		close(con);
		
		
		
		
		
		return resvMenuList2;
	}

}
