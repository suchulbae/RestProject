package svc.admin;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.AdminDAO;
import vo.reservationDTO.ResvMenuDTO;

public class ResvMenuAddService {

	public boolean addResvMenu(ResvMenuDTO newResvMenu) {
		
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		int insertNewResvMenuCount = adminDAO.insertNewResvMenu(newResvMenu);
		
		boolean isResvAddMenuResult =false;
		
		if(insertNewResvMenuCount > 0) {
			isResvAddMenuResult =true;
			commit(con);
		} else {
			rollback(con);
		}

		
		close(con);
		
		
		
		
		return isResvAddMenuResult;
	}

}
