package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.reservationDTO.ResvOrder;
import vo.reservationDTO.ResvOrderDetail;

public class ResvOrderDetailService {

	public ArrayList<ResvOrderDetail> getResvDetail(int order_num) {
	
		
		
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		ArrayList<ResvOrderDetail> resvOrderDetail = adminDAO.selectOrderDetail(order_num);
		
		close(con);
		
		
		
		
		return resvOrderDetail;
		
		
		
		
		
		

	}

}
