package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import dao.MemberDAO;
import vo.reservationDTO.ResvOrder;

public class ResvLimitTableService {

	public int selectTable(String limitTime) {
		Connection con = getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		memberDAO.setConnection(con);
		
		int resvOrder = memberDAO.selectTable( limitTime);
		
		close(con);
		
		return resvOrder;

	}

	public int selectTable() {
		Connection con = getConnection();

		MemberDAO memberDAO = MemberDAO.getInstance();

		memberDAO.setConnection(con);
		
		int resvOrder = memberDAO.selectLimitTable();
		
		close(con);
		
		return resvOrder;

	}

}
