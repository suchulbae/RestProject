package svc.admin;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MealKitDAO;
import vo.MealKit;

public class MealKitUpdateService {

	public boolean updateMealKit(MealKit newMealKit) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능

		// 2. 싱글톤 패턴 MealKitDAO 객체 생성
		MealKitDAO mealKitDAO = MealKitDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 MealKitDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		mealKitDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		int updateMealKitCount = mealKitDAO.updateMealKit(newMealKit);
		
		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/
		boolean isUpdateMealKitResult = false;

		if (updateMealKitCount > 0) {
			isUpdateMealKitResult = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		return isUpdateMealKitResult;
	}

}
