package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;

public class ReservationMenuListCService {

	public ArrayList<ResvMenuDTO> getResvMenu3List() {
		
		Connection con =  getConnection(); 
		
	MemberDAO memberDAO = MemberDAO.getInstance();
	
	memberDAO.setConnection(con);
	
	
	ArrayList<ResvMenuDTO> resvMenuList3= memberDAO.selectReservationMenu3List();
	
	close(con);
	
	
	
	
	
	return resvMenuList3;
	}

}
