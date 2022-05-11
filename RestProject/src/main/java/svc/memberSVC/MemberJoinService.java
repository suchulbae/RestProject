package svc.memberSVC;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Address;
import vo.MemberDTO;

public class MemberJoinService {

	public boolean join(MemberDTO member,Address addr) {
		Connection con =  getConnection(); // 바로 호출해서 사용 가능 (클래스명(JdbcUtil)생략가능) -> 이유: import static db.JdbcUtil.*; 해줬기 때문
		
		// 2.  memberDAO 객체 생성
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 3. DB작업에 사용될 Connection객체를 UserDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		memberDAO.setConnection(con);
		
		int insertMemberCount  = memberDAO.insertMember(member);
		int insertAddrCount  = memberDAO.insertAddr(addr);
		boolean isMemberJoinResult = false;
		
		if(insertMemberCount > 0 && insertAddrCount > 0) { // 회원가입에 성공하면
			isMemberJoinResult = true;
			
			commit(con);
		}else {
			rollback(con);
		}
		// 4. 해제
		close(con); // Connection 객체 해제
		
		return isMemberJoinResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
