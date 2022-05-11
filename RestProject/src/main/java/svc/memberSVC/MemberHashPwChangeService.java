package svc.memberSVC;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberPwChange;

public class MemberHashPwChangeService {

	public boolean changePw(MemberPwChange memberPwChange) {
		Connection con =  getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int chagngePwCount = memberDAO.changeHashPw(memberPwChange);
		
		
		boolean isChagePwResult = false;
		if(chagngePwCount > 0) {
			isChagePwResult = true;
			commit(con);
		}else {
			rollback(con);
		}
		// 4. 해제
		close(con); // Connection 객체 해제
		
		return isChagePwResult;
		
		
	}
	
	
	

}
