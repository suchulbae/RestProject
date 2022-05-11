package svc.memberSVC;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberDTO;


public class MemberIdFindService {

	public MemberDTO findId(String mEMAIL){
		/*
		 * 	Service 제작순서
		 * con객체 생성-> MemberDAO 객체 생성-> DB연결을 위해 memberDAO와 커넥션 연결
		 */
		
		Connection con =  getConnection(); // 바로 호출해서 사용 가능 (클래스명(JdbcUtil)생략가능) -> 이유: import static db.JdbcUtil.*; 해줬기 때문
		
		// 2.  memberDAO 객체 생성
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 3. DB작업에 사용될 Connection객체를 UserDAO의 멤버변수에 전달하여 DB와 연결하여 작업하도록 서비스 해줌
		memberDAO.setConnection(con);
		
		
		// findId 한걸 memberInfo 에저장 findId 메서드에서 mEMAIL 로 비교한값 담김
		MemberDTO memberInfo = memberDAO.findId(mEMAIL);
		
		
		
		//db 해제 꼭해줘야함!
		
		close(con);
		
		
		
		
		
		return memberInfo;
		
		
		
		
		
	}
	
	
	
}
