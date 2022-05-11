package svc.memberSVC;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberDELETE;
import vo.MemberDTO;

public class MemberDELETEservice { // mysql을  처리한 부분의 결과를 인트로 반환받아 조건이 만족되면 트루로 다시 반환해주는 서비스 로직 

	public boolean deleteMember(MemberDELETE delete) {
		
		Connection con =getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		 
		
		
		
		
		int deletememberCount = memberDAO.deleteMember(delete);
		
		boolean isMemberDeleteResult =false;// 아랫 조건 만족하면 트루로 변환후 반환
		
		if(deletememberCount>0) { // 삭제가 되었다면
			isMemberDeleteResult =true;
			
			
		commit(con); //커밋으로 영구저장
			
		}else {
			rollback(con); // 실패시 롤백
		}
		//사용후 잘닫아주기 서버과부하 방지
		close(con);
		
		return isMemberDeleteResult; // 결과반환후 다시 액션으로 
		
		
	}

	
	
	
	

	
	
	
	
	
}
