package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.Order;

public class TotalOrderManageService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public ArrayList<Order> getTotalOrderList() {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 : OrderDAO객체 생성
		OrderDAO orderDAO = OrderDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 OrderDAO의 멤버변수로 전달하여 DB연결하여 작업하도록 서비스해줌
		orderDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		ArrayList<Order> totalOrderList = orderDAO.selectTotalOrderList();

		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/

		// 4. 해제
		close(con);// Connection객체 해제

		return totalOrderList;
	}

}
