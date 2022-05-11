package svc.admin;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MealKitDAO;
import vo.MealKit;

public class MealViewService {
	// 멤버변수
	// 기본 생성자
	// 메서드
	
	public MealKit getMealView(String meal_id) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();// static으로 가져와 JdbcUtil(클래스이름)생략가능 

		// 2. 싱글톤 패턴 MealKitDAO 객체 생성
		MealKitDAO mealKitDAO = MealKitDAO.getInstance();// 바로 호출해서 사용가능(import static db.JdbcUtil.*;)

		// 3. DB작업에 사용될 Connection객체를 MealKitDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		mealKitDAO.setConnection(con);

		/** ---- DAO의 해당 메서드를 호출하여 처리 ---- **/
		MealKit mealKitInfo = mealKitDAO.selectMealKitInfo(meal_id);
		
		/*-(insert,update,delete) 성공하면 commit 
		 *  실패하면 rollback(select 제외)---*/

		// 4. 해제
		close(con); // Connection 객체 해제

		return mealKitInfo;
	}

}
