package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;

import vo.reservationDTO.ResvOrderDetail;

public class ReservationDetailInfoViewService {

	public  ArrayList<ResvOrderDetail> getResvDetailView(int order_num) {
		Connection con = getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		memberDAO.setConnection(con);
		
		ArrayList<ResvOrderDetail> reservationDetailInfoView = memberDAO.selectDetailOrder(order_num);
		
		close(con);
		
		return reservationDetailInfoView;
	}

}
