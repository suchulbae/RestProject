package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.AdminDAO;

public class MonthResvSalesService {

	public int getresvMonthTotalMoney(String resvMonth) {
	Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);		
		
		
		int resvMonthTotalMoney = adminDAO.selectMonthTotalMoney(resvMonth);
		
		
		
		
		
		close(con);
		
		return resvMonthTotalMoney;
	}

}
