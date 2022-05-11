package svc.reservation;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;

public class ReservationMenuService {

	public ArrayList<ResvMenuDTO> getResvMenuList() {
		
		//CONNECTION 풀 부터 
		Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		
		ArrayList<ResvMenuDTO> resvMenuList= memberDAO.selectReservationMenuList();
		
		close(con);
		
		
		
		
		
		return resvMenuList;
	}

	
	
	
	
}
