package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.reservationDTO.ResvOrder;

public class ResvNomalService {

	public ArrayList<ResvOrder> getMonthView() {

		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		 ArrayList<ResvOrder> resvMonthView = adminDAO.selectResvMonth();
		
		
			close(con);
		
		
		
		
		
		return resvMonthView;
	}
	
	

	
	
	
	
	
	
	
	

	public ArrayList<ResvOrder> getMonthTotalView() {
	Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		 ArrayList<ResvOrder> resvTotalview = adminDAO.getMonthTotal();
		
		
			close(con);
		
		
		
		
		
		return resvTotalview;
	}












	public int getminusdayMoney() {
			Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int minusdayMoney = adminDAO.getminusdayMoney();
		
		
			close(con);
		return minusdayMoney;
	}












	public int getminusdayMoney2() {
		Connection con = getConnection();
		
	AdminDAO adminDAO = AdminDAO.getInstance();
	
	adminDAO.setConnection(con);
	
	int minusdayMoney2 = adminDAO.getminusdayMoney2();
	
	
		close(con);
	return minusdayMoney2;
	}












	public int getminusdayMoney3() {
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int minusdayMoney3 = adminDAO.getminusdayMoney3();
		
		
			close(con);
		return minusdayMoney3;
	}












	public int getminusdayMoney4() {
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int minusdayMoney4 = adminDAO.getminusdayMoney4();
		
		
			close(con);
		return minusdayMoney4;
	}












	public int getminusdayMoney5() {
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int minusdayMoney5 = adminDAO.getminusdayMoney5();
		
		
			close(con);
		return minusdayMoney5;
	}




	public int getminusdayMoney6() {
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int minusdayMoney6 = adminDAO.getminusdayMoney6();
		
		
			close(con);
		return minusdayMoney6;
	}




}




