package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;

public class ResMenuViewService {

	
		public ResvMenuDTO getResvMenuView(String menuID) {
			Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		ResvMenuDTO rsvMenuInfo = memberDAO.selectRsvMenuInfo(menuID);
	
		
		close(con);
		
		
		
		
		
		return rsvMenuInfo;
	
	}

}
