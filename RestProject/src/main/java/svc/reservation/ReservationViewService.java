package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.ResvOrder;

public class ReservationViewService {

	public ArrayList<ResvOrder> getresvOrder(String mID, String mEMAIL) {
		
		Connection con = getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		memberDAO.setConnection(con);
		
		ArrayList<ResvOrder> resvOrder = memberDAO.selectResvOrder(mID,mEMAIL);
		
		close(con);
		
		return resvOrder;
	}


	public ResvMenuDTO getResvMenuView(String menuID) {
		Connection con =  getConnection(); 
	
	MemberDAO memberDAO = MemberDAO.getInstance();
	
	memberDAO.setConnection(con);
	
	ResvMenuDTO rsvMenuInfo = memberDAO.selectRsvMenuInfo(menuID);

	
	close(con);
	
	
	
	
	
	return rsvMenuInfo;
	
	
	
	}

	

	
	
}
