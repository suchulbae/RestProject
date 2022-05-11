package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.OrderDAO;

public class OrderGetService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public boolean orderGet(int meal_order_num) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 : OrderDAO객체 생성
		OrderDAO orderDAO = OrderDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 OrderDAO의 멤버변수로 전달하여 DB연결하여 작업하도록 서비스해줌
		orderDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		int updateOrderGetCount = orderDAO.updateOrderGet(meal_order_num);

		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/
		boolean isOrderGetResult = false;

		if (updateOrderGetCount > 0) {
			isOrderGetResult = true;
			commit(con);
		} else {
			rollback(con);
		}

		// 4. 해제
		close(con);// Connection객체 해제

		return isOrderGetResult;
	}

}
