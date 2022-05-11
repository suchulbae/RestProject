package svc.memberSVC;

import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.MemberDAO;
import vo.Address;
import vo.MemberDTO;

public class MemberUpdateService {

	public boolean memberUpdate(MemberDTO member, Address addr) {
		Connection con =  getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int updateMemberCount = memberDAO.updateMember(member);// 성공하면 1 돌려받음
		int updateMemberAddrCount = memberDAO.updateAddr(addr);
		
		boolean isMemberUpdateResult = false;
		
		if(updateMemberCount>0 && 0<updateMemberAddrCount) {
			isMemberUpdateResult = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return isMemberUpdateResult;
	
	}

}
