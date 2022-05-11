package svc.memberSVC;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;

import vo.MemberDTO;


public class MemberHashPwFindService {

	
	
	
	
	//서비스 로직 메서드로 구현
	
	public MemberDTO findHashPw(String mID, String mEMAIL) {
		Connection con =  getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		
		
		MemberDTO memberInfo = memberDAO.findHashPw(mID, mEMAIL);
		
		//db 꼭닫기
		close(con);
		
		
		return memberInfo;
		
	}

	public boolean setHashPw(String mID, String mEMAIL, String random_password) {
		Connection con =  getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int setHashPwCount = memberDAO.setHashPw(mID,mEMAIL,random_password);
		
	
		
		boolean isSetHashPwResult = false;
		if(setHashPwCount > 0) {
			isSetHashPwResult = true;
			commit(con);
		}else {
			rollback(con); // 그전 상태로 돌려줌
		}
		
		// 4. 해제
		close(con);
		
		
		
		return isSetHashPwResult;
	}
	
	
	
}
