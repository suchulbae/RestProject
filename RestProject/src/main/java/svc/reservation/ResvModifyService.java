package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.reservationDTO.ReservationDelete;

public class ResvModifyService {

	public boolean resvModify(ReservationDelete modyfyDate) {
Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		
		int resvModifySuccess=memberDAO.resvModify(modyfyDate);
		System.out.println(resvModifySuccess);
		boolean isModifyResvResult = false;
	
		
		if(resvModifySuccess>0) {
			isModifyResvResult =true;
			System.out.println(isModifyResvResult);
		
		commit(con); //커밋으로 영구저장
			
		}else {
			rollback(con); // 실패시 롤백
		}
		//사용후 잘닫아주기 서버과부하 방지
		close(con);
		
		return isModifyResvResult;
		
		
	}
	
	
	

}
