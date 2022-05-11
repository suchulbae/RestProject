package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.reservationDTO.ResvOrder;

public class ResvOrderManageService {

	public ArrayList<ResvOrder> getTodayResvOrder(String today) {
	Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		ArrayList<ResvOrder> todayResvList = adminDAO.selectTodayOrder(today);
		
		close(con);
		
		
		
		
		return todayResvList;
	}

}

