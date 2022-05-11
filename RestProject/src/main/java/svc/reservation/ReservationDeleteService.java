package svc.reservation;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.reservationDTO.ReservationDelete;

public class ReservationDeleteService {

	public boolean deleteResv(ReservationDelete delete) {
		Connection con =  getConnection(); 
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		
		
		int deleteResv=memberDAO.deleteResv(delete);
		
		boolean isdeleteResvResult =false;
		
		
		if(deleteResv>0) { // 삭제가 되었다면
			isdeleteResvResult =true;
			
		
		commit(con); //커밋으로 영구저장
			
		}else {
			rollback(con); // 실패시 롤백
		}
		//사용후 잘닫아주기 서버과부하 방지
		close(con);
		
		return isdeleteResvResult;
		
		
	}
	
	
	
	
	
}
