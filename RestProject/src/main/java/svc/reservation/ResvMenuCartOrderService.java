package svc.reservation;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;


import dao.MemberDAO;
import dao.ResvOrderDAO;
import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.ResvOrder;

public class ResvMenuCartOrderService {

	public boolean orderMenu(String mID, String mEMAIL, ArrayList<ResvMenuDTO> rsvMenuList, int saleTotalMoney, String resvDate) {

		Connection con = getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		memberDAO.setConnection(con);
		
		int insertOrderMenuCount = memberDAO.insertOrderMenu(mID,mEMAIL,rsvMenuList,saleTotalMoney,resvDate);
		
		boolean isOrderMenuResult = false;
		
		if(insertOrderMenuCount > 0) {
			isOrderMenuResult = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);

		return isOrderMenuResult;
	}

	public  ResvOrder memberResvLastOrder(String mID) {
		Connection con = getConnection();

		ResvOrderDAO resvOrderDAO = ResvOrderDAO.getInstance();

		resvOrderDAO.setConnection(con);
		
		ResvOrder latestResvOrder = resvOrderDAO.selectLatestResvOrder(mID);
		
		
		
		close(con);

		return latestResvOrder;
	}





}
