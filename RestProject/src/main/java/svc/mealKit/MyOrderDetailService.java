package svc.mealKit;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.OrderDetail;

public class MyOrderDetailService {
	// 멤버변수
		// 기본 생성자
		// 메서드
	
	public ArrayList<OrderDetail> getMyOrderDetailList(int meal_order_num) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능
											
		// 2. 싱글톤 패턴 OrderDAO 객체 생성
		OrderDAO orderDAO = OrderDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 OrderDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		orderDAO.setConnection(con);

		/*--- DAO의 해당 메서드를 호출하여 처리 ---*/
		ArrayList<OrderDetail> myOrderDetailList = orderDAO.selectMyOrderDetailList(meal_order_num);
		
		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/
		
		// 4. 해제
		close(con); // Connection 객체 해제
		
		return myOrderDetailList;
	}

}
