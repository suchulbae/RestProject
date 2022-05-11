package svc.memberSVC;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Address;
import vo.MemberDTO;

public class MemberViewService {

	public MemberDTO getMemberInfo(String viewId) {
	
		Connection con =  getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberDTO  memberInfo = memberDAO.selectMemberInfo(viewId);
		close(con);
		return memberInfo;
	}

	public Address getAddressInfo(String viewId) {
		Connection con =  getConnection();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		Address memberAddrInfo = memberDAO.selectMemberAddrInfo(viewId);
		
		close(con);
		
		return memberAddrInfo;
	}

}
