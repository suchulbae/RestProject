package svc.mealKit;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MealKitDAO;
import dao.OrderDAO;
import vo.MealKit;
import vo.Order;

public class MealKitCartOrderService {
	// 멤버변수
	// 기본 생성자
	// 메서드

	public boolean orderMealKit(String mID, String mEMAIL, ArrayList<MealKit> mealKitList, int saleTotalMoney) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 MealKitDAO 객체 생성
		MealKitDAO mealKitDAO = MealKitDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 MenuDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		mealKitDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		int insertOrderMealKitCount = mealKitDAO.insertMealKitInfo(mID, mEMAIL, mealKitList, saleTotalMoney);

		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/
		boolean isOrderMealResult = false;

		if (insertOrderMealKitCount > 0) {
			isOrderMealResult = true;
			commit(con);
		} else {
			rollback(con);
		}

		// 4. 해제
		close(con); // Connection 객체 해제

		return isOrderMealResult;
	}

	public Order memberLastOrder(String mID) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 orderDAO 객체 생성
		OrderDAO orderDAO = OrderDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 OrderDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		orderDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		Order latestOrder = orderDAO.selectLatestOrder(mID);

		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/

		// 4. 해제
		close(con); // Connection 객체 해제

		return latestOrder;
	}

}
